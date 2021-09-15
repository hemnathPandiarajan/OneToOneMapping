package com.prodian.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodian.mapping.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}
