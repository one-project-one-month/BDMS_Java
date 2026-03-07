package com.opom.bdms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing the many-to-many relationship between roles and permissions.
 * This is a junction table for role-based access control.
 */
@Entity
@Table(name = "role_permissions")
@Getter
@Setter
public class RolePermission extends MasterEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;
}
