package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Repositories.IEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

private IEmployee empRepo;
    @Override
    public Employee addEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {

        return empRepo.save(emp);
    }

    @Override
    public void deleteEmployee(long idemp) {
        empRepo.deleteById(idemp);
    }

    @Override
    public Employee getEmployeeById(long idemp) {

        return empRepo.findById(idemp).get();
    }

    @Override
    public List<Employee> getAlEmployee() {

        return empRepo.findAll();
    }

    @Override
    public int addEmployeeToEquipe(long id, long idEquipe) {
        return 0;
    }

}
