package com.linda.Library.Authorities;

public enum UserPermissions {

    USER_READ("user:read" ),
    ADMIN_READ("admin:read" ),
    ADMIN_WRITE ("admin:write" );
    private String permissions;
    void UserPermissions(String permissions) {
        this.permissions = permissions;
    }

    UserPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }
}
