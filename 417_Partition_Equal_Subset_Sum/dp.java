class Solution {
    public boolean canPartition(int[] nums) {
        int max = 0;
        int n = nums.length;
        
        for (int num : nums) {
            max += num;
        }
        
        if (max % 2 != 0) return false;
        /*
            dp[i][diff]: 0-i个num，组成2组的diff是否存在
        */      
        boolean[][] dp = new boolean[n][max + 1];
        dp[0][nums[0]] = true;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= max; j++) {
                if (dp[i - 1][j] == false) continue;
                dp[i][Math.abs(j - nums[i])] = true;
                dp[i][j + nums[i]] = true;
            }
        }
        /*
            n - 1个num，两组的diff是0
        */
        return dp[n - 1][0];
    }
}