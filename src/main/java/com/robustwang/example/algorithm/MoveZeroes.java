package com.robustwang.example.algorithm;

public class MoveZeroes {

    public int[] move(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return nums;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int temp[] = {0, 1, 0, 3, 12, 14, 0, 9, 2, 3, 4, 6, 7, 0, 9, 0};
        int temp1[] = mz.move(temp);
        for (int i = 0; i < temp1.length; i++) {
            System.out.println(temp1[i]);
        }

    }

}
