package com.marucs.repository;

import com.marucs.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by yongl on 19/05/2017.
 */
public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

    List<RoomEntity> findById(Long id);
}
