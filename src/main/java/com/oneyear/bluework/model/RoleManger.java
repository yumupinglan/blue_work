package com.oneyear.bluework.model;

public class RoleManger {
    private String id;

    private String mangerId;

    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMangerId() {
        return mangerId;
    }

    public void setMangerId(String mangerId) {
        this.mangerId = mangerId == null ? null : mangerId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}