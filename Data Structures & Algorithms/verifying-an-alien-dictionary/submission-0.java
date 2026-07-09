class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // look for first diferring char
        // if word A is prefix of word B, word B must be AFter word A
        int[] orderInd = new int[26];

        for(int i = 0; i < order.length(); i++) {
            orderInd[order.charAt(i)-'a'] = i;
        }
        for(int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            for(int j = 0; j < w1.length(); j++) {
                if(j == w2.length()) {
                    return false;
                }
                if(w1.charAt(j) != w2.charAt(j)) {
                    if(orderInd[w2.charAt(j)-'a'] < orderInd[w1.charAt(j)-'a']) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }
}