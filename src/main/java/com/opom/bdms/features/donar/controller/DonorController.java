package com.opom.bdms.features.donar.controller;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.ApiResponse;
import com.opom.bdms.features.donar.dto.request.DonorFilter;
import com.opom.bdms.features.donar.dto.request.DonorRequest;
import com.opom.bdms.features.donar.dto.response.DonorResponse;
import com.opom.bdms.features.donar.service.DonorService;
import com.opom.bdms.util.ApiResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bdms/donors")
@RequiredArgsConstructor
public class DonorController {

        private final DonorService donorService;

        @PostMapping
        public ResponseEntity<ApiResponse> create(@Valid @RequestBody DonorRequest request,
                        HttpServletRequest httpServletRequest) {
                DonorResponse response = donorService.create(request);
                ApiResponse apiResponse = ApiResponseUtil.created(
                                response,
                                "Donor created successfully",
                                httpServletRequest);
                return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
        }

        @PostMapping("/pageable")
        public ResponseEntity<ApiResponse> getAll(
                        @RequestBody(required = false) PageAndFilterDTO<DonorFilter> pageAndFilterDTO,
                        HttpServletRequest httpServletRequest) {
                if (pageAndFilterDTO == null) {
                        pageAndFilterDTO = new PageAndFilterDTO<>();
                }
                var pagination = donorService.getAll(pageAndFilterDTO);
                ApiResponse apiResponse = ApiResponseUtil.paginated(
                                pagination,
                                "Donors retrieved successfully",
                                httpServletRequest);
                return ResponseEntity.ok(apiResponse);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ApiResponse> findById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
                DonorResponse response = donorService.findById(id);
                ApiResponse apiResponse = ApiResponseUtil.success(
                                response,
                                "Donor retrieved successfully",
                                httpServletRequest);
                return ResponseEntity.ok(apiResponse);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ApiResponse> update(@PathVariable Long id, @Valid @RequestBody DonorRequest request,
                        HttpServletRequest httpServletRequest) {
                DonorResponse response = donorService.update(id, request);
                ApiResponse apiResponse = ApiResponseUtil.success(
                                response,
                                "Donor updated successfully",
                                httpServletRequest);
                return ResponseEntity.ok(apiResponse);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponse> delete(@PathVariable Long id, HttpServletRequest httpServletRequest) {
                donorService.delete(id);
                ApiResponse apiResponse = ApiResponseUtil.noContent(
                                "Donor deleted successfully",
                                httpServletRequest);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
        }

        @DeleteMapping("/batch")
        public ResponseEntity<ApiResponse> deleteMany(@RequestBody List<Long> ids,
                        HttpServletRequest httpServletRequest) {
                donorService.deleteMany(ids);
                ApiResponse apiResponse = ApiResponseUtil.noContent(
                                "Donors deleted successfully",
                                httpServletRequest);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
        }
}
