package com.ait.hrm.recruitManage.mapper;

import com.ait.hrm.recruitManage.dto.HrEmployeeRecruitDto;
import com.ait.hrm.recruitManage.dto.HrEducationRecruitDto;
import com.ait.hrm.recruitManage.dto.HrWorkExperienceRecruitDto;
import com.ait.hrm.recruitManage.dto.HrFamilyRecruitDto;
import com.ait.hrm.recruitManage.dto.HrRecruitExecuteDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HrRecruitManageMapper {

    // ── HR_EMPLOYEE_RECRUIT ──────────────────────────────────────────────────

    int countList(HrEmployeeRecruitDto dto);

    List<HrEmployeeRecruitDto> selectListPage(HrEmployeeRecruitDto dto);

    HrEmployeeRecruitDto selectEmployeeById(@Param("personId") String personId);

    int insertEmployee(HrEmployeeRecruitDto dto);

    int updateEmployee(HrEmployeeRecruitDto dto);

    // ── HR_EDUCATION_RECRUIT ─────────────────────────────────────────────────

    List<HrEducationRecruitDto> selectEducationList(@Param("personId") String personId);

    HrEducationRecruitDto selectEducationById(@Param("seq") Long seq);

    int insertEducation(HrEducationRecruitDto dto);

    int updateEducation(HrEducationRecruitDto dto);

    int deleteEducation(@Param("seq") Long seq);

    // ── HR_WORK_EXPERIENCE_RECRUIT ───────────────────────────────────────────

    List<HrWorkExperienceRecruitDto> selectWorkExpList(@Param("personId") String personId);

    HrWorkExperienceRecruitDto selectWorkExpById(@Param("seq") Long seq);

    int insertWorkExp(HrWorkExperienceRecruitDto dto);

    int updateWorkExp(HrWorkExperienceRecruitDto dto);

    int deleteWorkExp(@Param("seq") Long seq);

    // ── HR_FAMILY_RECRUIT ────────────────────────────────────────────────────

    List<HrFamilyRecruitDto> selectFamilyList(@Param("personId") String personId);

    HrFamilyRecruitDto selectFamilyById(@Param("seq") Long seq);

    int insertFamily(HrFamilyRecruitDto dto);

    int updateFamily(HrFamilyRecruitDto dto);

    int deleteFamily(@Param("seq") Long seq);

    // ── Stored procedure ─────────────────────────────────────────────────────

    void callRecruitExecute(HrRecruitExecuteDto dto);
}
