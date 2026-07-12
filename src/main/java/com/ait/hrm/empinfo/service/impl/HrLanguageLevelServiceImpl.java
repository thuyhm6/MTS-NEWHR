package com.ait.hrm.empinfo.service.impl;

import com.ait.hrm.empinfo.mapper.HrLanguageLevelMapper;
import com.ait.hrm.empinfo.model.HrLanguageLevel;
import com.ait.hrm.empinfo.service.HrLanguageLevelService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrLanguageLevelServiceImpl implements HrLanguageLevelService {

    private static final Logger log = LoggerFactory.getLogger(HrLanguageLevelServiceImpl.class);

    @Autowired
    private HrLanguageLevelMapper hrLanguageLevelMapper;

    @Override
    public List<HrLanguageLevel> getByPersonId(String personId) {
        log.info("Lấy danh sách trình độ ngoại ngữ theo personId={}", personId);
        try {
            return hrLanguageLevelMapper.getByPersonId(personId);
        } catch (Exception e) {
            log.error("Lỗi lấy danh sách trình độ ngoại ngữ personId={}", personId, e);
            throw e;
        }
    }
}
