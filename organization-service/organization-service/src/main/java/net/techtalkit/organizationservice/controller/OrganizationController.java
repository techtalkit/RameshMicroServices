package net.techtalkit.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.techtalkit.organizationservice.dto.OrganizationDto;
import net.techtalkit.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name="Organization Service- OrganizationController",
        description = "Organization Controller exposes Rest APIs for organization service"
)
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    //Build Save Organization Rest API
    @Operation(
            summary = "Save organization Rest API",
            description = "Save organization Rest API is used to save organization object in DB"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization=organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
    //Build Get Organization by code Rest API
    @Operation(
            summary = "Get organization Rest API",
            description = "Get organization Rest API is used to save organization object in DB"

    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organiztionDto=organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organiztionDto, HttpStatus.OK);
    }


}
