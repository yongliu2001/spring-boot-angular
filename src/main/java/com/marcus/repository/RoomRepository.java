package com.marcus.repository;

import com.marcus.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yongl on 19/05/2017.
 */
public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

    RoomEntity findById(Long id);
}
