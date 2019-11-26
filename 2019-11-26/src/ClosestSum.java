import java.util.Arrays;

/*16.最接近的三数之和：
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
找出 nums 中的三个整数，使得它们的和与 target 最接近。
返回这三个数的和。假定每组输入只存在唯一答案。
*/
public class ClosestSum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0;i < len;i++){
            int j = i + 1;
            int l = len - 1;
            while(j < l){
                int sum = nums[i] + nums[j] + nums[l];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    l--;
                else if(sum < target)
                    j++;
                else
                    return ans;
            }
        }
        return ans;
    }
}
