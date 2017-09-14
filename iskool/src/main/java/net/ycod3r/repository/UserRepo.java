package net.ycod3r.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ycod3r.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUsername(String name);

}
