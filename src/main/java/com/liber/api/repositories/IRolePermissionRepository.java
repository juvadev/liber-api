package com.liber.api.repositories;

import com.liber.api.models.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolePermissionRepository extends JpaRepository<RolePermission, Integer> {

}
