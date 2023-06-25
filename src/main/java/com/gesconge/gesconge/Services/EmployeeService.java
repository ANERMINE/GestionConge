package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Equipe;
import com.gesconge.gesconge.Repositories.IEmployee;
import com.gesconge.gesconge.Repositories.IEquipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private IEmployee empRepo;
    private IEquipe eqRepo;

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
    public List<Employee> getAllEmployee() {

        return empRepo.findAll();
    }

    @Override
    public int addEmployeeToEquipe(long id, String codeEq) {
/*        Employee e =new Employee();
        Equipe eq=new Equipe();
        e=empRepo.findById(id).get();
        eq=eqRepo.findEquipeByCode(codeEq);
*/
        return 0;
    }

    @Override
    public List<Employee> GetEmployeeParEquipe(String LibelleEq) {
        return null;
    }

}
