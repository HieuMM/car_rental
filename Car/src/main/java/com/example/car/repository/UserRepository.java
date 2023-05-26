package com.example.car.repository;
import com.example.car.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface UserRepository  extends JpaRepository<User, Long>{
}
