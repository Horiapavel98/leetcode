import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ShuffleArray class for mimicking 
 * array shuffling.
 */
public class ShuffleArray {

    private int[] elementData;
    private int[] backUp;

    public ShuffleArray(int[] nums) {
        elementData = nums;
        
        // Perform hard copy of array
        backUp = new int[nums.length];
        for (int i = 0 ; i < nums.length; ++i) {
            backUp[i] = nums[i];
        }
    }

    /**
     * Prepare initial array for shuffling
     */
    private void prepareOffsetArray() {
        for (int i = 0 ; i < elementData.length ; ++i) {
            elementData[i] = backUp[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return backUp;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        prepareOffsetArray();
        
        List<Integer> elementDataList = new ArrayList<>(elementData.length);
        for (int i : elementData){ 
            elementDataList.add(i);
        }
        
        Collections.shuffle(elementDataList);
        
        for (int i = 0 ; i < elementData.length ; ++i) {
            elementData[i] = elementDataList.get(i);
        }
        
        return elementData;
    }

    public static void main(String[] args) {
        ShuffleArray s = new ShuffleArray(new int[] {1, 2, 3});

        s.shuffle();
        s.reset();
        s.shuffle();

        System.out.println(Arrays.asList(s.elementData));
    }

}