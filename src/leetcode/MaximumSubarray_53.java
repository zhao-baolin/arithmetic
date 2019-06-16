package leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaximumSubarray_53 {


    /**
     * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
     * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
     * 时间复杂度：O(n)
     */
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if(0 == len){
            return 0;
        }
        int ans = nums[0];
        int sum = 0;
        for(int i=0;i<len;i++){
            if(sum > 0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            ans = Math.max(sum,ans);
        }
        return ans;
    }
    public static void main(String[] args) {

        //int[] in = {1,3,5,6};
        //int target = 5;

        //int[] in = {1,3,5,6};
        //int[] in = {-2,1,-3,4,-1,2,1,-5,4};
        int[] in = {};
        //int[] in = {-12,-9,-2,-4,-10};
        int target = 0;

        int result = maxSubArray(in);
        System.out.println(result);
    }
}
