package com.prodian.mapping.service;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prodian.mapping.entity.Organization;
import com.prodian.mapping.repository.AddressRepository;
import com.prodian.mapping.repository.OrganizationRepository;

@Service

public class OrganizationService {

	private OrganizationRepository organizationRepository;

	private AddressRepository addressRepository;

	public OrganizationService(OrganizationRepository organizationRepository, AddressRepository addressRepository) {

		this.organizationRepository = organizationRepository;

		this.addressRepository = addressRepository;

	}

	@Transactional

	public ResponseEntity<Object> createOrganization(Organization organization) {

		Organization org = new Organization();

		org.setName(organization.getName());

		org.setOrgId(organization.getOrgId());

		org.setAddress(organization.getAddress());

		Organization savedOrg = organizationRepository.save(org);

		if (organizationRepository.findById(savedOrg.getId()).isPresent())

			return ResponseEntity.ok().body("Organization created successfully.");

		else
			return ResponseEntity.unprocessableEntity().body("Failed to create the organization specified.");

	}

	@Transactional

	public ResponseEntity<Object> updateOrganization(Long id, Organization org) {

		if (organizationRepository.findById(id).isPresent()) {

			Organization organization = organizationRepository.findById(id).get();

			organization.setName(org.getName());

			organization.setOrgId(org.getName());

			addressRepository.deleteById(organization.getAddress().getId());

			organization.setAddress(org.getAddress());

			Organization savedOrganization = organizationRepository.save(organization);

			if (organizationRepository.findById(savedOrganization.getId()).isPresent())

				return ResponseEntity.ok().body("Successfully Updated Organization");

			else
				return ResponseEntity.unprocessableEntity().body("Failed to update the specified Organization");

		} else
			return ResponseEntity.unprocessableEntity().body("The specified Organization is not found");

	}

}