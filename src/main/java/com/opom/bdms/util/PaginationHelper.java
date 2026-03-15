package com.opom.bdms.util;

import com.opom.bdms.dto.response.PaginationDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public class PaginationHelper {

    public static <T> PaginationDTO<T> getResponse(Page<?> page, List<T> content) {
        return PaginationDTO.<T>builder()
                .content(content)
                .totalItems((int) page.getTotalElements())
                .totalPages(page.getTotalPages())
                .currentPage(page.getNumber())
                .pageSize(page.getSize())
                .build();
    }
}
