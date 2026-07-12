package com.ait.hrm.empinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ait.hrm.empinfo.model.HrLanguageLevel;

import java.util.List;

@Mapper
public interface HrLanguageLevelMapper {

    /**
     * Lấy danh sách trình độ ngoại ngữ theo personId
     */
    List<HrLanguageLevel> getByPersonId(@Param("personId") String personId);
}
