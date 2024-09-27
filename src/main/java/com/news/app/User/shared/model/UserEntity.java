package com.news.app.User.shared.model;

import com.news.app.Common.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue
    Long id;

    @UuidGenerator
    @Column(nullable = false)
    String uuid;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    Date createDate;

    @Column(nullable = false)
    Date lastLogger;

    @Column(nullable = false)
    Date lastUpdate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Roles role;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    Date birthDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
