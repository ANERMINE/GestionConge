package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;

import java.util.List;

public interface IEmployeeService {
    //Employee addEmployee(Employee emp);
    Employee updateEmployee(Employee emp);
    void deleteEmployee(long IdEmp);
    Employee getEmployeeById(long idemp);
    List<Employee>getAllEmployee();
    void addEmployeeToEquipe(long id,String LibelleEquipe);
    long GetIdEmp(String username);
    float GetSoldeCongeById(long idEmp);


    Employee addEmployee(Employee emp, long equipeId, long roleId, Long responsableId);
    public List<Employee> GetListeEmployeeByResp(long idEmp);
}
