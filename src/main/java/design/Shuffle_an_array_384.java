package design;

import java.util.*;

public class Shuffle_an_array_384 {
    int[] array;
    int[] origin;
    Random random = new Random();
    public Shuffle_an_array_384(int[] nums) {
        this.array = nums;
        origin = array.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = origin;
        origin = origin.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(array).forEach(list::add);
        for (int i = 0; i< array.length; i++){
            int index = random.nextInt(list.size());
            array[i] = list.get(index);
            list.remove(index);
        }
        return array;
    }
}

class Shuffle_an_array_384_1 {
    int[] array;
    int[] origin;
    Random random = new Random();
    public Shuffle_an_array_384_1(int[] nums) {
        this.array = nums;
        origin = array.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = origin;
        origin = origin.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int length = array.length;
        for (int i = 0; i< length; i++){
            swap(i, nextIndex(i, length));
        }
        return array;
    }

    private int nextIndex(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private void swap(int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}