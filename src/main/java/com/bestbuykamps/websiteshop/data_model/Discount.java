package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DiscountType typeOfDiscount;

    @Column(name = "discount_value")
    private BigDecimal discount;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiscountType getTypeOfDiscount() {
        return typeOfDiscount;
    }

    public void setTypeOfDiscount(DiscountType typeOfDiscount) {
        this.typeOfDiscount = typeOfDiscount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}