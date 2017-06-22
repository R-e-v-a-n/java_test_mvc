package net.projects.test_mvc.dao;

import net.projects.test_mvc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long>{
}
