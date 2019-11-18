import java.util.*;

/*15.三数之和：
* 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
* 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
*注意：答案中不可以包含重复的三元组。
*/
public class SumOfThreeNums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) return list;
        Arrays.sort(nums);  //对数组排序
        for(int i = 0;i < len;i++){
            if(nums[i] > 0){  //如果当前数字大于0.则三数之和一定大于0.故结束循环
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) continue;   // 去重
            int l = i + 1;
            int r = len - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) l++;  //去重
                    while(l < r && nums[r] == nums[r - 1]) r--;  //去重
                    l++;
                    r--;
                }else if(sum < 0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return list;
    }
}
