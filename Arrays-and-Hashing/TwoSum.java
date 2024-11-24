class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int requiredNum = target - nums[i];
            if(map.containsKey(requiredNum)){
                return new int[] {map.get(requiredNum), i};
            }
            else map.put(nums[i], i);
        }

        return null;
    }
}