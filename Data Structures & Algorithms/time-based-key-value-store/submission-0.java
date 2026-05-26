class TimeMap {
    private HashMap<String, List<Pair>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)) {
            store.put(key, new ArrayList<>());
        }

        store.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)) {
            return "";
        }
        List<Pair> values = store.get(key);
        String res = "";

        // bst
        int l = 0;
        int r = values.size() - 1;

        while(l <= r) {
            int mid = (l + r) /2;

            if(values.get(mid).timestamp <= timestamp){
                res = values.get(mid).value;
                l = mid + 1;
            } else {
                r = mid - 1;

            }
        }
        return res;
    }

    private class Pair{
        int timestamp;
        String value;

        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
