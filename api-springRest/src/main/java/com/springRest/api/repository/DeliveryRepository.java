package com.springRest.api.repository; 
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springRest.api.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>  {

}
