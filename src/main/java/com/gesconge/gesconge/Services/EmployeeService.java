package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Equipe;
import com.gesconge.gesconge.Repositories.IEmployee;
import com.gesconge.gesconge.Repositories.IEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService{
@Autowired
private IEmployee empRepo;
@Autowired
private IEquipe equipeRepo;
    @Override
    public Employee addEmployee(Employee emp) {

        return empRepo.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {

        return empRepo.save(emp);
    }

    @Override
    public void deleteEmployee(long IdEmp) {
        empRepo.deleteById(IdEmp);
    }

    @Override
    public Employee getEmployeeById(long IdEmp) {

        return empRepo.findById(IdEmp).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return empRepo.findAll();
    }

    @Override
    public void addEmployeeToEquipe(long id, String LibelleEquipe) {
    Employee emp=empRepo.findById(id).get();
    long Ideq=equipeRepo.GetIdEquipe(LibelleEquipe);
    Equipe eq=equipeRepo.findById(Ideq).get();
    emp.setEquipe(eq);
    eq.getListEmployee().add(emp);
    }

}
