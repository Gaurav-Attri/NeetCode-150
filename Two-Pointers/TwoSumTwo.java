/**
 * BRUTE FORCE
 * TC - O(n^2)
 * SC - O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(numbers[i]+numbers[j] == target) return new int[]{i+1, j+1};
            }
        }

        return null;
    }
}

/**
 * BETTER 
 * TC - O(n)
 * SC - O(n)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int requiredNum = target-numbers[i];
            if(map.containsKey(requiredNum)) return new int[] {map.get(requiredNum)+1, i+1};
            else map.put(numbers[i], i);
        }

        return null;
    }
}

/**
 * OPTIMAL
 * TC - O(n)
 * SC - O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;

        while(left < right){
            if(numbers[left]+numbers[right] == target) return new int[] {left+1, right+1};
            
            if(numbers[left]+numbers[right] > target) right--;
            else left++;
        }

        return null;
    }
}