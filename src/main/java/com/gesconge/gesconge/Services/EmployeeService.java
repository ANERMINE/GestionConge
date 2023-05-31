package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Repositories.IEmployee;

import java.util.List;

public class EmployeeService implements IEmployeeService{

private IEmployee empRepo;
    @Override
    public Employee addEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {

        return null;
    }

    @Override
    public void deleteEmployee(Employee emp) {

    }

    @Override
    public Employee getEmployeeById(long idemp) {
        return null;
    }

    @Override
    public List<Employee> getAlEmployee() {
        return null;
    }

    @Override
    public int addEmployeeToEquipe(long id, long idEquipe) {
        return 0;
    }

}
