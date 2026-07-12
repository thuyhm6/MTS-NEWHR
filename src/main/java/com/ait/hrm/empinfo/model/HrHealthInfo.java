package com.ait.hrm.empinfo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * HrHealthInfo Model - Thông tin sức khỏe (bảng HR_HEALTH_INFO)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrHealthInfo {

    /**
     * Mã sức khỏe (HEALTH_NO)
     */
    private String healthNo;

    /**
     * ID cá nhân (PERSON_ID)
     */
    private String personId;

    /**
     * Loại khám (HEALTH_TYPE)
     */
    private String healthType;

    /**
     * Chiều cao (HEIGHT)
     */
    private String height;

    /**
     * Cân nặng (WEIGHT)
     */
    private String weight;

    /**
     * Tiền sử bệnh (HISTORY_DISEASE)
     */
    private String historyDisease;

    /**
     * Nhóm máu (BLOOD_GROUP)
     */
    private String bloodGroup;

    /**
     * Số vắc xin 1 (VACXIN_NO1)
     */
    private String vacxinNo1;

    /**
     * Số vắc xin 2 (VACXIN_NO2)
     */
    private String vacxinNo2;

    /**
     * Nơi tiêm vắc xin 1 (PLACE_VACXIN_NO1)
     */
    private String placeVacxinNo1;

    /**
     * Nơi tiêm vắc xin 2 (PLACE_VACXIN_NO2)
     */
    private String placeVacxinNo2;

    /**
     * Ngày khám (DATE_HEALTH)
     */
    private LocalDate dateHealth;

    /**
     * Nơi khám (HEALTH_CNPY)
     */
    private String healthCnpy;

    /**
     * Trạng thái (ACTIVITY)
     */
    private Integer activity;

    // Audit fields
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime updateDate;
    private String updatedBy;
    private String createdIp;
    private String updatedIp;

    // --- Joined Fields from HR_EMPLOYEE ---
    private String empId;
    private String localName;
}
