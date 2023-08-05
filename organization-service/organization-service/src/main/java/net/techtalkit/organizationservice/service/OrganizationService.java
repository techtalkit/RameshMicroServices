package net.techtalkit.organizationservice.service;

import net.techtalkit.organizationservice.dto.OrganizationDto;
import net.techtalkit.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationService  {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String OrganizationCode);
}
