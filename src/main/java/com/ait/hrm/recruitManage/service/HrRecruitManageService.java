package com.ait.hrm.recruitManage.service;

import com.ait.hrm.recruitManage.dto.HrEmployeeRecruitDto;
import com.ait.hrm.recruitManage.dto.HrEducationRecruitDto;
import com.ait.hrm.recruitManage.dto.HrWorkExperienceRecruitDto;
import com.ait.hrm.recruitManage.dto.HrFamilyRecruitDto;
import com.ait.sy.sys.dto.DataTablesResponse;

import java.util.List;
import java.util.Map;

public interface HrRecruitManageService {

    DataTablesResponse<HrEmployeeRecruitDto> getEmployeeList(HrEmployeeRecruitDto dto);

    HrEmployeeRecruitDto getEmployeeById(String personId);

    Map<String, Object> saveEmployee(HrEmployeeRecruitDto dto);

    // Education
    List<HrEducationRecruitDto> getEducationList(String personId);

    Map<String, Object> saveEducation(HrEducationRecruitDto dto);

    Map<String, Object> deleteEducation(Long seq);

    // Work experience
    List<HrWorkExperienceRecruitDto> getWorkExpList(String personId);

    Map<String, Object> saveWorkExp(HrWorkExperienceRecruitDto dto);

    Map<String, Object> deleteWorkExp(Long seq);

    // Family
    List<HrFamilyRecruitDto> getFamilyList(String personId);

    Map<String, Object> saveFamily(HrFamilyRecruitDto dto);

    Map<String, Object> deleteFamily(Long seq);

    // Execute (confirm/cancel)
    Map<String, Object> executeRecruit(String personIds, String type);
}
