package com.opom.bdms.repository;

import com.opom.bdms.entity.BloodRequest;

/**
 * Repository interface for BloodRequest entity.
 */
public interface BloodRequestRepository extends BaseRepository<BloodRequest> {

    boolean existsByBloodRequestCode(String bloodRequestCode);

    boolean existsByBloodRequestCodeAndIdNot(String bloodRequestCode, Long id);

}
