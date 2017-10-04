package com.netflorist.netflorist.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer")
public class Customer implements Serializable
{

    @Id
    @Column(name = "customer_id")
    private String id;
    @Column(name = "name")
    private String name;
    private String surname;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    private String gender;
    @Temporal(TemporalType.DATE)
    @Column(name = "dateofbirth")    
    private Date dob;
    private String username;
    private String password;
    private String userRole ;
    private String securityQue;
    private String securityAns;
    
   
    @Override
    public String toString() {
        return "A reservation{"
                + "id:" + id
                + ", name='" + name + '\''
                + '}';
    }

    public Customer() {
    }

    public Customer(String id) {
        this.id = id;
    }
    


    public Customer(String id, String name, String surname, String email, String gender, Date dob, String username, String password, String userRole, String securityQuestio, String securityAns) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.securityQue = securityQuestio;
        this.securityAns = securityAns;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getSecurityQue() {
        return securityQue;
    }

    public void setSecurityQue(String securityQue) {
        this.securityQue = securityQue;
    }

    public String getSecurityAns() {
        return securityAns;
    }

    public void setSecurityAns(String securityAns) {
        this.securityAns = securityAns;
    }

    
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    
}
