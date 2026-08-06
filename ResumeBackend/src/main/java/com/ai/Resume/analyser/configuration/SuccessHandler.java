package com.ai.Resume.analyser.configuration;

import com.ai.Resume.analyser.service.JwtService;
import com.ai.Resume.analyser.entity.UsersTable;
import com.ai.Resume.analyser.repository.UsersTableRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SuccessHandler implements AuthenticationSuccessHandler {

    private final UsersTableRepo usersTableRepository;
    private final JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Map<String, Object> userData = oAuth2User.getAttributes();

        String email = userData.get("email").toString();
        String name = userData.get("name").toString();

        if (!usersTableRepository.existsById(email)) {

            UsersTable newUser = UsersTable.builder()
                    .username(name)
                    .email(email)
                    .password("")
                    .previousResults(false)
                    .resetOtp(null)
                    .resetExpiration(null)
                    .build();

            usersTableRepository.save(newUser);
        }

        String token = jwtService.generateToken(email);

        response.sendRedirect(
                "http://localhost:5173/?token=" + token
        );
    }
}