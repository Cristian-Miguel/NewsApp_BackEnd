package com.news.app.User.command.repository;

import com.news.app.User.shared.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommandRepository extends JpaRepository<UserEntity, Long> {
}
