package com.project.dex.stationaryinventory.jpa.entity;

import java.util.Date;

import com.project.dex.stationaryinventory.jpa.entity.enums.StationaryType;

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
public class StationaryEnter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long stationaryId;
    
    @Enumerated(EnumType.STRING)
    public StationaryType stationaryType;

    public String nameStationary;

    @JoinColumn(name="user_id")
    public UserBase receivedBy;

    public Date receivedAt;

    public Long quantity;

    public boolean isEntered;

    public String remarkReceiver;

}
