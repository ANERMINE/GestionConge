package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Services.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Employee")
public class EmployeeController {
private IEmployeeService employeeService;
    @PostMapping("/AjouterEmployee")
    public Employee addEmployee(Employee emp) {

        return employeeService.addEmployee(emp);
    }
    @PutMapping("/ModifierEmployee")
    public Employee updateEmployee(Employee emp) {
        return employeeService.updateEmployee(emp);
    }

    @DeleteMapping("/removEmp/{idemp}")
    public void deleteEmployee(@PathVariable("idemp")long idemp) {
        employeeService.deleteEmployee(idemp);
    }


    @GetMapping("/GetById/{idemp}")
    public Employee getEmployeeById(@PathVariable("idemp")long idemp)
    {
        return employeeService.getEmployeeById(idemp);
    }
    @GetMapping("/All")
    public List<Employee> getAlEmployee() {
        return employeeService.getAllEmployee();
    }
    @PostMapping("AffecterEquipe/idemp/idEquipe")
    public int addEmployeeToEquipe(@PathVariable("idemp")long idem,@PathVariable("idequipe") long idEquipe) {
        return 0;
    }
}
