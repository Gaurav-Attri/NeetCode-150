/**
 * First Approach
 * TC - O(n)
 * SC - O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[][] prefixSuffixProducts = new int[n][2];

        // Calculating the prefix multiplication
        int prod = 1;
        for(int i = 0; i < n; i++){
            prod *= nums[i];
            prefixSuffixProducts[i][0] = prod;
        }

        // Calculating the suffix multiplication
        prod = 1;
        for(int i = n-1; i >= 0; i--){
            prod *= nums[i];
            prefixSuffixProducts[i][1] = prod;
        }

        for(int i = 0; i < n; i++){
            if(i == 0) ans[i] = prefixSuffixProducts[i+1][1];
            else if(i == n-1) ans[i] = prefixSuffixProducts[i-1][0];
            else ans[i] = prefixSuffixProducts[i-1][0]*prefixSuffixProducts[i+1][1];
        }

        return ans;
    }
}

/**
 * OPTIMAL APPROACH
 * TC - O(n)
 * SC - O(1)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // First calculating the running prefix product and putting it in the ans array
        int prod = 1;
        for(int i = 0; i < n; i++){
            ans[i] = prod;
            prod = prod*nums[i];
        }

        // Calculating the running suffix product and putting it in the ans array
        prod = 1;
        for(int i = n-1; i >= 0; i--){
            ans[i] = ans[i]*prod;
            prod = prod*nums[i];
        }

        return ans;
    }
}