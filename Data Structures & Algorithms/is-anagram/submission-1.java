class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;   
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(!map1.containsKey(c)){
                map1.put(c,1);
            } else {
                map1.put(c, map1.get(c)+1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);

            if(!map2.containsKey(c)) {
                map2.put(c,1);

            } else {
                map2.put(c,map2.get(c)+1);
            }
        }

        return map1.equals(map2);


    }
}
