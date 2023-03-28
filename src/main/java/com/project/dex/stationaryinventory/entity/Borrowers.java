package com.project.dex.stationaryinventory.entity;

import com.project.dex.stationaryinventory.entity.enums.BorrowerType;

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
public class Borrowers {

    @Id
    public Long noInduk;

    @Enumerated(EnumType.STRING)
    public BorrowerType borrowerType;
    
    public String name;

    public Long totalBorrow;
    
    public Long totalReturn;
}
