package com.ait.hrm.empinfo.service;

import java.util.List;

import com.ait.hrm.empinfo.model.HrLanguageLevel;

public interface HrLanguageLevelService {

    /**
     * Lấy danh sách trình độ ngoại ngữ theo personId
     */
    List<HrLanguageLevel> getByPersonId(String personId);
}
