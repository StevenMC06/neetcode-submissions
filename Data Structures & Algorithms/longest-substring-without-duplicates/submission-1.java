class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        HashMap<Character, Integer> seen = new HashMap<>();

        int left = 0;
        for(int right = 0; right < n; right++) {
            char curr = s.charAt(right);
            if(seen.containsKey(curr) && seen.get(curr) >= left) {
                left = seen.get(curr) + 1; 
            }
            seen.put(curr,right);
            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
