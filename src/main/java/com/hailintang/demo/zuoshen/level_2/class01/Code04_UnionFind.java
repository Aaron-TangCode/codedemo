package com.hailintang.demo.zuoshen.level_2.class01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code04_UnionFind {

	// 样本进来会包一层，叫做元素
	public static class Element<V> {
		public V value;

		public Element(V value) {
			this.value = value;
		}

	}

	public static class UnionFindSet<V> {
		public HashMap<V, Element<V>> elementMap;
		// key  某个元素  value 该元素的父
		public HashMap<Element<V>, Element<V>> fatherMap;
		// key 某个集合的代表元素   value 该集合的大小
		public HashMap<Element<V>, Integer> sizeMap;

		public UnionFindSet(List<V> list) {
			elementMap = new HashMap<>();
			fatherMap = new HashMap<>();
			sizeMap = new HashMap<>();
			for (V value : list) {
				Element<V> element = new Element<V>(value);
				elementMap.put(value, element);
				fatherMap.put(element, element);
				sizeMap.put(element, 1);
			}
		}

		// 给定一个element，往上一直找，把代表元素返回
		private Element<V> findHead(Element<V> element) {
			Stack<Element<V>> path = new Stack<>();
			while (element != fatherMap.get(element)) {
				path.push(element);
				element = fatherMap.get(element);
			}
			while (!path.isEmpty()) {
				fatherMap.put(path.pop(), element);
			}
			return element;
		}

		public boolean isSameSet(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
			}
			return false;
		}
		/*连接元素*/
		public void union(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				Element<V> aF = findHead(elementMap.get(a));
				Element<V> bF = findHead(elementMap.get(b));
				if (aF != bF) {
					Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
					Element<V> small = big == aF ? bF : aF;
					fatherMap.put(small, big);
					sizeMap.put(big, sizeMap.get(aF) + sizeMap.get(bF));
					sizeMap.remove(small);
				}
			}
		}

		public int getSizeNum(){
			return sizeMap.size();
		}
	}

	public static int getIslandSize(int[][] m){
		if(m.length<=0||m[0].length<=0){
			return 0;
		}
		int maxRow = m.length;
		int maxCol = m[0].length;
		List<String> list = new ArrayList<>();
		for(int i=0;i<maxRow;i++){
			for(int j=0;j<maxCol;j++){
				if(m[i][j]==1){
					String position = i+"_"+j;
					list.add(position);
				}
			}
		}
		//构造并查集
		UnionFindSet<String> unionSet = new UnionFindSet<>(list);
		//把上下左右的1连接起来
		for(int row=0;row<maxRow;row++){
			for(int col=0;col<maxCol;col++){
				if(m[row][col]==1){
					String position = String.valueOf(row)+"_"+String.valueOf(col);
					//上
					if(row-1>=0&&m[row-1][col]==1){
						String up = String.valueOf(row-1)+"_"+String.valueOf(col);
						unionSet.union(position,up);
					}
					//下
					if(row+1<maxRow&&m[row+1][col]==1){
						String down = String.valueOf(row+1)+"_"+String.valueOf(col);
						unionSet.union(position,down);
					}
					//左
					if(col-1>=0&&m[row][col-1]==1){
						String left = String.valueOf(row)+"_"+String.valueOf(col-1);
						unionSet.union(position,left);
					}
					//右
					if(col+1<maxCol&&m[row][col+1]==1){
						String rignt = String.valueOf(row)+"_"+String.valueOf(col+1);
						unionSet.union(position,rignt);
					}
				}
			}
		}
		return unionSet.getSizeNum();

	}
	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 0, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(getIslandSize(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(getIslandSize(m2));

	}

}
