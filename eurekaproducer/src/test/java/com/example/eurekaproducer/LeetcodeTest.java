package com.example.eurekaproducer;

public class LeetcodeTest {

    /**
     *  给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *  请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *  假设 nums1 和 nums2 不会同时为空。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;

        int totalLegth = (nums1.length + nums2.length + 1)/2;
        // 判断两个数组之和是奇数还是偶数
        boolean b = (nums1.length + nums2.length)%2==0 ? true:false;

        int flag = 0;
        int count = 1;

        int midelNum = 0;

        for(int i=0; i<nums1.length; i++){
            if(flag < nums2.length){
                if(nums2[flag] < nums1[i]){
                    flag ++;
                    i --;
                    midelNum = nums1[i];
                }else{
                    count ++;
                    midelNum = nums2[flag];
                }
            }else{
                count ++;
            }

            // 判断有没有到中间位
            if(count+flag == totalLegth){
                if(b){
                   if(nums2[(flag+1)] > nums1[i+1]){
                       result = (midelNum+nums1[i])/2;
                    }else{
                       result = (midelNum+nums2[flag+1])/2;
                    }
                }else{
                    result = midelNum;
                }
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetcodeTest test = new LeetcodeTest();
        int[] nums1 = {1,6,9,10};
        int[] nums2 = {2,5,8,9};
        System.err.println(test.findMedianSortedArrays(nums1,nums2));
    }
}
