package com.yessenali.fleetapp.security.repositories;

import com.yessenali.fleetapp.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(
            value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id FROM user_role WHERE user_id = ?)",
            nativeQuery = true

    )
    Set<Role> getUserNotRoles(Integer userId);
}
