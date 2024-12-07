package com.learning.microservices.address.service.app.dao;

import com.learning.microservices.address.service.app.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
