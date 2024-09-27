package com.news.app.User.query.repository;

import com.news.app.User.shared.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQueryRepository  extends JpaRepository<UserEntity, Long> {
}
