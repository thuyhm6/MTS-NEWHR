package com.ait.hrm.empinfo.service.impl;

import com.ait.hrm.empinfo.mapper.HrHealthInfoMapper;
import com.ait.hrm.empinfo.model.HrHealthInfo;
import com.ait.hrm.empinfo.service.HrHealthInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrHealthInfoServiceImpl implements HrHealthInfoService {

    private static final Logger log = LoggerFactory.getLogger(HrHealthInfoServiceImpl.class);

    @Autowired
    private HrHealthInfoMapper hrHealthInfoMapper;

    @Override
    public List<HrHealthInfo> getByPersonId(String personId) {
        log.info("Lấy danh sách thông tin sức khỏe theo personId={}", personId);
        try {
            return hrHealthInfoMapper.getByPersonId(personId);
        } catch (Exception e) {
            log.error("Lỗi lấy danh sách thông tin sức khỏe personId={}", personId, e);
            throw e;
        }
    }
}
