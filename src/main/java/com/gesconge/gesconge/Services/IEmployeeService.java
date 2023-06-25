package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Equipe;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee emp);
    Employee updateEmployee(Employee emp);
    void deleteEmployee(long idemp);
    Employee getEmployeeById(long idemp);
    List<Employee>getAllEmployee();
    int addEmployeeToEquipe(long id,String CodeEq);
    List<Employee>GetEmployeeParEquipe(String LibelleEq);




}
