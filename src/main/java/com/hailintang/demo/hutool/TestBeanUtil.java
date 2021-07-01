package com.hailintang.demo.hutool;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

import java.util.HashMap;
import java.util.Map;

public class TestBeanUtil {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        Map<String,String> fieldMapping = new HashMap<>();
        map.put("names","tanghailin");
        map.put("age","24");

        fieldMapping.put("names","name");

        CopyOptions copyOptions = CopyOptions.create();
        copyOptions.setFieldMapping(fieldMapping);

        Entity entity = BeanUtil.mapToBean(map, Entity.class, true, copyOptions);

        System.out.println(entity);
    }

    class Entity{
        String name;
        Long age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
