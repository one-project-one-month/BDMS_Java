package com.opom.bdms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entity representing a permission in the system.
 * Permissions define specific actions or access rights.
 */
@Entity
@Table(name = "permissions")
@Getter
@Setter
public class Permission extends MasterEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL)
    private List<RolePermission> rolePermissions;
}
