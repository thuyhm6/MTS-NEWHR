package com.ait.ar.attendanceMintenance.controller;

import com.ait.ar.attendanceMintenance.dto.ArOvertimeImportTempDto;
import com.ait.ar.attendanceMintenance.dto.ArOvertimeManagentDto;
import com.ait.ar.attendanceMintenance.service.ArOvertimeManagentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ar/attendanceMintenance")
public class ArOvertimeManagentController {

    private static final Logger log = LoggerFactory.getLogger(ArOvertimeManagentController.class);

    @Autowired
    private ArOvertimeManagentService service;

    @GetMapping("/viewArOvertimeManagent_fast")
    public String view() {
        return "ar/attendanceMintenance/viewArOvertimeManagent_fast";
    }

    @GetMapping("/viewImportOtTempList")
    public String viewImportOtTempList() {
        return "ar/attendanceMintenance/viewImportOtTempList";
    }

    @GetMapping("/api/overtime/list")
    @ResponseBody
    public ResponseEntity<List<ArOvertimeManagentDto>> getList(
            @RequestParam(required = false) String empId,
            @RequestParam(required = false) String localName,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate) {
        ArOvertimeManagentDto dto = new ArOvertimeManagentDto();
        dto.setEmpId(empId);
        dto.setLocalName(localName);
        dto.setFromDate(fromDate);
        dto.setToDate(toDate);
        return ResponseEntity.ok(service.getList(dto));
    }

    @GetMapping("/api/overtime/detail")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getDetail(
            @RequestParam(name = "applyNo") String applyNo,
            @RequestParam(name = "applyType", required = false) String applyType) {
        return ResponseEntity.ok(service.getDetail(applyNo, applyType));
    }

    @GetMapping("/api/overtime/auto-fill-by-emp")
    @ResponseBody
    public ResponseEntity<ArOvertimeManagentDto> getAutoFillByEmp(
            @RequestParam(name = "personId", required = false) String personId,
            @RequestParam(name = "applyOtDate", required = false) String applyOtDate,
            @RequestParam(name = "deductYn", required = false, defaultValue = "0") String deductYn) {
        ArOvertimeManagentDto dto = new ArOvertimeManagentDto();
        dto.setPersonId(personId);
        dto.setApplyOtDate(applyOtDate);
        dto.setDeductYn(deductYn);
        return ResponseEntity.ok(service.getAutoFillOtInfo(dto));
    }

    @GetMapping("/api/overtime/default-info")
    @ResponseBody
    public ResponseEntity<ArOvertimeManagentDto> getDefaultOtInfo(
            @RequestParam(name = "personId", required = false) String personId,
            @RequestParam(name = "applyOtDate", required = false) String applyOtDate,
            @RequestParam(name = "otFromTime", required = false) String otFromTime,
            @RequestParam(name = "otToTime", required = false) String otToTime,
            @RequestParam(name = "deductYn", required = false) String deductYn) {
        ArOvertimeManagentDto dto = new ArOvertimeManagentDto();
        dto.setPersonId(personId);
        dto.setApplyOtDate(applyOtDate);
        dto.setOtFromTime(otFromTime);
        dto.setOtToTime(otToTime);
        dto.setDeductYn(deductYn);
        return ResponseEntity.ok(service.getDefaultOtInfo(dto));
    }

    @GetMapping("/api/overtime/importTemp/list")
    @ResponseBody
    public ResponseEntity<List<ArOvertimeImportTempDto>> getImportTempList(
            @RequestParam(name = "errorOnly", required = false) String errorOnly) {
        return ResponseEntity.ok(service.getImportTempList(errorOnly));
    }

    @PostMapping("/api/overtime/importTemp/save")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> importTempToOfficial() {
        Map<String, Object> response = new HashMap<>();
        try {
            String message = service.importTempToOfficial();
            response.put("success", true);
            response.put("message", message.isBlank() ? "Luu thanh cong" : message);
        } catch (Exception e) {
            log.error("Failed to import overtime temp data", e);
            response.put("success", false);
            response.put("error", e.getMessage() == null || e.getMessage().isBlank()
                    ? "Loi he thong khi luu du lieu import."
                    : e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/overtime/save")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> save(@RequestBody ArOvertimeManagentDto dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            service.save(dto);
            response.put("success", true);
            response.put("message", "Lưu thành công");
        } catch (Exception e) {
            log.error("Failed to save overtime fast data", e);
            response.put("success", false);
            response.put("error", e.getMessage() == null || e.getMessage().isBlank()
                    ? "Lỗi hệ thống khi lưu tăng ca."
                    : e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/overtime/resubmit")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> resubmit(@RequestBody ArOvertimeManagentDto dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            service.resubmitOvertimeApply(dto);
            response.put("success", true);
            response.put("message", "Đã lưu lại đơn tăng ca thành công");
        } catch (Exception e) {
            log.error("Failed to resubmit overtime apply", e);
            response.put("success", false);
            response.put("error", e.getMessage() == null || e.getMessage().isBlank()
                    ? "Lỗi hệ thống khi lưu lại đơn tăng ca."
                    : e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/overtime/cancel")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> cancel(@RequestBody ArOvertimeManagentDto dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            service.cancelOvertimeApply(dto.getApplyNo());
            response.put("success", true);
            response.put("message", "Hủy đơn thành công");
        } catch (Exception e) {
            log.error("Failed to cancel overtime apply", e);
            response.put("success", false);
            response.put("error", e.getMessage() == null || e.getMessage().isBlank()
                    ? "Lỗi hệ thống khi hủy đơn tăng ca."
                    : e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}
