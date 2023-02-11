package com.linda.Library.authorites;

import org.springframework.security.config.annotation.web.SecurityMarker;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.linda.Library.authorites.UserPermissions.ADMIN_WRITE;
import static com.linda.Library.authorites.UserPermissions.ADMIN_READ;
import static com.linda.Library.authorites.UserPermissions.USER_READ;

public enum UserRoles {
    ADMIN(Set.of(ADMIN_READ, ADMIN_WRITE));

    private final Set<UserPermissions> permissionsList;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissionsList = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissionsList;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {


        Set<SimpleGrantedAuthority> permissionsSet = getPermissions().stream().map(
                index -> new SimpleGrantedAuthority(index.getUserPermission())
        ).collect(Collectors.toSet());


        permissionsSet.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissionsSet;
    }
}
