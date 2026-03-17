package com.opom.bdms.features.permission.controller;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.ApiResponse;
import com.opom.bdms.features.permission.dto.request.PermissionFilter;
import com.opom.bdms.features.permission.dto.request.PermissionRequest;
import com.opom.bdms.features.permission.dto.response.PermissionResponse;
import com.opom.bdms.features.permission.service.PermissionService;
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
@RequestMapping("/api/v1/bdms/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody PermissionRequest request, HttpServletRequest httpServletRequest) {
        PermissionResponse response = permissionService.create(request);
        ApiResponse apiResponse = ApiResponseUtil.created(
                response,
                "Permission created successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping("/pageable")
    public ResponseEntity<ApiResponse> getAll(@RequestBody(required = false) PageAndFilterDTO<PermissionFilter> pageAndFilterDTO, HttpServletRequest httpServletRequest) {
        if (pageAndFilterDTO == null) {
            pageAndFilterDTO = new PageAndFilterDTO<>();
        }
        var pagination = permissionService.getAll(pageAndFilterDTO);
        ApiResponse apiResponse = ApiResponseUtil.paginated(
                pagination,
                "Permissions retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        PermissionResponse response = permissionService.findById(id);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Permission retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @Valid @RequestBody PermissionRequest request, HttpServletRequest httpServletRequest) {
        PermissionResponse response = permissionService.update(id, request);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Permission updated successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        permissionService.delete(id);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Permission deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<ApiResponse> deleteMany(@RequestBody List<Long> ids, HttpServletRequest httpServletRequest) {
        permissionService.deleteMany(ids);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Permissions deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }
}
