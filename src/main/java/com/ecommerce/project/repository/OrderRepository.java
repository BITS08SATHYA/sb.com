package com.ecommerce.project.repository;

import com.ecommerce.project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends JpaRepository<Order, Long> {


}
