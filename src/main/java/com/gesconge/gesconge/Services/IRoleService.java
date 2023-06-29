package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Role;

import java.util.List;

public interface IRoleService {
    Role addRole(Role r);
    Role updateRole(Role r);
    List<Role> GetAllRoles();
    Role GetRoleById(long idrole);
    long GetIdRole(String libelle);

}
