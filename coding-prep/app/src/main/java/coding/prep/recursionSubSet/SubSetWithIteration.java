package coding.prep.recursionSubSet;

import java.util.List;
import java.util.ArrayList;

//[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3], [4], [1, 4], [2, 4], [1, 2, 4], [3, 4], [1, 3, 4], [2, 3, 4], [1, 2, 3, 4]]
public class SubSetWithIteration {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4};
        System.out.println(getSubsetsForInput(input));
    }

    static List<List<Integer>> getSubsetsForInput(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());

        for(int num : nums){
            int totalLengthOfSubset = subsets.size(); // get total legth of subset 
            for(int sIndex = 0 ; sIndex < totalLengthOfSubset ; sIndex++){
                List<Integer> newSubset = new ArrayList<>(subsets.get(sIndex));  //create child subset to duplicate the parent subset and add the num to each list
                newSubset.add(num); // add num from the array in each subset
                subsets.add(newSubset);  //add the new updated subset to the subset
            }
        }
        return subsets;
    }
}
