package com.hailintang.demo.jdk8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hailin.tang
 * @date 2020-03-24 20:16
 * @function
 */
public class TestStream  {
    @Test
    public void test1(){
        //创建stream,通过集合
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        Stream<Employee> employeeStream = employees.parallelStream();
        //创建stream，通过数组
        int[] arr = new int[]{1,2,3};
        IntStream stream1 = Arrays.stream(arr);
         Employee e1 = new Employee(1,"123",12,123.23);
         Employee e2 = new Employee(2,"13",12,123.23);
         Employee[] arr2 = new Employee[]{e1,e2};
        Stream<Employee> stream2 = Arrays.stream(arr2);
        //通过stream的静态方法of
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        // 通过stream的iterate,无限流，用于造数据
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);
        // 通过stream的generate，无限流，用于造数据
        Stream.generate(Math::random).limit(10).forEach(System.out::println);


    }
    @Test
    public void test2(){
        //filter，--接受lambda,从流中排序某些元素
        List<Employee> employeeList = EmployeeData.getEmployees();
        Stream<Employee> stream3 = employeeList.stream();
        // filter过滤
        stream3.filter(e -> e.getSalary()>7000).forEach(System.out::println);
        System.out.println();
        // 限制元素个数
        employeeList.stream().limit(3).forEach(System.out::println);
        System.out.println();
        employeeList.stream().skip(3).forEach(System.out::println);

        System.out.println();

        employeeList.add(new Employee(100,"刘强东",34,9999.12));
        employeeList.add(new Employee(100,"刘强东",34,9999.12));
        employeeList.add(new Employee(100,"刘强东",34,9999.12));
        employeeList.add(new Employee(100,"刘强东",34,9999.12));
        //去重distinct
        employeeList.stream().distinct().forEach(System.out::println);

    }
    @Test
    public void test3(){
        //map
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(x -> x.toUpperCase()).forEach(System.out::println);
        //查找名字长度大于3
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameString = employees.stream().map(Employee::getName);
        nameString.filter(x -> x.length()>3).forEach(System.out::println);

        employees.stream().map(Employee::getName).filter(x -> x.length()>3).forEach(System.out::println);

        System.out.println("===============");
        //// map和flatMap的区别，有点类似于List方法的add和addAll的区别
        Stream<Stream<Character>> streamStream = list.stream().map(TestStream::toChar);
        streamStream.forEach(x -> {
            x.forEach(System.out::println);
        });
        Stream<Character> characterStream = list.stream().flatMap(TestStream::toChar);
        characterStream.forEach(System.out::println);
    }
    public static Stream<Character> toChar(String str){
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test4(){
        //自然排序
        List<Integer> list = Arrays.asList(1, 34, -8, 0, 65, 24, 23);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
    }

    @Test
    public void test5(){
        //终止操作
        // allMatch:检查是否匹配所有所有
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(x -> x.getAge() > 18);
        System.out.println("是否所有员工的年龄都大于18："+b);
        // anyMatch:检查是否至少有一个元素匹配
        boolean b1 = employees.stream().anyMatch(x -> x.getSalary() > 10000);
        System.out.println("是否至少有一个员工工资大于10000："+b1);
        // noneMatch:检查是否没有匹配的元素。
        boolean b2 = employees.stream().noneMatch(x -> x.getName().contains("雷"));
        System.out.println("当前流，是否没有姓雷的员工："+b2);
        // findFirst：返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println("第一个员工的名字："+employee.get().getName());
        // findAny:当前当前流中的任意元素
        Optional<Employee> employee1 = employees.stream().findAny();
        System.out.println("任意员工的名字："+employee1.get().getName());
        // count:返回当前流中的元素总数
        long count = employees.stream().count();
        System.out.println("当前流的员工总数:"+count);
        // max:返回流中的最大值
        Optional<Employee> max = employees.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println("当前流中，最大年龄的员工是："+max.get().getName());
        // min:返回流中的最小值
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("当前流中，最少工资的员工是："+min.get().getName());
        // forEach:内部迭代
        employees.stream().forEach(System.out::println);
    }
    @Test
    public void test6(){
        // 求1-10的累加和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(10, (x1, x2) -> Integer.sum(x1, x2));
        System.out.println(reduce);
        // 求公司的总工资
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1);

    }
    @Test
    public void test7(){
        //collect
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(x -> x.getSalary() > 6000.00).collect(Collectors.toList());
        collect.forEach(System.out::println);
        List<Boolean> collect1 = employees.stream().map(x -> x.getSalary() > 6000.00).collect(Collectors.toList());
        collect1.forEach(System.out::println);

    }
}
