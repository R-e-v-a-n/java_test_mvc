package net.projects.test_mvc.service;

import net.projects.test_mvc.model.User;

/**
 * Service class for {@link User}
 *
 * @author Sergey Lazarev
 * @version 1.0
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
