// TC - O(nlogn+mlogm)
// SC - O(n+m) assuming sorting won't take any extra space
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        s = new String(s1);
        t = new String(t1);

        return s.equals(t);
    }
}

// TC - O(n+m)
// SC -O(n+m)
class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            char currChar = s.charAt(i);
            sMap.put(currChar, sMap.getOrDefault(currChar, 0)+1);
        }

        for(int i = 0; i < m; i++){
            char currChar = t.charAt(i);
            tMap.put(currChar, tMap.getOrDefault(currChar, 0)+1);
        }

        if(sMap.size() != tMap.size()) return false;

        for(char c : sMap.keySet()){
            if(tMap.get(c) == null) return false;
            // if(sMap.get(c) != tMap.get(c)) return false;
            if(!sMap.get(c).equals(tMap.get(c))) return false;
        }

        return true;
    }
}