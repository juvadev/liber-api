package com.liber.api.controllers;

import com.liber.api.models.Role;
import com.liber.api.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ArrayList<Role> getRoles() {
        return this.roleService.getRoles();
    }

    @GetMapping("/{id}")
    public Optional<Role> getRoleById (@PathVariable int id) {
        return this.roleService.getRoleById(id);
    }

    @PostMapping("/save")
    public Role saveRole (@RequestBody Role role) {
        return this.roleService.saveRole(role);
    }

    @PutMapping("/update/{id}")
    public Role updateRoleById (@PathVariable int id, @RequestBody Role role) {
        return this.roleService.updateRoleById(id, role);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteRoleById (@PathVariable int id) {
        return this.roleService.deleteRolById(id);
    }
}
