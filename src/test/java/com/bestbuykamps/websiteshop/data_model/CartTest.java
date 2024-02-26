package com.bestbuykamps.websiteshop.data_model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;


    @BeforeEach
    void setUp() {
        cart = new Cart();
    }


    @Test
    void testUserId() {
        Long userId = 123L;
        cart.setUserId(userId);
        assertEquals(userId, cart.getUserId());
    }


}