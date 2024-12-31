package com.ems.sb;

import jakarta.persistence.*;

@Entity
@Table(name="emp")
public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String dept;

    public EmpEntity() {
    }

    public EmpEntity(Integer id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
