package com.board.boardproject.repository;

import com.board.boardproject.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserSecurityRepository extends JpaRepository<UserAccount, String> {
    Optional<UserAccount> findByUserId(String username);
}