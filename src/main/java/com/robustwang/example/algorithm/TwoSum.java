package com.robustwang.example.algorithm;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int array[] = {3, 5, 2, 4, 9, 1};
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(array, 9);
        System.out.println(ints[0] + " "+ints[1]);
    }

}
