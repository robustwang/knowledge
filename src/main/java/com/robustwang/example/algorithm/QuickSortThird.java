package com.robustwang.example.algorithm;

public class QuickSortThird {
    public void quickSort(int nums[], int top, int tail) {
        if (top >= tail)
            return;
        int mid = nums[tail];
        int left = top, right = tail - 1;
        while (left < right) {
            while (nums[left] < mid && left < right) {
                left++;
            }
            while (nums[right] >= mid && left < right) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        if (nums[left] >= nums[tail]) {
            int temp = nums[left];
            nums[left] = nums[tail];
            nums[tail] = temp;
        } else {
            left++;
        }
        quickSort(nums, top, left - 1);
        quickSort(nums, left + 1, tail);
    }




}
