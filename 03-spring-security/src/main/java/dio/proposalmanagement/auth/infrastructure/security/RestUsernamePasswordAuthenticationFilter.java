package dio.proposalmanagement.auth.infrastructure.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class RestUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;

    public RestUsernamePasswordAuthenticationFilter(AuthenticationConfiguration authenticationConfiguration,
                                                    ObjectMapper objectMapper) {
        super(authenticationConfiguration.getAuthenticationManager());
        this.objectMapper = objectMapper;
        setFilterProcessesUrl("/api/auth/login");
        setAuthenticationSuccessHandler((request, response, authentication) -> {
            response.setStatus(HttpServletResponse.SC_OK);
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            var loginRequest = objectMapper.readValue(request.getInputStream(), LoginRequest.class);

            var token = UsernamePasswordAuthenticationToken.unauthenticated(
                    loginRequest.username(),
                    loginRequest.password());

            return getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public record LoginRequest(String username, String password) {
    }
}
