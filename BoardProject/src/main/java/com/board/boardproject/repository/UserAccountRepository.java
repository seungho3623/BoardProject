package com.board.boardproject.repository;

import com.board.boardproject.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}