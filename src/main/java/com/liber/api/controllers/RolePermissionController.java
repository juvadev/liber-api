package com.liber.api.controllers;

import com.liber.api.models.RolePermission;
import com.liber.api.services.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("roles_permissions")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @GetMapping
    public ArrayList<RolePermission> getRolesPermissions () {
        return rolePermissionService.getRolesPermissions();
    }

    @GetMapping("/{id}")
    public Optional<RolePermission> getRolePermissionById (@PathVariable int id) {
        return rolePermissionService.getRolePermissionById(id);
    }

    @PostMapping("/save")
    public RolePermission saveRolePermission (@RequestBody RolePermission rolePermission) {
        return rolePermissionService.saveRolePermission(rolePermission);
    }

    @PutMapping("update/{id}")
    public RolePermission updateRolePermissionById (@PathVariable int id, @RequestBody RolePermission request) {
        return rolePermissionService.updateRolePermissionById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteRolePermissionById (@PathVariable int id) {
        return rolePermissionService.deleteRolePermissionById(id);
    }
}
