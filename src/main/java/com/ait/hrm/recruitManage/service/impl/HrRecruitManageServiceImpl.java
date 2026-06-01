package com.ait.hrm.recruitManage.service.impl;

import com.ait.hrm.recruitManage.dto.HrEmployeeRecruitDto;
import com.ait.hrm.recruitManage.dto.HrEducationRecruitDto;
import com.ait.hrm.recruitManage.dto.HrWorkExperienceRecruitDto;
import com.ait.hrm.recruitManage.dto.HrFamilyRecruitDto;
import com.ait.hrm.recruitManage.dto.HrRecruitExecuteDto;
import com.ait.hrm.recruitManage.mapper.HrRecruitManageMapper;
import com.ait.hrm.recruitManage.service.HrRecruitManageService;
import com.ait.sy.sys.dto.DataTablesResponse;
import com.ait.sy.sys.service.HrAuthenticationService.HrUserInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HrRecruitManageServiceImpl implements HrRecruitManageService {

    private static final Logger log = LoggerFactory.getLogger(HrRecruitManageServiceImpl.class);

    @Autowired
    private HrRecruitManageMapper mapper;

    @Override
    public DataTablesResponse<HrEmployeeRecruitDto> getEmployeeList(HrEmployeeRecruitDto dto) {
        try {
            int total = mapper.countList(dto);
            List<HrEmployeeRecruitDto> list = mapper.selectListPage(dto);
            return new DataTablesResponse<>(dto.getDraw(), total, total, list);
        } catch (Exception e) {
            log.error("Lỗi lấy danh sách nhân viên tuyển dụng", e);
            return new DataTablesResponse<>(dto.getDraw(), "Lỗi truy vấn dữ liệu");
        }
    }

    @Override
    public HrEmployeeRecruitDto getEmployeeById(String personId) {
        try {
            return mapper.selectEmployeeById(personId);
        } catch (Exception e) {
            log.error("Lỗi lấy thông tin nhân viên personId={}", personId, e);
            return null;
        }
    }

    @Override
    @Transactional
    public Map<String, Object> saveEmployee(HrEmployeeRecruitDto dto) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (dto.getPersonId() == null || dto.getPersonId().isEmpty()) {
                mapper.insertEmployee(dto);
                result.put("success", true);
                result.put("personId", dto.getPersonId());
                result.put("message", "Thêm mới thành công");
            } else {
                mapper.updateEmployee(dto);
                result.put("success", true);
                result.put("personId", dto.getPersonId());
                result.put("message", "Cập nhật thành công");
            }
        } catch (Exception e) {
            log.error("Lỗi lưu thông tin nhân viên tuyển dụng", e);
            result.put("success", false);
            result.put("message", "Lỗi lưu dữ liệu: " + e.getMessage());
        }
        return result;
    }

    // ── Education ────────────────────────────────────────────────────────────

    @Override
    public List<HrEducationRecruitDto> getEducationList(String personId) {
        try {
            return mapper.selectEducationList(personId);
        } catch (Exception e) {
            log.error("Lỗi lấy danh sách giáo dục personId={}", personId, e);
            return List.of();
        }
    }

    @Override
    @Transactional
    public Map<String, Object> saveEducation(HrEducationRecruitDto dto) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (dto.getSeq() == null) {
                mapper.insertEducation(dto);
            } else {
                mapper.updateEducation(dto);
            }
            result.put("success", true);
            result.put("message", "Lưu thành công");
        } catch (Exception e) {
            log.error("Lỗi lưu thông tin giáo dục", e);
            result.put("success", false);
            result.put("message", "Lỗi: " + e.getMessage());
        }
        return result;
    }

    @Override
    @Transactional
    public Map<String, Object> deleteEducation(Long seq) {
        Map<String, Object> result = new HashMap<>();
        try {
            mapper.deleteEducation(seq);
            result.put("success", true);
        } catch (Exception e) {
            log.error("Lỗi xóa giáo dục seq={}", seq, e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    // ── Work Experience ──────────────────────────────────────────────────────

    @Override
    public List<HrWorkExperienceRecruitDto> getWorkExpList(String personId) {
        try {
            return mapper.selectWorkExpList(personId);
        } catch (Exception e) {
            log.error("Lỗi lấy quá trình làm việc personId={}", personId, e);
            return List.of();
        }
    }

    @Override
    @Transactional
    public Map<String, Object> saveWorkExp(HrWorkExperienceRecruitDto dto) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (dto.getSeq() == null) {
                mapper.insertWorkExp(dto);
            } else {
                mapper.updateWorkExp(dto);
            }
            result.put("success", true);
            result.put("message", "Lưu thành công");
        } catch (Exception e) {
            log.error("Lỗi lưu quá trình làm việc", e);
            result.put("success", false);
            result.put("message", "Lỗi: " + e.getMessage());
        }
        return result;
    }

    @Override
    @Transactional
    public Map<String, Object> deleteWorkExp(Long seq) {
        Map<String, Object> result = new HashMap<>();
        try {
            mapper.deleteWorkExp(seq);
            result.put("success", true);
        } catch (Exception e) {
            log.error("Lỗi xóa quá trình làm việc seq={}", seq, e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    // ── Family ───────────────────────────────────────────────────────────────

    @Override
    public List<HrFamilyRecruitDto> getFamilyList(String personId) {
        try {
            return mapper.selectFamilyList(personId);
        } catch (Exception e) {
            log.error("Lỗi lấy thông tin gia đình personId={}", personId, e);
            return List.of();
        }
    }

    @Override
    @Transactional
    public Map<String, Object> saveFamily(HrFamilyRecruitDto dto) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (dto.getSeq() == null) {
                mapper.insertFamily(dto);
            } else {
                mapper.updateFamily(dto);
            }
            result.put("success", true);
            result.put("message", "Lưu thành công");
        } catch (Exception e) {
            log.error("Lỗi lưu thông tin gia đình", e);
            result.put("success", false);
            result.put("message", "Lỗi: " + e.getMessage());
        }
        return result;
    }

    @Override
    @Transactional
    public Map<String, Object> deleteFamily(Long seq) {
        Map<String, Object> result = new HashMap<>();
        try {
            mapper.deleteFamily(seq);
            result.put("success", true);
        } catch (Exception e) {
            log.error("Lỗi xóa thông tin gia đình seq={}", seq, e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    // ── Execute ──────────────────────────────────────────────────────────────

    @Override
    @Transactional
    public Map<String, Object> executeRecruit(String personIds, String type) {
        Map<String, Object> result = new HashMap<>();
        try {
            HrUserInfo user = getCurrentUser();
            HrRecruitExecuteDto dto = new HrRecruitExecuteDto();
            dto.setPersonIds(personIds);
            dto.setType(type);
            if (user != null) {
                dto.setAdminID(user.getUsername());
                dto.setAdminIP(getClientIp());
                dto.setCpnyId(user.getCpnyId());
            }
            mapper.callRecruitExecute(dto);
            String msg = dto.getMessage();
            if (msg != null && msg.startsWith("ERR")) {
                result.put("success", false);
                result.put("message", msg);
            } else {
                result.put("success", true);
                result.put("message", msg != null ? msg : "Thực hiện thành công");
            }
        } catch (Exception e) {
            log.error("Lỗi thực hiện recruit execute type={}", type, e);
            result.put("success", false);
            result.put("message", "Lỗi: " + e.getMessage());
        }
        return result;
    }

    private HrUserInfo getCurrentUser() {
        try {
            ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attrs != null) {
                HttpSession session = attrs.getRequest().getSession(false);
                if (session != null) {
                    return (HrUserInfo) session.getAttribute("currentHrUser");
                }
            }
        } catch (Exception e) {
            log.warn("Không lấy được thông tin user hiện tại", e);
        }
        return null;
    }

    private String getClientIp() {
        try {
            ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attrs != null) {
                jakarta.servlet.http.HttpServletRequest req = attrs.getRequest();
                String ip = req.getHeader("X-Forwarded-For");
                if (ip == null || ip.isEmpty()) ip = req.getRemoteAddr();
                return ip;
            }
        } catch (Exception e) {
            log.warn("Không lấy được IP", e);
        }
        return "";
    }
}
