package com.ait.hrm.empinfo.service;

import java.util.List;

import com.ait.hrm.empinfo.model.HrHealthInfo;

public interface HrHealthInfoService {

    /**
     * Lấy danh sách thông tin sức khỏe theo personId
     */
    List<HrHealthInfo> getByPersonId(String personId);
}
