package ru.skypro.employee.employeewebapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Сотрудник не найден!");
    }
}
