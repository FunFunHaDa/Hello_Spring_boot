package com.hello.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserReposity extends JpaRepository<User, Long>{
	User findByUserID(String UserID);
}
