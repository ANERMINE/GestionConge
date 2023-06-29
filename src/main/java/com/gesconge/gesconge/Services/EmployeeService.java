package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Equipe;
import com.gesconge.gesconge.Entities.Role;
import com.gesconge.gesconge.Repositories.IEmployee;
import com.gesconge.gesconge.Repositories.IEquipe;
import com.gesconge.gesconge.Repositories.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService{
@Autowired
private IEmployee empRepo;
@Autowired
private IEquipe equipeRepo;
@Autowired
private IRole roleRepo;
    @Override
    public Employee addEmployee(Employee emp) {
        Equipe eq=new Equipe();
        long Ideq=equipeRepo.GetIdEquipe(emp.getEquipe().getCodeEquipe());

        eq=equipeRepo.findById(Ideq).get();
        emp.setEquipe(eq);
        eq.getListEmployee().add(emp);




        //Affectation role
        Role role=new Role();
        role=roleRepo.findById(roleRepo.GetIdRole(emp.getRole().getLibelle())).get();
        //Employee resp=new Employee();
       // resp=empRepo.findById(GetIdEmp(emp.getResponsable().getUsername())).get();


            //Affectaion Responsable
            if(emp.getRole().equals("Rh")==false)
            {
                Employee resp=new Employee();
                resp=empRepo.findById(GetIdEmp(emp.getResponsable().getUsername())).get();
                resp.getEmployeesSupervises().add(emp);
                emp.setResponsable(resp);

            }



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
    public long GetIdEmp(String username)
    {
        return empRepo.GetIdEmp(username);
    }


}
