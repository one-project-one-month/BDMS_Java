package com.opom.bdms.features.appointment.controller;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.ApiResponse;
import com.opom.bdms.features.appointment.dto.request.AppointmentFilter;
import com.opom.bdms.features.appointment.dto.request.AppointmentRequest;
import com.opom.bdms.features.appointment.dto.response.AppointmentResponse;
import com.opom.bdms.features.appointment.service.AppointmentService;
import com.opom.bdms.util.ApiResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bdms/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<ApiResponse> create (@Valid @RequestBody AppointmentRequest request, HttpServletRequest httpServletRequest) {
        AppointmentResponse response = appointmentService.create(request);
        ApiResponse apiResponse = ApiResponseUtil.created(
                response,
                "Appointment created successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping("/pageable")
    public ResponseEntity<ApiResponse> getAll(@RequestBody(required = false)PageAndFilterDTO<AppointmentFilter> pageAndFilterDTO, HttpServletRequest httpServletRequest) {
        if(pageAndFilterDTO == null) pageAndFilterDTO = new PageAndFilterDTO<>();

        var pagination = appointmentService.getAll(pageAndFilterDTO);
        ApiResponse apiResponse = ApiResponseUtil.paginated(
                pagination,
                "Appointment retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        AppointmentResponse response = appointmentService.findById(id);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Appointment retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @Valid @RequestBody AppointmentRequest request, HttpServletRequest httpServletRequest) {
        AppointmentResponse response = appointmentService.update(id, request);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Appointment updated successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        appointmentService.delete(id);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Appointment deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<ApiResponse> deleteMany(@RequestBody List<Long> ids, HttpServletRequest httpServletRequest) {
        appointmentService.deleteMany(ids);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Appointments deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }

}
