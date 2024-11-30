/**
 * BRUTE FORCE
 * TC - O(n logn) 
 * SC - O(1)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int max = 1;
        int count = 1;
        Arrays.sort(nums);

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i]-nums[i-1] == 1) count++;
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }

        max = Math.max(max, count);
        return max;
    }
}

/**
 * Better
 * TC - O(n)
 * SC - O(n)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

        for(int i = 0; i < n; i++) map.put(nums[i], 1);

        for(int i : map.keySet()){
            if(!map.containsKey(i)) continue;
            int nextEle = i+1;
            int totalLength = map.get(i);
            while(map.containsKey(nextEle)){
                totalLength += map.remove(nextEle);
                nextEle++;
            }
            map.put(i, totalLength);
        }

        int max = 1;

        for(int i : map.keySet()){
            if(map.get(i) > max) max = map.get(i);
        }

        return max;

    }
}

/**
 * OPTIMAL (Neetcode's solution)
 * TC - O(n)
 * SC - O(n)
 * Optimal because the code is concise and clean
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length; 
        if(n == 0) return 0;

        int maxSequenceLength = 1;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) set.add(nums[i]);

        for(int i = 0; i < n; i++){
            if(!set.contains(nums[i]-1)){
                int sequenceCount = 1;
                int nextElementInSeq = nums[i]+1;
                while(set.contains(nextElementInSeq)){
                    sequenceCount++;
                    nextElementInSeq++;
                }
                maxSequenceLength = Math.max(maxSequenceLength, sequenceCount);
            }
        }

        return maxSequenceLength;
    }
}