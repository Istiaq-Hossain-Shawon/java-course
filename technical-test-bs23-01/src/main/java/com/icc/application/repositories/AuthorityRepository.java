package com.icc.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icc.application.model.Role;

@Repository
public interface AuthorityRepository extends JpaRepository<Role, Long> {
	Role findByRoleName(String roleName);
}