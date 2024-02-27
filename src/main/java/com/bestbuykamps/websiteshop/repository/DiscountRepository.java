package com.bestbuykamps.websiteshop.repository;
import com.bestbuykamps.websiteshop.data_model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
}