class Solution {

    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> trustSomeone = new HashSet<>();
    
        int res = -1;

        for(int i = 0; i < trust.length; i++) {
            if(!map.containsKey(trust[i][1])) {
                map.put(trust[i][1], new ArrayList<>());
            }
            map.get(trust[i][1]).add(trust[i][0]);
            trustSomeone.add(trust[i][0]);

            
        }

        for(int i = 0; i < trust.length; i++) {
            if(map.get(trust[i][1]).size()== n-1 && !trustSomeone.contains(trust[i][1])) {
                return trust[i][1];
            }
        }

        return res;
    }
}