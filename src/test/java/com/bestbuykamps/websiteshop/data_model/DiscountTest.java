package com.bestbuykamps.websiteshop.data_model;
import com.bestbuykamps.websiteshop.util.DiscountType;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
class DiscountTest {
    @Test
    void testGetId() {
        Discount discount = new Discount();
        discount.setId(123L);
        assertEquals(123L, discount.getId());
    }
    @Test
    void testGetTypeOfDiscount() {
        Discount discount = new Discount();
        discount.setTypeOfDiscount(DiscountType.PERCENT);
        assertEquals(DiscountType.PERCENT, discount.getTypeOfDiscount());
    }
    @Test
    void testGetDiscount() {
        Discount discount = new Discount();
        discount.setDiscount(new BigDecimal("11.50"));
        assertEquals(new BigDecimal("11.50"), discount.getDiscount());
    }
    @Test
    void testSetDiscount() {
        Discount discount = new Discount();
        discount.setDiscount(new BigDecimal("30.75"));
        assertEquals(new BigDecimal("30.75"), discount.getDiscount());
    }
}