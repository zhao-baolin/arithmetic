package leetcode;

/**
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class searchInsertPosition_35 {

    /**
     * 暴力循环
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return len;
    }


    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        //int[] in = {1,3,5,6};
        //int target = 5;

        int[] in = {1,3,5,6};
        int target = 0;

        int result = searchInsert2(in,target);
        System.out.println(result);
    }
}
