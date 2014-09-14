/* 
Даны два отсортированных числовых массива одинаковой длины N. 
Найдите медиану числового массива длины 2N, содержащего все 
числа из двух данных массивов.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Median {
	public static void main (String[] args) {
		ArrayList<Integer> listOne = new ArrayList<Integer>();
		listOne.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4}));
		
		ArrayList<Integer> listTwo = new ArrayList<Integer>();
		listTwo.addAll(Arrays.asList(new Integer[]{1, 4, 5, 6}));

		Service serv = new Service();
		System.out.println(serv.getMedian(listOne, listTwo)); // => 3.5
	}
	
}

class Service {
	public double getMedian(ArrayList<Integer> listOne, ArrayList<Integer> listTwo) {
		int halfLength = listOne.size();
		ArrayList<Integer> resultList = this.merge(listOne, listTwo); // слияние отсортированных массивов

		return (resultList.get(halfLength - 1) + resultList.get(halfLength)) / 2.0;
	}

	private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(left.size() > 0 && right.size() > 0) {
			if(left.get(0) <= right.get(0)) {
				result.add(left.remove(0));
			}
			else {
				result.add(right.remove(0));
			}
		}

		if(left.size() > 0) {
			result.addAll(left);
		}

		if(right.size() > 0) {
			result.addAll(right);
		}

		return result;
	}
}