package ru.skypro.employee.employeewebapp.service.impl;

import org.junit.jupiter.api.Test;
import ru.skypro.employee.employeewebapp.exceptions.InvalidEmployeeDataException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.skypro.employee.employeewebapp.EmployeeTestConstants.INCORRECT_FIRST_NAME;
import static ru.skypro.employee.employeewebapp.EmployeeTestConstants.INCORRECT_LAST_NAME;

public class EmployeeValidationServiceImplTest {
    public static final EmployeeValidationService validationService=new EmployeeValidationServiceImpl();

    @Test
    public void shouldThrowInvalidEmployeeDataException(){

        assertThrows(InvalidEmployeeDataException.class,
                () -> validationService.validate(INCORRECT_FIRST_NAME,INCORRECT_LAST_NAME));
    }


}
