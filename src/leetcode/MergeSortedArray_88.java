package leetcode;

import java.util.Arrays;

/**
 *合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class MergeSortedArray_88 {

    //插入排序
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=n-1;i>=0;i--){
            int value = nums2[i];
            int j = 0;
            for(j=m-1;j>=0;j--){
                if(nums1[j] > value){
                    nums1[j+1] = nums1[j];
                }else{
                    break;
                }
            }
            nums1[j+1] = value;
            m++;
        }
    }

    //同时比较两个数组nums1和nums2中最大的数，把最大的数放在m+n-1的位置，然后位置-1，最大数所在数组位置-1，继续比较，直到nums2遍历完成。
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[pos--] = nums1[--m];
            }else {
                nums1[pos--] = nums2[--n];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

        System.out.println(Arrays.toString(nums1));
        merge2(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
