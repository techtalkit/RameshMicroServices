package net.techtalkit.organizationservice.service.impl;

import net.techtalkit.organizationservice.dto.OrganizationDto;
import net.techtalkit.organizationservice.entity.Organization;
import net.techtalkit.organizationservice.mapper.OrganizationMapper;
import net.techtalkit.organizationservice.repository.OrganizationRepository;
import net.techtalkit.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization= OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization=organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String OrganizationCode) {
        Organization organization=organizationRepository.findByOrganizationCode(OrganizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
