package com.bestbuykamps.websiteshop.data_model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactDetailsTest {

    @Test
    public void testSetAndGetFirstName() {
        ContactDetails contact = new ContactDetails();
        contact.setFirstName("Sebastian");
        assertEquals("Sebastian", contact.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        ContactDetails contact = new ContactDetails();
        contact.setLastName("Wally");
        assertEquals("Wally", contact.getLastName());
    }

    @Test
    public void testSetAndGetAdress() {
        ContactDetails contact = new ContactDetails();
       contact.setAdress("123 Nowogrodzka");
       assertEquals("123 Nowogrodzka", contact.getAdress());
    }

    @Test
    public void testSetAndGetId() {
        ContactDetails contact = new ContactDetails();
        contact.setId(1L);
        assertEquals(1L, contact.getId());
    }


}