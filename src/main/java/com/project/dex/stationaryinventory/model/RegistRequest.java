package com.project.dex.stationaryinventory.model;

import com.project.dex.stationaryinventory.jpa.entity.enums.RoleType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistRequest {
    
    private Long noInduk;

    private String username;

    private String password;

    private String email;

    private String telNo;

    private String name;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private boolean isActive;
}
