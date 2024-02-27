package com.bestbuykamps.websiteshop.repository;
import com.bestbuykamps.websiteshop.data_model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}