package ru.skypro.employee.employeewebapp;

import ru.skypro.employee.employeewebapp.model.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTestConstants {
    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";

    public static final String FIRST_NAME2 = "Petr";
    public static final String LAST_NAME2 = "Petrov";

    public static final String FIRST_NAME3 = "Maksim";
    public static final String LAST_NAME3 = "Maksimov";
    public static final String FIRST_NAME4 = "Semen";
    public static final String LAST_NAME4 = "Semenov";
    public static final String FIRST_NAME5 = "Vazgen";
    public static final String LAST_NAME5 = "Vazgenov";
    public static final String FIRST_NAME6 = "Vladimir";
    public static final String LAST_NAME6 = "Vladimirov";
    public static final String FIRST_NAME7 = "Alexandr";
    public static final String LAST_NAME7 = "Alexandrov";
    public static final String FIRST_NAME8 = "Victor";
    public static final String LAST_NAME8 = "Victorov";
    public static final String FIRST_NAME9 = "Artem";
    public static final String LAST_NAME9 = "Artemov";
    public static final String FIRST_NAME10 = "Kirill";
    public static final String LAST_NAME10 = "Kirillov";
    public static final String INCORRECT_FIRST_NAME = "Kirill23$";
    public static final String INCORRECT_LAST_NAME = "Kirillov$16";
    public static final String FIRST_NAME11 = "Mark";
    public static final String LAST_NAME11 = "Markov";


    public static final int MIN_SALARY = 100;
    public static final int MAX_SALARY = 100_000;
    public static final int DEPARTMENT_ID = 1;
    public static final int DEPARTMENT_ID2 = 2;
    public static final int DEPARTMENT_ID3 = 3;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME, LAST_NAME, MAX_SALARY, DEPARTMENT_ID);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME, LAST_NAME, MIN_SALARY, DEPARTMENT_ID);
    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2, MIN_SALARY, DEPARTMENT_ID2);

    public static final List<Employee> EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final List<Employee> DIFFERENT_DEPARTMENTS_EMPLOYEES=List.of(MAX_SALARY_EMPLOYEE,MIN_SALARY_EMPLOYEE,DIFFERENT_DEPARTMENT_EMPLOYEE);
    public static final Integer DEPARTMENT_TOTAL_SALARY = EMPLOYEES.stream().mapToInt(Employee::getSalary).sum();

    public static final Map<Integer,List<Employee>> EMPLOYEES_BY_DEPARTMENT_MAP=DIFFERENT_DEPARTMENTS_EMPLOYEES.stream().collect(groupingBy(Employee::getDepartmentId));


}
