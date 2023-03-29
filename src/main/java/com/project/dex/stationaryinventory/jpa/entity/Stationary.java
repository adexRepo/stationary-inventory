package com.project.dex.stationaryinventory.jpa.entity;

import com.project.dex.stationaryinventory.jpa.entity.enums.StationaryType;

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
public class Stationary {
    
    @Id
    public Long stationaryId;
    
    @Enumerated(EnumType.STRING)
    public StationaryType stationaryType;
    
    public String nameStationary;

    public String quantity;

    public boolean isStationaryOk;

    public String remarkStaff;

}
