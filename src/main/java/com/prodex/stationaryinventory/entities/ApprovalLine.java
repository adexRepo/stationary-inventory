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
public class ApprovalLine extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long   approvalId    ;
    public String stationaryId  ;
    public String borrowerId    ;
    public String approverId    ;
    public Date   approvedAt    ;
    public Date   borrowAt      ;
    public Date   borrowUntil   ;
    public String remarkApprover;

}
