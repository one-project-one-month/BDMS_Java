package com.opom.bdms.repository;

import com.opom.bdms.entity.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Base repository interface providing common JPA operations and specification support.
 * All repository interfaces should extend this interface.
 *
 * @param <ENTITY> The entity type extending MasterEntity
 */
@NoRepositoryBean
public interface BaseRepository<ENTITY extends MasterEntity> extends JpaRepository<ENTITY, Long>, JpaSpecificationExecutor<ENTITY> {
}
