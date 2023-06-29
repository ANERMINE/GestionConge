package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Services.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @PostMapping("/AjouterEmployee")
    public Employee addEmployee(@RequestBody Employee emp) {

        return employeeService.addEmployee(emp);
    }
    @PutMapping("/ModifierEmployee")
    public Employee updateEmployee(Employee emp) {
        return employeeService.updateEmployee(emp);
    }

    @DeleteMapping("/removEmp/{idemp}")
    public void deleteEmployee(@PathVariable("idemp")int idemp) {
        employeeService.deleteEmployee(idemp);
    }


    @GetMapping("/GetById/{idemp}")
    public Employee getEmployeeById(@PathVariable("idemp")int idemp)
    {
        return employeeService.getEmployeeById(idemp);
    }
    @GetMapping("/All")
    public List<Employee> getAlEmployee() {

        return employeeService.getAllEmployee();
    }
    @PostMapping("AffecterEquipe/idemp/idEquipe")
    public void addEmployeeToEquipe(@PathVariable("IdEmp")long IdEmp,@PathVariable("codeEq") String codeEq) {

         employeeService.addEmployeeToEquipe(IdEmp,codeEq);
    }

}
