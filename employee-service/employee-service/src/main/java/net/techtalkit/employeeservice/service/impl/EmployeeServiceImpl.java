package net.techtalkit.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.techtalkit.employeeservice.dto.APIResponseDto;
import net.techtalkit.employeeservice.dto.DepartmentDto;
import net.techtalkit.employeeservice.dto.EmployeeDto;
import net.techtalkit.employeeservice.entity.Employee;
import net.techtalkit.employeeservice.mapper.EmployeeMapper;
import net.techtalkit.employeeservice.repository.EmployeeRepositry;
import net.techtalkit.employeeservice.service.APIClient;
import net.techtalkit.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger Logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepositry employeeRepositry;
    //private RestTemplate restTemplate;
    private WebClient webClient;
    //private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        // This will convert departdto to the department jpa entity
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepositry.save(employee);
        //Below code will convert department jpa entity to the department dto
        EmployeeDto savedEmployeeDto=EmployeeMapper.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    //@CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDeaprtment")
    @Retry(name="${spring.application.name}",fallbackMethod = "getDefaultDeaprtment")
    public APIResponseDto getEmployeeById(Long employeeid) {
        Logger.info("Inside the getEmployeeById() method");
        Employee employee=employeeRepositry.findById(employeeid).get();
//        ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:8282/api/departments/"+employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto=responseEntity.getBody();
        DepartmentDto departmentDto=webClient.get()
                .uri("http://localhost:8282/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                 //We are passing the DeartmentDto.class in bodyToMono because we need response of departmentdto
                .bodyToMono(DepartmentDto.class)
                //Here we are using block method to make sure about asynchronus call
                .block();
       // DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(employee);
        APIResponseDto  apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
    public APIResponseDto getDefaultDeaprtment(Long employeeid, Exception exception){
        Logger.info("Inside the getDefaultDeaprtment() method");
        Employee employee=employeeRepositry.findById(employeeid).get();
        DepartmentDto departmentDto=new DepartmentDto();
        //Instead to make the call to the department service, Here we created default department
        departmentDto.setDepartmentName("R&D");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and development department");
        EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(employee);
        APIResponseDto  apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        //Below added the departmentdto to the API response.
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
