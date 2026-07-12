package com.ait.hrm.empinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ait.hrm.empinfo.model.HrHealthInfo;

import java.util.List;

@Mapper
public interface HrHealthInfoMapper {

    /**
     * Lấy danh sách thông tin sức khỏe theo personId
     */
    List<HrHealthInfo> getByPersonId(@Param("personId") String personId);
}
