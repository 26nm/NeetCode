class Twitter {
	// define instance variables
	private int time;
	private Map<Integer, Set<Integer>> followMap;
	private Map<Integer, List<Tweet>> tweetMap;

	// define sub-class Tweet
	private static class Tweet {
		// define Tweet instance variables
		int time;
		int tweetId;
		int userId;
		int index;

		// init Tweet variables
		Tweet(int time, int tweetId, int userId, int index) {
			this.time = time;
			this.tweetId = tweetId;
			this.userId = userId;
			this.index = index;
		}
	}

	// init variables
    public Twitter() {
        time = 0;
		followMap = new HashMap<>();
		tweetMap = new HashMap<>();
    }
    
	// simulate posting Tweet
    public void postTweet(int userId, int tweetId) {
        // add Tweet to map if not already posted
		tweetMap.putIfAbsent(userId, new ArrayList<>());

		// make list of Tweets for current user
		List<Tweet> tweets = tweetMap.get(userId);

		// add tweets to list with metadata
		tweets.add(new Tweet(time++, tweetId, userId, tweets.size()));
    }
    
	// maintain news feed
    public List<Integer> getNewsFeed(int userId) {
        // create list to hold resulting feed
		List<Integer> result = new ArrayList<>();

		// create max heap to hold most recent posts
		PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
			(a,b) -> b.time - a.time
		);

		// create set to hold users being followed
		Set<Integer> users = new HashSet<>();

		// add users to list
		users.add(userId);

		// collect user and users they follow
		if(followMap.containsKey(userId)) {
			users.addAll(followMap.get(userId));
		}

		// add each user being followed's most recent tweets to max heap
		for(int user : users) {
			// get all Tweets from current user
			List<Tweet> tweets = tweetMap.get(user);

			// if user does not have any tweets -> skip over them
			if(tweets == null || tweets.isEmpty()) continue;

			// get index of most recent tweet
			int lastIndex = tweets.size() - 1;

			// add most recent tweet to max heap
			maxHeap.offer(tweets.get(lastIndex));
		}

		// filter most recent tweets by top 10
		while(!maxHeap.isEmpty() && result.size() < 10) {
			// get current Tweet
			Tweet current = maxHeap.poll();

			// add current Tweet to result
			result.add(current.tweetId);

			// (try to) get older post index
			int prevIndex = current.index - 1;

			// if older post exists -> add those to heap
			if(prevIndex >= 0) {
				// get all old Tweets from user
				List<Tweet> tweets = tweetMap.get(current.userId);

				// add previous posts tp heap
				maxHeap.offer(tweets.get(prevIndex));
			}
		}

		// return resulting news feed
		return result;
    }
    
	// simulate following users
    public void follow(int followerId, int followeeId) {
        // add person being followed to follower map
		followMap.putIfAbsent(followerId, new HashSet<>());

		// add person being followed to list of following
		followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // unfollow person if account exists
		if(followMap.containsKey(followerId)) {
			followMap.get(followerId).remove(followeeId);
		}
    }
}
