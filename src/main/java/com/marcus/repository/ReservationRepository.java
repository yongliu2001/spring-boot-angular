package com.marcus.repository;

import com.marcus.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yongliu on 20/5/17.
 */
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}
