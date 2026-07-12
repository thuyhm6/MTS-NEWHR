package com.ait.hrm.empinfo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * HrLanguageLevel Model - Trình độ ngoại ngữ (bảng HR_LANGUAGE_LEVEL)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrLanguageLevel {

    /**
     * Mã ngoại ngữ (LANGUAGE_NO)
     */
    private Long languageNo;

    /**
     * ID cá nhân (PERSON_ID)
     */
    private String personId;

    /**
     * Loại ngôn ngữ (LANGUAGE_TYPE)
     */
    private String languageType;
    private String languageTypeName;

    /**
     * Tổng hợp (COMBINED)
     */
    private String combined;
    private String combinedName;

    /**
     * Nói (SAY)
     */
    private String say;
    private String sayName;

    /**
     * Đọc (READ)
     */
    private String read;
    private String readName;

    /**
     * Viết (WRITE)
     */
    private String write;
    private String writeName;

    /**
     * Nghe (LISTEN)
     */
    private String listen;
    private String listenName;

    /**
     * Trình độ ngôn ngữ (LANGUAGE_LEVEL)
     */
    private String languageLevel;
    private String languageLevelName;

    /**
     * Ngôn ngữ cơ bản Y/N (BASIC_LANGUAGE)
     */
    private String basicLanguage;

    /**
     * Ghi chú (REMARK)
     */
    private String remark;

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
