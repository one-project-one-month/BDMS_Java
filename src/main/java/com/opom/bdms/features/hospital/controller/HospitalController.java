package com.opom.bdms.features.hospital.controller;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.ApiResponse;
import com.opom.bdms.features.hospital.dto.request.HospitalFilter;
import com.opom.bdms.features.hospital.dto.request.HospitalRequest;
import com.opom.bdms.features.hospital.dto.response.HospitalResponse;
import com.opom.bdms.features.hospital.service.HospitalService;
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
@RequestMapping("/api/v1/bdms/hospitals")
public class HospitalController {
    private final HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody HospitalRequest request, HttpServletRequest httpServletRequest){
        HospitalResponse response = hospitalService.create(request);
        ApiResponse apiResponse = ApiResponseUtil.created(
                response,
                "hospital created successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping("/pageable")
    public ResponseEntity<ApiResponse> getAll(@RequestBody(required = false) PageAndFilterDTO<HospitalFilter> pageAndFilterDTO, HttpServletRequest httpServletRequest) {
        if (pageAndFilterDTO == null) {
            pageAndFilterDTO = new PageAndFilterDTO<>();
        }
        var pagination = hospitalService.getAll(pageAndFilterDTO);
        ApiResponse apiResponse = ApiResponseUtil.paginated(
                pagination,
                "Hospital retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        HospitalResponse response = hospitalService.findById(id);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Hospital retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @Valid @RequestBody HospitalRequest request, HttpServletRequest httpServletRequest) {
        HospitalResponse response = hospitalService.update(id, request);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Hospital updated successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        hospitalService.delete(id);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Hospital deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<ApiResponse> deleteMany(@RequestBody List<Long> ids, HttpServletRequest httpServletRequest) {
        hospitalService.deleteMany(ids);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Hospitals deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }
}
