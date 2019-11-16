class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return dfs(nums, visited, 0, 0, sum/2);
    }
    
    private boolean dfs(int[] nums, boolean[] visited, int start, int sum, int target) {
        if (start >= nums.length || sum > target) return false;
        if (sum == target) return true;
        
        for (int i = start; i < nums.length; i++) {
            /*
                trim很重要
            */
            if (i >= 1 && nums[i] == nums[i - 1] && visited[i - 1] == false) continue;
            visited[i] = true;
            if (dfs(nums, visited, i + 1, sum + nums[i], target)) return true;
            visited[i] = false;
        }
        
        return false;
    }
}