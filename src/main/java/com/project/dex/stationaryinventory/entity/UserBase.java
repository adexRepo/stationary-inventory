package com.project.dex.stationaryinventory.entity;

import com.project.dex.stationaryinventory.entity.enums.RoleType;

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
    public String userId;

    public Long noInduk;

    public String name;

    @Enumerated(EnumType.STRING)
    public RoleType role;

    public boolean isActive;

    

}
