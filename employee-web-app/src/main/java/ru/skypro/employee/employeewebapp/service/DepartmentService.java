package ru.skypro.employee.employeewebapp.service;

import ru.skypro.employee.employeewebapp.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Integer getDepartmentSalarySum(int DepartmentId);
    Employee findEmployeeWithMaxSalary(int departmentId);
    Employee findEmployeeWithMinSalary(int departmentId);
    Collection<Employee> findEmployeesByDepartment(int departmentId);
    Map<Integer, List<Employee>>findEmployeesByDepartment();
}
