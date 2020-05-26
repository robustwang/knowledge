package com.robustwang.example.leetcode;


/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Twoeightseven {

    public int findDuplicate(int[] nums) {

        if (nums.length <= 2) {
            return nums[0];
        }
        //初始化i，j不应该为0.应该是指向第一个index与nums[index]不相等的位置.
        int i = 0, j = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index != nums[index]) {
                i = index;
                j = index;
                break;
            }
        }
        while (true) {
            i = nums[i];
            j = nums[nums[j]];
            if (i == j) break;
        }
        i = 0;
        while (true) {
            i = nums[i];
            j = nums[j];
            if (i == j) break;
        }
        return i;
    }


    public static void main(String[] args) {
        Twoeightseven test = new Twoeightseven();
        int[] array = new int[]{2, 3, 3, 3, 4, 5};
        int duplicate = test.findDuplicate(array);
        System.out.println(duplicate);

    }
}