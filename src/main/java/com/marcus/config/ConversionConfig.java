package com.marcus.config;

import com.marcus.rest.converter.ReservationEntityToReservationResponseConverter;
import com.marcus.rest.converter.ReservationRequestToReservationEntityConverter;
import com.marcus.rest.converter.RoomEntityToReservableRoomResponseConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yongl on 19/05/2017.
 */

@Configuration
public class ConversionConfig {

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new RoomEntityToReservableRoomResponseConverter());
        converters.add(new ReservationRequestToReservationEntityConverter());
        converters.add(new ReservationEntityToReservationResponseConverter());
        return converters;
    }

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();

        return bean.getObject();
    }
}
