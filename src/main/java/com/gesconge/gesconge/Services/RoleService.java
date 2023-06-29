package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Role;
import com.gesconge.gesconge.Repositories.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService{
    @Autowired
    IRole roleRepo;
    @Override
    public Role addRole(Role r) {
        return roleRepo.save(r);
    }

    @Override
    public Role updateRole(Role r) {
        return roleRepo.save(r);
    }

    @Override
    public List<Role> GetAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role GetRoleById(long idrole) {
        return roleRepo.findById(idrole).get();
    }

    @Override
    public long GetIdRole(String libelle) {
        return roleRepo.GetIdRole(libelle);
    }
}
