package com.opom.bdms.util;

import org.springframework.data.jpa.repository.JpaRepository;

public class RepoHelper {

    public static <T, Long> T findByIdOrThrow(JpaRepository<T, Long> repository, Long id, String entityName, String idFieldName) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(entityName + " not found with " + idFieldName + ": " + id));
    }
}
