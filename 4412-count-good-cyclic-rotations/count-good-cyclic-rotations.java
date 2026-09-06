class Solution {
    public int countGoodRotations(int[] nums) {
        long sum = 0; 
        for(int x: nums) sum += x; 
        long pre = 0, cnt = 0; 
        for(int i = 0; i < nums.length; i++) {
            if(i >= nums.length / 2) {
                if(pre != sum - pre) cnt++;
                pre -= nums[i - nums.length / 2]; 
            }
            pre += nums[i]; 
        }
        return (int)cnt; 
    }
}