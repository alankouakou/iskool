package net.ycod3r.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ycod3r.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByRole(String role);

}
