package com.project.dex.stationaryinventory.jpa.entity;

import com.project.dex.stationaryinventory.jpa.entity.enums.RoleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class UserBase {
    
    @Id
    public Long noInduk;

    @Column(name="username",unique = true)
    public String username;

    public String password;

    @Column(name="email",unique = true)
    public String email;

    public String telNo;

    public String name;

    @Enumerated(EnumType.STRING)
    public RoleType role;

    public boolean isActive;

    public boolean isLogin;
    
}
