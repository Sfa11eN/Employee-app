package ru.skypro.employee.employeewebapp.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.employee.employeewebapp.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.employee.employeewebapp.exceptions.EmployeeNotFoundException;
import ru.skypro.employee.employeewebapp.exceptions.EmployeeStorageIsFullException;
import ru.skypro.employee.employeewebapp.model.Employee;
import ru.skypro.employee.employeewebapp.service.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private static final int EMPLOYEE_STORAGE_SIZE = 10;
    private List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() == EMPLOYEE_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException();

        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
            return employee;
        }

        @Override
        public Employee find (String firstName, String lastName){
            Employee employee = new Employee(firstName, lastName);
            if (employees.contains(employee)) {
                throw new EmployeeNotFoundException();
            }
            employees.remove(employee);
            return employee;
        }

        @Override
        public Collection<Employee> findAll () {
            return employees;
        }
    }
