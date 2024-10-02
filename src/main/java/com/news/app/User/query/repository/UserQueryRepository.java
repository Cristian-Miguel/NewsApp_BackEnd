package com.news.app.User.query.repository;

import com.news.app.User.shared.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserQueryRepository  extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    @Query(value = "SELECT u FROM UserEntity u WHERE u.uuid = :uuid")
    Optional<UserEntity> findByUUID(String uuid);

    @Query(value = "SELECT u FROM UserEntity u WHERE u.email = :email")
    Optional<UserEntity> findUserByEmail(String email);

}
