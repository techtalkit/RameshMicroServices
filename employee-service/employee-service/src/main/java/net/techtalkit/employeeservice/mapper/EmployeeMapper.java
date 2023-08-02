package net.techtalkit.employeeservice.mapper;

import net.techtalkit.employeeservice.dto.EmployeeDto;
import net.techtalkit.employeeservice.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getEmail(),
                employee.getLastName(),
                employee.getDepartmentCode()
        );
        return employeeDto;
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        return employee;
    }
}
