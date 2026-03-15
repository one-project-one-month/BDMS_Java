package com.opom.bdms.repository;

import com.opom.bdms.entity.Permission;

/**
 * Repository interface for Permission entity.
 */
public interface PermissionRepository extends BaseRepository<Permission> {

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);
}
