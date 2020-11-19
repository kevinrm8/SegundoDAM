/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecodeup.model;

/**
 *
 * @author kevin
 */
public class Cliente {
        private int user_id;
    private String name;
    private String last_name;
    private String user_name;
    private String password;
    private String email;
    
    public Cliente(int user_id, String name, String last_name, String user_name, String password, String email) {
        this.user_id = user_id;
        this.name = name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
    }

    public Cliente(String name, String last_name, String user_name, String password, String email) {
        this.name = name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
    }

    public Cliente() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "user_id=" + user_id + ", name=" + name + ", last_name=" + last_name + ", user_name=" + user_name + ", password=" + password + ", email=" + email + '}';
    }
}
