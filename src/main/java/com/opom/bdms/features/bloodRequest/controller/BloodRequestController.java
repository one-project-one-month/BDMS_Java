package com.opom.bdms.features.bloodRequest.controller;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.ApiResponse;
import com.opom.bdms.features.bloodRequest.dto.request.BloodRequestFilter;
import com.opom.bdms.features.bloodRequest.dto.request.BloodRequestRequest;
import com.opom.bdms.features.bloodRequest.dto.response.BloodRequestResponse;
import com.opom.bdms.features.bloodRequest.service.BloodRequestService;
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
@RequestMapping("/api/v1/bdms/bloodRequest")
public class BloodRequestController {

    private final BloodRequestService bloodRequestService;

    @PostMapping
    public ResponseEntity<ApiResponse> create (@Valid @RequestBody BloodRequestRequest request, HttpServletRequest httpServletRequest) {
        BloodRequestResponse response = bloodRequestService.create(request);
        ApiResponse apiResponse = ApiResponseUtil.created(
                response,
                "Blood Request created successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping("/pageable")
    public ResponseEntity<ApiResponse> getAll(@RequestBody(required = false)PageAndFilterDTO<BloodRequestFilter> pageAndFilterDTO, HttpServletRequest httpServletRequest) {
        if(pageAndFilterDTO == null) {
            pageAndFilterDTO = new PageAndFilterDTO<>();
        }
        var pagination = bloodRequestService.getAll(pageAndFilterDTO);
        ApiResponse apiResponse = ApiResponseUtil.paginated(
                pagination,
                "Blood Requests retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        BloodRequestResponse response = bloodRequestService.findById(id);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Blood Request retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @Valid @RequestBody BloodRequestRequest request, HttpServletRequest httpServletRequest) {
        BloodRequestResponse response = bloodRequestService.update(id, request);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Blood Request updated successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        bloodRequestService.delete(id);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Blood Request deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<ApiResponse> deleteMany(@RequestBody List<Long> ids, HttpServletRequest httpServletRequest) {
        bloodRequestService.deleteMany(ids);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Blood Requests deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }
}
