package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Entities.Role;
import com.gesconge.gesconge.Services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {
    @Autowired
    private  IRoleService RoleServ;
    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role r) {
        return RoleServ.addRole(r);
    }

    @PutMapping("/updateRole")
    public Role updateRole(@RequestBody Role r) {
        return RoleServ.updateRole(r);
    }

    @GetMapping("/GetAll")
    public List<Role> GetAllRoles() {
        return RoleServ.GetAllRoles();
    }

    @GetMapping("/GetById/{idR}")
    public Role GetRoleById(@PathVariable("idR") long idR) {
        return RoleServ.GetRoleById(idR);
    }

    @GetMapping("/GetByLibelle/{libelle}")
    public long GetIdRole(@PathVariable("libelle")String libelle) {
        return RoleServ.GetIdRole(libelle);
    }
}
