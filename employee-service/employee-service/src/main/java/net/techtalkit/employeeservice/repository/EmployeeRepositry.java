package net.techtalkit.employeeservice.repository;

import net.techtalkit.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositry extends JpaRepository<Employee,Long> {
}
