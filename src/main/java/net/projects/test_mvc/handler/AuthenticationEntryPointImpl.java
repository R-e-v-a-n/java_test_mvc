package net.projects.test_mvc.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;


/**
 * Implementation of {@link AuthenticationEntryPoint} interface.
 *
 * @author Sergey Lazarev
 * @version 1.0
 */

public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {
        response.sendRedirect("/login");
    }
}
