package edu.ahau.mvc.entity;

/**
 * @author zhangxuna
 * @date 2021-12-21 14:52
 */
public class User {
   private String name;
   private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
