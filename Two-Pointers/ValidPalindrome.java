/**
 * BRUTE FORCE
 * TC -> O(n)
 * SC -> O(n)
 */
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(Character.isLetterOrDigit(currChar)){
                if(currChar >= 'A' && currChar <= 'Z') currChar = (char)(currChar+32);
                sb.append(currChar);
            }
        }

        int start = 0;
        int end = sb.length()-1;

        while(start <= end){
            if(sb.charAt(start) != sb.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}

/**
 * OPTIMAL Solution
 * TC -> O(n)
 * SC -> O(1)
 */
class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;

        while(left < right){
            while(left < right && !isAlphaNum(s.charAt(left))) left++;
            while(right > left && !isAlphaNum(s.charAt(right))) right--;

            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if(leftChar >= 'A' && leftChar <= 'Z') leftChar = (char)(leftChar + 32);
            if(rightChar >= 'A' && rightChar <= 'Z') rightChar = (char)(rightChar + 32);

            if(leftChar != rightChar) return false;

            left++;
            right--;
        }

        return true;
    }

    public boolean isAlphaNum(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}