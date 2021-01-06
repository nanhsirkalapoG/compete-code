import java.util.HashMap;

/** Given an array of integers, return indices of the two numbers such that
	they add up to a specific target **/
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] elements = new int[] {2, 7, 11, 15};
		int target = 9;
		int[] sumIndices = getSumIndices(elements, target);
		
		System.out.println("Target indices are: [" + sumIndices[0] + ", " + sumIndices[1] + "]");
	}
	
	public static int[] getSumIndices(int[] elements, int target) {
		int[] sumIndices = new int[2];
		HashMap<Integer, Integer> indexMap = new HashMap<>();
		
		for(int index = 0; index < elements.length; index++) {
			if (indexMap.containsKey(target - elements[index])) {
				sumIndices[0] = indexMap.get(target - elements[index]);
				sumIndices[1] = index;
				break;
			}
			indexMap.put(elements[index], index);
		}
		
		return sumIndices;
	}

}
