package com.marcus.rest;

import com.jayway.restassured.RestAssured;
import com.marcus.SpringBootAngularApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by yongl on 20/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAngularApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationResourceTest {

    @LocalServerPort
    private Integer port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
        RestAssured.basePath = ResourceConstants.ROOM_RESERVATION_V1;
        RestAssured.baseURI = "http://localhost";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAvailableRooms() throws Exception {
    }

    @Test
    public void getRoomId() throws Exception {
        RestAssured.given().when().get("/" + 1).then().statusCode(200);
    }

    @Test
    public void createReservation() throws Exception {
    }

    @Test
    public void updateReservation() throws Exception {
    }

    @Test
    public void deleteReservation() throws Exception {
    }

}