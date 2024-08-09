package ru.skypro.employee.employeewebapp.service.impl;

import org.junit.jupiter.api.Test;
import ru.skypro.employee.employeewebapp.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.employee.employeewebapp.exceptions.EmployeeNotFoundException;
import ru.skypro.employee.employeewebapp.exceptions.EmployeeStorageIsFullException;
import ru.skypro.employee.employeewebapp.model.Employee;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.skypro.employee.employeewebapp.EmployeeTestConstants.*;

class EmployeeServiceImplTest {
    private final EmployeeValidationService validationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(validationService);

    @Test
    public void shouldAddEmployee() {
        assertEquals(0, employeeService.findAll().size());

        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID);
        assertEquals(1, employeeService.findAll().size());
        assertTrue(employeeService.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeStorageIsFullException() {
        employeeService.add(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID);
        employeeService.add(FIRST_NAME2, LAST_NAME2, MAX_SALARY, DEPARTMENT_ID);
        employeeService.add(FIRST_NAME3, LAST_NAME3, MAX_SALARY, DEPARTMENT_ID);
        employeeService.add(FIRST_NAME4, LAST_NAME4, MAX_SALARY, DEPARTMENT_ID);
        employeeService.add(FIRST_NAME5, LAST_NAME5, MAX_SALARY, DEPARTMENT_ID);
        employeeService.add(FIRST_NAME6, LAST_NAME6, MAX_SALARY, DEPARTMENT_ID);
        employeeService.add(FIRST_NAME7, LAST_NAME7, MAX_SALARY, DEPARTMENT_ID);
        employeeService.add(FIRST_NAME8, LAST_NAME8, MAX_SALARY, DEPARTMENT_ID);
        employeeService.add(FIRST_NAME9, LAST_NAME9, MAX_SALARY, DEPARTMENT_ID);
        employeeService.add(FIRST_NAME10, LAST_NAME10, MAX_SALARY, DEPARTMENT_ID);

        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.add(FIRST_NAME11, LAST_NAME11, MAX_SALARY, DEPARTMENT_ID));

    }

    @Test
    public void shouldThrownEmployeeAlreadyAddedException() {

        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.add(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID));

    }

    @Test
    public void shouldRemoveEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID);

        Employee removedEmployee = employeeService.remove(FIRST_NAME, LAST_NAME);
        assertFalse(employeeService.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemove() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove(FIRST_NAME, LAST_NAME));
    }
    @Test
    public void shouldFindEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID);
        assertEquals(addedEmployee,employeeService.find(FIRST_NAME,LAST_NAME));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFind() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find(FIRST_NAME, LAST_NAME));
    }
    @Test
    public void shouldReturnAllEmployees() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID);
        Employee addedEmployee2 = employeeService.add(FIRST_NAME2, LAST_NAME2, MAX_SALARY, DEPARTMENT_ID);

        Collection<Employee> addedEmployees=employeeService.findAll();
        assertIterableEquals(List.of(addedEmployee,addedEmployee2),addedEmployees);
    }
}