package org.academiadecodigo.model;

/**
 * Created by codecadet on 01/12/16.
 */
public class Role {


    private int role_id;
    private String type_role;

    public Role() {
    }

    public Role(int role_id, String type_role) {
        this.role_id = role_id;
        this.type_role = type_role;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getType_role() {
        return type_role;
    }

    public void setType_role(String type_role) {
        this.type_role = type_role;
    }
}
