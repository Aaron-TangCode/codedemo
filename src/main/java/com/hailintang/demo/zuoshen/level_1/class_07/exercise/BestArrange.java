package com.hailintang.demo.zuoshen.level_1.class_07.exercise;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Aaron
 * @date 2020-03-06 08:53
 * @function
 */
public class BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }

    }


    public int bestArrange(Program[] programs){
        //对数组排序：根据项目的结束时间从早到晚排序
        Arrays.sort(programs,new ProgramComparator());
        int res = 0;
        int timePoint = 0;
        for (int i = 0; i < programs.length; i++) {
            if(timePoint<programs[i].start){
                res++;
                timePoint = programs[i].end;
            }
        }
        return res;
    }
}
