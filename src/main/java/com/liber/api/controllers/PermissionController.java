package com.liber.api.controllers;

import com.liber.api.models.Permission;
import com.liber.api.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public ArrayList<Permission> getPermissions () {
        return this.permissionService.getPermissions();
    }

    @GetMapping("/{id}")
    public Optional<Permission> getPermissionById (@PathVariable int id) {
        return this.permissionService.getPermissionById(id);
    }

    @PostMapping("/save")
    public Permission savePermission (@RequestBody Permission permission) {
        return this.permissionService.savePermission(permission);
    }

    @PutMapping("/update/{id}")
    public Permission updatePermissionById (@PathVariable int id, @RequestBody Permission request) {
        return this.permissionService.updatePermissionById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deletePermissionById (@PathVariable int id) {
        return this.permissionService.deletePermissionById(id);
    }
}

