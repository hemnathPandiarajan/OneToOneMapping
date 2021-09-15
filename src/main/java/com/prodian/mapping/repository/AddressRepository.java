package com.prodian.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodian.mapping.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
