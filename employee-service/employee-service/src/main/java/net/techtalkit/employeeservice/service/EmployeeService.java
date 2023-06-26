package net.techtalkit.employeeservice.service;

import net.techtalkit.employeeservice.dto.APIResponseDto;
import net.techtalkit.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeid);
}
