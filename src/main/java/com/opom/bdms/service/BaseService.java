package com.opom.bdms.service;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.PaginationDTO;

import java.util.List;

public interface BaseService<REQUEST, RESPONSE, FILTER> {
    RESPONSE create(REQUEST request);
    RESPONSE findById(Long id);
    RESPONSE update(Long id, REQUEST request);
    void delete(Long id);
    void deleteMany(List<Long> ids);
    PaginationDTO<RESPONSE> getAll(PageAndFilterDTO<FILTER> pageAndFilterDTO);
}
