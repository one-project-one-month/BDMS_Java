package com.opom.bdms.features.certificate.controller;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.ApiResponse;
import com.opom.bdms.features.certificate.dto.request.CertificateFilter;
import com.opom.bdms.features.certificate.dto.request.CertificateRequest;
import com.opom.bdms.features.certificate.dto.response.CertificateResponse;
import com.opom.bdms.features.certificate.service.CertificateService;
import com.opom.bdms.util.ApiResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bdms/certificates")
public class CertificateController {

    private final CertificateService certificateService;


    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody CertificateRequest request, HttpServletRequest httpServletRequest) {
      CertificateResponse response= certificateService.create(request);
      ApiResponse apiResponse= ApiResponseUtil.created(response,"Certificate created successfully",httpServletRequest);
      return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @Valid @RequestBody CertificateRequest request, HttpServletRequest httpServletRequest) {
        CertificateResponse response= certificateService.update(id,request);
        ApiResponse apiResponse=ApiResponseUtil.success(response,"Certificate updated successfully",httpServletRequest);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        CertificateResponse response= certificateService.findById(id);
        ApiResponse apiResponse=ApiResponseUtil.success(response,"Certificate retrieved successfully",httpServletRequest);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


    @PostMapping("/pageable")
    public ResponseEntity<ApiResponse> getAll(@RequestBody(required = false)PageAndFilterDTO<CertificateFilter> filterPageAndFilterDTO, HttpServletRequest httpServletRequest) {
       if (filterPageAndFilterDTO == null) {
           filterPageAndFilterDTO = new PageAndFilterDTO<>();
       }
        var pagination=certificateService.getAll(filterPageAndFilterDTO);
       ApiResponse apiResponse=ApiResponseUtil.paginated(
               pagination,"Certificates retrieved successfully",httpServletRequest

       );
       return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        certificateService.delete(id);
        ApiResponse apiResponse=ApiResponseUtil.noContent("Certificate deleted successfully",httpServletRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);

    }

}
