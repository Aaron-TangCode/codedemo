package com.hailintang.demo.jdk8.gc.oom;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {

    public static void main(String[] args) {
        List<Dandan> list = new ArrayList<>();
        while (true){
            list.add(new Dandan());
        }
    }
}

class Dandan{

}
