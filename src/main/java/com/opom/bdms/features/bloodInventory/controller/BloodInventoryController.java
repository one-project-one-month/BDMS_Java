package com.opom.bdms.features.bloodInventory.controller;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.ApiResponse;
import com.opom.bdms.features.bloodInventory.dto.request.BloodInventoryFilter;
import com.opom.bdms.features.bloodInventory.dto.request.BloodInventoryRequest;
import com.opom.bdms.features.bloodInventory.dto.response.BloodInventoryResponse;
import com.opom.bdms.features.bloodInventory.service.BloodInventoryService;
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
@RequestMapping("/api/v1/bdms/bloodInventories")
public class BloodInventoryController {

    private final BloodInventoryService bloodInventoryService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody BloodInventoryRequest request, HttpServletRequest httpServletRequest) {
        BloodInventoryResponse response = bloodInventoryService.create(request);
        ApiResponse apiResponse = ApiResponseUtil.created(
                response,
                "Blood Inventory created successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping("/pageable")
    public ResponseEntity<ApiResponse> getAll(@RequestBody(required = false) PageAndFilterDTO<BloodInventoryFilter> pageAndFilterDTO, HttpServletRequest httpServletRequest) {
        if (pageAndFilterDTO == null) {
            pageAndFilterDTO = new PageAndFilterDTO<>();
        }
        var pagination = bloodInventoryService.getAll(pageAndFilterDTO);
        ApiResponse apiResponse = ApiResponseUtil.paginated(
                pagination,
                "Blood Inventories retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        BloodInventoryResponse response = bloodInventoryService.findById(id);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Blood Inventory retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @Valid @RequestBody BloodInventoryRequest request, HttpServletRequest httpServletRequest) {
        BloodInventoryResponse response = bloodInventoryService.update(id, request);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Blood Inventory updated successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        bloodInventoryService.delete(id);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Blood Inventory deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<ApiResponse> deleteMany(@RequestBody List<Long> ids, HttpServletRequest httpServletRequest) {
        bloodInventoryService.deleteMany(ids);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Blood Inventories deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }
}
