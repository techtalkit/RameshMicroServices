package net.techtalkit.organizationservice.repository;

import net.techtalkit.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long>{
}
