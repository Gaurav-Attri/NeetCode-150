/**
 * BRUTE FORCE
 * TC - O(n + mlogm)
 * SC - O(m + k)
 * where, n - input array size, m - total unique elements in the input array. m could be equal to n.
 */
class Pair{
    int key;
    int value;

    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }


}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Pair> pairs = new ArrayList<>();
        int[] answer = new int[k];

        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);

        for(int key : map.keySet()) pairs.add(new Pair(key, map.get(key)));

        Collections.sort(pairs, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p2.value - p1.value;
            }
        });

        for(int i = 0; i < k; i++) answer[i] = pairs.get(i).key;

        return answer;
    }
}

/**
 * BETTER
 * TC - O(n)
 * SC - O(n)
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<List<Integer>> freqArray = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[k];

        // Counting the frequencies
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);

        // Initializing ArrayLists inside the freqArry array
        for(int i = 0; i < n+1; i++) freqArray.add(new ArrayList<>());

        // Traversing through the map and grouping elements with the same frequency together
        for(int key : map.keySet()) freqArray.get(map.get(key)).add(key);

        // Populating the answer array
        int index = 0;
        for(int i = freqArray.size()-1; i >= 0; i--){
            if(k == 0) break;
            List<Integer> list = freqArray.get(i);
            for(int j = 0; j < list.size(); j++){
                if(k == 0) break;
                answer[index] = list.get(j);
                index++;
                k--;
            }
        }

        return answer;

    }
}