package com.hailintang.demo.zuoshen.level_1.class_07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Code04_BestArrange {

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
	//贪心算法
	public static int bestArrange(Program[] programs, int timePoint) {
		//根据项目结束的时间从早到晚排序
		Arrays.sort(programs, new ProgramComparator());
		//记录结果
		int result = 0;
		// 从左往右依次遍历所有的会议
		for (int i = 0; i < programs.length; i++) {
			//如果当前时间点，小于项目的开始时间，那就安排上，结果+1
			if (timePoint <= programs[i].start) {
				result++;
				//时间点，更新为项目的结束时间
				timePoint = programs[i].end;
			}
		}
		return result;
	}

	public static int bestArrangeForce(Program[] programs, int timePoint){
		HashSet<Program> set = new HashSet<>(Arrays.asList(programs));
		return process(set,timePoint);
	}

	private static int process(HashSet<Program> set, int timePoint) {
		int result = 0;
		HashSet<Program> candidates = new HashSet<>();
		for (Program program : set) {
			if(program.start>=timePoint){
				candidates.add(program);
			}
		}

		HashSet<Program> tmp = new HashSet<>(candidates);

		for (Program program : tmp) {
			candidates.remove(program);

			int res = process(candidates,program.end);
			result = Math.max(result,res+1);
			candidates.add(program);
		}
		return result;
	}

	public static void main(String[] args) {
		Program p1 = new Program(0,3);
		Program p2 = new Program(1,2);
		Program p3 = new Program(2,7);
		Program p4 = new Program(3,4);
		Program p5 = new Program(4,5);

		Program[] programs = new Program[]{p1,p2,p3,p4,p5};

		int bestArrange = bestArrange(programs, 3);
		System.out.println(bestArrange);

		int bestArrangeForce = bestArrangeForce(programs, 3);
		System.out.println(bestArrangeForce);
	}


}
