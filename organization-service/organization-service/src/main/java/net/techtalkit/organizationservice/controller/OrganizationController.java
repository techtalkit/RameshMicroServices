package net.techtalkit.organizationservice.controller;

import net.techtalkit.organizationservice.dto.OrganizationDto;
import net.techtalkit.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    //Build Save Organization Rest API
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization=organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
    //Build Get Organization by code Rest API
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organiztionDto=organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organiztionDto, HttpStatus.OK);
    }


}
