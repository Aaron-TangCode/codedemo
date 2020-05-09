package com.hailintang.demo.jdk8;

/**
 * @author hailin.tang
 * @date 2020-03-24 11:46
 * @function
 */
public class User {
    private Integer id;
    private String name;

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

    public User(Integer id, String name) {
        System.out.println("2222");
        this.id = id;
        this.name = name;
    }

    public User(Integer id) {
        System.out.println("11111");
        this.id = id;
    }

    public User() {
        System.out.println("==============");
    }
}
