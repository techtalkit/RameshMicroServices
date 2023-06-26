package net.techtalkit.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.techtalkit.departmentservice.dto.DepartmentDto;
import net.techtalkit.departmentservice.entities.Department;
import net.techtalkit.departmentservice.repository.DepartmentRepository;
import net.techtalkit.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department savedDepartment=departmentRepository.save(department);
        DepartmentDto saveddepartmentDto=new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentname(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
        return saveddepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto=new DepartmentDto(
                department.getId(),
                department.getDepartmentname(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
