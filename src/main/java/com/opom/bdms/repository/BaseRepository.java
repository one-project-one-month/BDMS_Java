package com.opom.bdms.repository;

import com.opom.bdms.entity.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Base repository interface providing common JPA operations and specification support.
 * All repository interfaces should extend this interface.
 *
 * @param <T> The entity type extending MasterEntity
 * @param <ID> The type of the entity's primary key
 */
public interface BaseRepository<T extends MasterEntity, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
