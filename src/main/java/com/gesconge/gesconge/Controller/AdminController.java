package com.gesconge.gesconge.Controller;


import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Repositories.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:50809", maxAge = 3600, allowCredentials="true")
@RequestMapping("/employees")
public class AdminController {

    @Autowired
    private IEmployee employeeRepository;

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")

    public ResponseEntity<Employee> getUserById(@PathVariable("id") Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
