package com.prodex.stationaryinventory.entities;

import java.util.Date;

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

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class StationaryEnter extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long stationaryId;

    public String stationaryType;

    public String nameStationary;

    public String receivedBy;

    public Date receivedAt;

    public Long quantity;

    public boolean isEntered;

    public String remarkReceiver;

}
