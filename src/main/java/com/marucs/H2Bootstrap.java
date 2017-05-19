package com.marucs;

import com.marucs.entity.RoomEntity;
import com.marucs.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by yongl on 19/05/2017.
 */
@Component
public class H2Bootstrap implements CommandLineRunner {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {

        roomRepository.save(new RoomEntity(405, "200"));
        roomRepository.save(new RoomEntity(406, "220"));
        roomRepository.save(new RoomEntity(407, "260"));

        Iterable<RoomEntity> it = roomRepository.findAll();

        System.out.println("BootStrapping data -- ");
        it.forEach(roomEntity -> System.out.println(roomEntity.getRoomNumber()));
    }
}
