package com.hailintang.demo.jdk8;

import java.util.*;

public class TaskEntity {
    private Integer taskId;

    private Integer phase;

    private String name;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskEntity(Integer taskId, Integer phase, String name) {
        this.taskId = taskId;
        this.phase = phase;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(taskId, that.taskId) &&
                Objects.equals(phase, that.phase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, phase);
    }

    public static void main(String[] args) {
//        List<TaskEntity> list = new ArrayList<>();
//
//        TaskEntity t1 = new TaskEntity(1,1,"任务一阶段一");
//        TaskEntity t2 = new TaskEntity(2,1,"任务二阶段一");
//
//        list.add(t1);
//        list.add(t2);
//
//
//        List<TaskEntity> bigSource = new ArrayList<>();
//        TaskEntity t11 = new TaskEntity(1,1,"任务一阶段一1");
//        TaskEntity t12 = new TaskEntity(1,2,"任务一阶段二1");
//        TaskEntity t13 = new TaskEntity(1,3,"任务一阶段三1");
//        TaskEntity t21 = new TaskEntity(2,1,"任务二阶段一1");
//        TaskEntity t22 = new TaskEntity(2,2,"任务二阶段二1");
//        TaskEntity t23 = new TaskEntity(2,3,"任务二阶段三1");
//        bigSource.add(t11);
//        bigSource.add(t12);
//        bigSource.add(t13);
//        bigSource.add(t21);
//        bigSource.add(t22);
//        bigSource.add(t23);
//
//
//        bigSource.removeAll(list);
//
//        bigSource.addAll(list);
//        System.out.println(bigSource);
//        Map<Integer,Integer> map  = new HashMap<>();
//        map.put(1,1);
//        System.out.println(UUID.randomUUID());

        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
//        Set<Integer> set = map.keySet();

//        Iterator<Integer> iterator = set.iterator();
//        while(iterator.hasNext()){
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
    }
}
