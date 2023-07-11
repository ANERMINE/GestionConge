package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Services.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

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
    @ResponseBody
    public List<Employee> getAlEmployee() {

        return employeeService.getAllEmployee();
    }
    @PostMapping("AffecterEquipe/{idemp}/{idEquipe}")
    public void addEmployeeToEquipe(@PathVariable("IdEmp")long IdEmp,@PathVariable("codeEq") String codeEq) {

         employeeService.addEmployeeToEquipe(IdEmp,codeEq);
    }
    @GetMapping("GetSolde/{IdEmp}")
    public float GetSoldeCongeById(@PathVariable("IdEmp")long IdEmp) {

       return employeeService.GetSoldeCongeById(IdEmp);
    }
    @PostMapping("/AjouterEmployee/{equipeId}/{roleId}")
    public Employee addEmployee(@RequestBody Employee emp , @PathVariable long equipeId , @PathVariable long roleId, @RequestParam(name = "responsableId" ,required = false) Long responsableId) {

        return employeeService.addEmployee(emp , equipeId , roleId,responsableId);
    }
    @GetMapping("GetEmployeByResp/{idEmp}")
    public List<Employee> GetListeEmployeeByResp(@PathVariable("idEmp") long idEmp){
        return employeeService.GetListeEmployeeByResp(idEmp);
    }
}
