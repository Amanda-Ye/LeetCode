import java.util.ArrayList;
import java.util.List;

/*
* 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。
*/
public class Test2 {
    /*方法1：因为有序，可将两个数组中的元素有序连接，然后取中间值*/
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();         //执行用时：5ms   内存消耗：46.4MB
        int i = 0,j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                list.add(nums1[i++]);
            }else{
                list.add(nums2[j++]);
            }
        }
        if(i == nums1.length){
            while(j < nums2.length){
                list.add(nums2[j++]);
            }
        }
        if(j == nums2.length){
            while(i < nums1.length){
                list.add(nums1[i++]);
            }
        }
        if((nums1.length + nums2.length) % 2 == 1){
            return list.get(list.size() / 2) * 1.0;
        }
        int temp = list.get(list.size() / 2) + list.get(list.size() / 2 - 1);
        return temp / 2.0;
    }

    public static void main(String[] args) {
        double median = findMedianSortedArrays1(new int[]{1,2},new int[]{3,4});
        System.out.println(median);
    }
}
