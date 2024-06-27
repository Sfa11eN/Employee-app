package ru.skypro.employee.employeewebapp.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.employee.employeewebapp.exceptions.InvalidEmployeeDataException;

import static org.apache.commons.lang3.StringUtils.isAlpha;
@Service

public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);

    }

    private void validateName(String name){
        if (!isAlpha(name)){
            throw new InvalidEmployeeDataException("Некорректно введены данные сотрудника");
        }
    }
}
