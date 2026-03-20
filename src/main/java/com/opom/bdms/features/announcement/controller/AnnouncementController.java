package com.opom.bdms.features.announcement.controller;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.ApiResponse;
import com.opom.bdms.features.announcement.dto.request.AnnouncementFilter;
import com.opom.bdms.features.announcement.dto.request.AnnouncementRequest;
import com.opom.bdms.features.announcement.dto.response.AnnouncementResponse;
import com.opom.bdms.features.announcement.service.AnnouncementService;
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
@RequestMapping("/api/v1/bdms/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody AnnouncementRequest request, HttpServletRequest httpServletRequest){
        AnnouncementResponse response = announcementService.create(request);
        ApiResponse apiResponse = ApiResponseUtil.created(
                response,
                "Announcement created successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping("/pageable")
    public ResponseEntity<ApiResponse> getAll(@RequestBody(required = false) PageAndFilterDTO<AnnouncementFilter> pageAndFilterDTO, HttpServletRequest httpServletRequest) {
        if (pageAndFilterDTO == null) {
            pageAndFilterDTO = new PageAndFilterDTO<>();
        }
        var pagination = announcementService.getAll(pageAndFilterDTO);
        ApiResponse apiResponse = ApiResponseUtil.paginated(
                pagination,
                "Announcement retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        AnnouncementResponse response = announcementService.findById(id);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Announcement retrieved successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @Valid @RequestBody AnnouncementRequest request, HttpServletRequest httpServletRequest) {
        AnnouncementResponse response = announcementService.update(id, request);
        ApiResponse apiResponse = ApiResponseUtil.success(
                response,
                "Announcement updated successfully",
                httpServletRequest
        );
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        announcementService.delete(id);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Announcement deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<ApiResponse> deleteMany(@RequestBody List<Long> ids, HttpServletRequest httpServletRequest) {
        announcementService.deleteMany(ids);
        ApiResponse apiResponse = ApiResponseUtil.noContent(
                "Announcements deleted successfully",
                httpServletRequest
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }
}
