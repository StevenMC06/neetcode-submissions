class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();

        int l = 0;
        int res = 0;
        int maxf = 0;

        for(int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);

            count.put(curr,count.getOrDefault(curr,0) + 1);
            maxf = Math.max(maxf,count.get(curr));

            while((r-l+1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r-l + 1);
        }
        return res;
    }
}
