package net.projects.test_mvc.service;

/**
 * Service for Security.
 *
 * @author Sergey Lazarev
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    Boolean autoLogin(String username, String password);

    void logout();
}
