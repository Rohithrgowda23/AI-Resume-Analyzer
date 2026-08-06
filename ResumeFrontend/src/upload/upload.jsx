import { toast } from "react-toastify"
import Styles from "./upload.module.css"
import { useContext } from "react"
import { UserContext } from "../context/usercontext";
import { useNavigate } from "react-router-dom";
function Uploadpage() {


    const { serviceURL } = useContext(UserContext)
    const navigate=useNavigate()
    const validate = () => {
        const inp = document.getElementById("resume")
        const file = inp.files[0]
        if (!['application/pdf',
            'application/msword',
            'application/vnd.openxmlformats-officedocument.wordprocessingml.document'].includes(file.type)) {
            toast.error("Upload a resume in pdf/doc format ")
            inp.value = "";
            document.getElementById("indication").textContent = "No file uploaded"
        }
        else if (file.size > 2 * 1024 * 1024) {
            toast.error("Upload a file less than 2MB")
            inp.value = ""
            document.getElementById("indication").textContent = "No file uploaded"
        }
        else {
            const str = file.name;
            if (str.length <= 20) {
                document.getElementById("indication").textContent = str
            }
            else {
                document.getElementById("indication").textContent = str.substring(0, 9) + "..." + str.substring(str.length - 7, str.length)
            }
        }

    }

    // Job Description is optional, so this only trims for a friendlier payload -
    // it is never required for the form to submit.
    const jdCharCount = (event) => {
        const counter = document.getElementById("jdcount")
        if (counter) {
            counter.textContent = `${event.target.value.length}/6000`
        }
    }

    const analysedoc = (event) => {
        event.preventDefault()
        const uploadform = document.getElementById("upform")
        var formdata = new FormData(uploadform)
        if (formdata.get("roles").trim() === "") {
            toast.warn("Role must not be empty")
            return;
        }
        if (!formdata.get("file") || !formdata.get("file").name) {
            toast.warn("Please upload the resume")
            return;
        }
        // Job Description is optional. If left blank we still send an empty string,
        // which the backend treats identically to not sending it at all - Job Role
        // alone continues to drive the analysis exactly as before.
        document.getElementById("animate").style.display = "flex";
        fetch(`${serviceURL}/extract`, {
            method: "POST",
            body: formdata,
            headers: { "Authorization": `Bearer ${localStorage.getItem("token")}` }
        }).then(response => {
            if (response.ok) {
                document.getElementById("upform").reset()
                document.getElementById("animate").style.display = "none";
                document.getElementById("indication").textContent = "No file uploaded"
                const counter = document.getElementById("jdcount")
                if (counter) counter.textContent = "0/6000"
                navigate("/analysereport")
            }
            else if (response.status === 401) {
                document.getElementById("animate").style.display = "none";
                toast.error("Your session has expired. Please log in again.")
                navigate("/login")
            }
            else if (response.status === 406) {
                document.getElementById("upform").reset()
                toast.error("This resume doesn't appear relevant to the role entered. Please check both and try again.")
                document.getElementById("animate").style.display = "none";
                document.getElementById("indication").textContent = "No file uploaded"
            }
            else {
                document.getElementById("upform").reset()
                toast.error("Something went wrong while analysing your resume. Please try again.")
                document.getElementById("animate").style.display = "none";
                document.getElementById("indication").textContent = "No file uploaded"
            }
        })
            .catch(() => {
                toast.error("Network error")
                document.getElementById("animate").style.display = "none";
            })
    }
    return (
        <div className={Styles.container}>
            <div className={Styles.nav}>
                <h1>Resume Analyser</h1>
                <button onClick={()=>navigate("/")}>Home</button>
            </div>

            <div className={Styles.uploadcontainer}>
                <h2>Upload Resume</h2>
                <form id="upform" encType="multipart/form-data" >
                    <label className={Styles.uploadcontainerlabel} htmlFor="roles" >Role</label>
                    <input type="text" autoComplete="off" placeholder="Ex : Software Engineer " name="roles" id="roles" />

                    <label className={Styles.uploadcontainerlabel} htmlFor="jobDescription">
                        Job Description <span className={Styles.optionalTag}>(optional)</span>
                    </label>
                    <textarea
                        className={Styles.jdTextarea}
                        name="jobDescription"
                        id="jobDescription"
                        maxLength={6000}
                        rows={6}
                        autoComplete="off"
                        placeholder="Paste the job posting here to get more targeted job recommendations - skills, tech stack, experience level, and location get pulled out automatically."
                        onChange={jdCharCount}
                    />
                    <span id="jdcount" className={Styles.jdCount}>0/6000</span>

                    <label htmlFor="resume" className={Styles.fileinp}>
                        <p> Upload  your resume here</p>
                        <h5>Select File</h5>
                        <span id="indication" className={Styles.spn}>No file uploaded</span>
                    </label>
                    <input type="file" name="file" onChange={validate} id="resume" hidden accept=".pdf,.doc,.docx" />
                    <button onClick={analysedoc}>Analyse</button>
                </form>
            </div>
            <div className={Styles.guidelinescontainer} >
                <h2>Guidelines</h2>
                <ul>
                    <li><span>File Format: </span>Upload your resume in PDF or DOC/DOCX format only.</li>
                    <li><span>File Size: </span>Ensure your file size is less than 2 MB.</li>
                    <li><span>Language: </span>Upload your resume only in English</li>
                    <li><span>Job Description: </span>Optional, but pasting one in gets you more relevant job recommendations.</li>
                </ul>
            </div>
            <div className={Styles.loadani} id="animate">

                <div className={Styles.loadanimation}>
                    <div className={Styles.capstart}></div>
                    <div className={Styles.loadblock}></div>
                </div>
                <h1>Analysing Resume</h1>

            </div>
        </div>
    )
}

export default Uploadpage
