package ru.skypro.employee.employeewebapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {

        super("Сотрудник не может быть добавлен,Хранилище переполнено!");
    }
}
