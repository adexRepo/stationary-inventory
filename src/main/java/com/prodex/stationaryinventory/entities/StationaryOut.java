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
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
@EqualsAndHashCode(callSuper = false)
public class StationaryOut extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long   stationaryOutId;
    
    public Long   stationaryId   ;
    public String borrowerId     ;
    public String stationaryType ;
    public String nameStationary ;
    public String takenBy        ;
    public Date   takenAt        ;
    public Date   returneturnAt  ;
    public Date   promiseReturnAt;
    public Long   quantity       ;
    public String remarkBorrower ;

}
