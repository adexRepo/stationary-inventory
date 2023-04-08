package com.prodex.stationaryinventory.entities;

import com.prodex.stationaryinventory.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Borrower extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id           ;
    private String borrowerType ;
    private String name         ;
    private String email        ;
    private String telNo        ;
    private Long   noInduk      ;
    private Long   totalBorrow  ;
    private Long   totalReturn  ;

}
