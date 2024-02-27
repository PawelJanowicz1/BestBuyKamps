package com.bestbuykamps.websiteshop.repository;
import com.bestbuykamps.websiteshop.data_model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
}