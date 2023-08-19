package net.techtalkit.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.techtalkit.departmentservice.dto.DepartmentDto;
import net.techtalkit.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="Department Service- DepartmentController",
        description = "Department Controller exposes Rest APIs for department service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;
    //Build save department REST API
    @Operation(
            summary = "Save department Rest API",
            description = "Save department Rest API is used to save department object in DB"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment=departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    //Build get department Rest API
    @Operation(
            summary = "Get department by code Rest API",
            description = "Get department by code Rest API is used to get department from DB"

    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto=departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity(departmentDto,HttpStatus.OK);
    }

}
