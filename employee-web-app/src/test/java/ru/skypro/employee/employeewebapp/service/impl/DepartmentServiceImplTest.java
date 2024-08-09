package ru.skypro.employee.employeewebapp.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.employee.employeewebapp.exceptions.EmployeeNotFoundException;
import ru.skypro.employee.employeewebapp.service.EmployeeService;

import java.util.Collections;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.skypro.employee.employeewebapp.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)

class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnTotalSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(DEPARTMENT_TOTAL_SALARY, departmentService.getDepartmentSalarySum(DEPARTMENT_ID));
    }
    @Test
    public void shouldReturnEmployeeWithMaxSalary(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldReturnEmployeeWithMinSalary(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMaxSalaryEmployee(){
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,() ->departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMinSalaryEmployee(){
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,() ->departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }
    @Test
    public void ShouldFindEmployeesByDepartmentId(){

        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENTS_EMPLOYEES);
        assertEquals(singletonList(MAX_SALARY_EMPLOYEE),departmentService.findEmployeesByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(DIFFERENT_DEPARTMENT_EMPLOYEE),departmentService.findEmployeesByDepartment(DEPARTMENT_ID2));
    }
    @Test
    public void shouldReturnEmployeesByDepartmentMap() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENTS_EMPLOYEES);
        assertEquals(EMPLOYEES_BY_DEPARTMENT_MAP,departmentService.findEmployeesByDepartment());
    }
}


