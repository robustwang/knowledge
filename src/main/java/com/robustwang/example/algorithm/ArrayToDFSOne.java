package com.robustwang.example.algorithm;

public class ArrayToDFSOne {
    int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }

        int p = (left + right) / 2;

        TreeNode root = new TreeNode(nums[p]);

        root.left = helper(left, p - 1);

        root.right = helper(p + 1, right);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 12, 16};
        ArrayToDFSOne at = new ArrayToDFSOne();
        TreeNode treeNode = at.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

}
