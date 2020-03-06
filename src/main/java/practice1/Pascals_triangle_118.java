package practice1;

import java.util.ArrayList;
import java.util.List;

public class Pascals_triangle_118 {
	
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	if(numRows <= 0)
    		return lists;
    	List<Integer> first = new ArrayList<Integer>();
    	first.add(1);
    	lists.add(first);
    	if(numRows == 1) {
    		return lists;
    	}
        for(int i=1; i<numRows; i++){
        	List<Integer> row = new ArrayList<Integer>();
        	row.add(1);
        	for(int j=1; j<i; j++) {
        		int number = lists.get(i-1).get(j-1)+lists.get(i-1).get(j);
        		row.add(number);
        	}
        	row.add(1);
        	lists.add(row);
        }
    	return lists;
    }
    
    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> first = new ArrayList<Integer>();
    	if(rowIndex <= 0)
    		return first;
    	first.add(1);
    	if(rowIndex == 1) {
    		return first;
    	}
    	int temp = 0;
        for(int i=1; i<=rowIndex; i++){
        	int temp1 = first.get(0);
        	for(int j=1; j<i; j++) {
        		temp = first.get(j);
        		first.set(j, temp1 + temp);
        		temp1 = temp;
        	}
        	first.add(1);
        }
    	return first;
    }

	public static void main(String[] args) {
		System.out.println(getRow(3));
	}

}
