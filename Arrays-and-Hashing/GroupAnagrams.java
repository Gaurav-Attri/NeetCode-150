/**
 * BRUTE FORCE
 * TC: O(n^2*(p+q))
 * SC: O(n) Not considering the 2d array required for answer
 * Where, n: length of the Strings array 'strs', p and q are lengths of the strings passed
 * in the isAnagram function.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        HashSet<Integer> indices = new HashSet<>();

        for(int i = 0; i < strs.length; i++){
            if(!indices.contains(i)){
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                indices.add(i);
                for(int j = i+1; j < strs.length; j++){
                    if(isAnagram(strs[i], strs[j])){
                        group.add(strs[j]);
                        indices.add(j);
                    }
                }
                answer.add(group);
            }
        }

        return answer;
    }

    public boolean isAnagram(String first, String second){
        int n = first.length();
        int m = second.length();

        if(n != m) return false;

        int[] freqFirst = new int[26];
        int[] freqSecond = new int[26];

        for(int i = 0; i < n; i++) freqFirst[first.charAt(i)-'a']++;
        for(int i = 0; i < m; i++) freqSecond[second.charAt(i)-'a']++;

        for(int i = 0; i < 26; i++){
            if(freqFirst[i] != freqSecond[i]) return false;
        }

        return true;
    }
}

/**
 * OPTIMAL SOLUTION
 * TC: O(n*m)
 * SC: O(n)
 * 
 * Where, n - length of the input array
 *        m - maximum length of any string in the given array.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            String pattern = freqPattern(str);
            if(!map.containsKey(pattern)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(pattern, list); 
            }
            else{
                map.get(pattern).add(str);
            }    
        }

        for(String str : map.keySet()){
            answer.add(map.get(str));
        }

        return answer;

    }

    public String freqPattern(String str){
        int[] freq = new int[26];
        String freqPatternString = "";

        for(int i = 0; i < str.length(); i++) freq[str.charAt(i)-'a']++;
        
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0) freqPatternString += freq[i]+""+(char)('a'+i);
        }

        return freqPatternString;
    }
}