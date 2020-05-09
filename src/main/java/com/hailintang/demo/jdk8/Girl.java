package com.hailintang.demo.jdk8;

/**
 * @author hailin.tang
 * @date 2020-03-25 17:00
 * @function
 */
public class Girl {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
