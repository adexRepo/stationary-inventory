package com.prodex.stationaryinventory.models;

import com.prodex.stationaryinventory.common.enums.RoleType;

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

    private Long idEmployee;
    private String idDepartement;
    private String username;
    private String password;
    private String telNo;
    private String firstName;
    private String lastName;
    private String fullName;
}
