package net.techtalkit.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.techtalkit.departmentservice.dto.DepartmentDto;
import net.techtalkit.departmentservice.entities.Department;
import net.techtalkit.departmentservice.mapper.DepartmentMapper;
import net.techtalkit.departmentservice.repository.DepartmentRepository;
import net.techtalkit.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //Below code will convert departmentdto to the department jpa entity
        Department department= DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment=departmentRepository.save(department);
        //Below code will convert department jpa entity to the department dto
        DepartmentDto saveddepartmentDto=DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return saveddepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        //This will convert department jpa entity to department dto
        DepartmentDto departmentDto=DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
}
