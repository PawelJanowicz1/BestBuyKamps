package com.bestbuykamps.websiteshop.repository;
import com.bestbuykamps.websiteshop.data_model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    @Query("SELECT ci FROM CartItem ci JOIN FETCH ci.cart c JOIN FETCH ci.product WHERE c.sessionId = :sessionId")
    List<CartItem> findCartItemsBySessionId(@Param("sessionId") String sessionId);
}