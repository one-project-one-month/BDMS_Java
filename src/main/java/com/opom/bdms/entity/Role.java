package com.opom.bdms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entity representing a role in the system.
 * Roles define user permissions through the role_permissions relationship.
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends MasterEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<RolePermission> rolePermissions;
}
