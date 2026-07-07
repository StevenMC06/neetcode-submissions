class Twitter {

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        
        if(!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{time,tweetId});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );        
        // seed heap
        for (int followeeId : followMap.get(userId)) {
            if (!tweetMap.containsKey(followeeId)) {
                continue;
            }
            List<int[]> tweets = tweetMap.get(followeeId);
            int index = tweets.size()-1;

            int[] tweet = tweets.get(index);

            maxHeap.add(new int[]{tweet[0], tweet[1], followeeId, index});
        }
        //pop heap here
        while (!maxHeap.isEmpty() && feed.size() < 10) {
        int[] curr = maxHeap.poll();

        int tweetId = curr[1];
        int followeeId = curr[2];
        int index = curr[3];

        feed.add(tweetId);

        if (index > 0) {
            int nextIndex = index - 1;
            int[] nextTweet = tweetMap.get(followeeId).get(nextIndex);

            maxHeap.add(new int[]{
                nextTweet[0],
                nextTweet[1],
                followeeId,
                nextIndex
            });
        }
    }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
