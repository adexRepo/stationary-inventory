package com.project.dex.stationaryinventory.entity;

import java.util.Date;

import com.project.dex.stationaryinventory.entity.enums.StationaryType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class StationaryOut {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long stationaryOutId;

    public Long stationaryId;

    @JoinColumn(name = "noInduk")
    public Borrowers borrowerId;
    
    @Enumerated(EnumType.STRING)
    public StationaryType stationaryType;

    public String nameStationary;

    public String takenBy;

    public Date takenAt;

    public Date returneturnAt;
    public Date promiseReturnAt;

    public Long quantity;
    
    public String remarkBorrower;

}
