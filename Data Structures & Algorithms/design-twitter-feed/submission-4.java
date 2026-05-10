class Twitter {
	// define instance variables
	private int time;
	private Map<Integer, Set<Integer>> followMap;
	private Map<Integer, List<Tweet>> tweetMap;

	// define dub-class Tweet
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

	// init instance variables
    public Twitter() {
        time = 0;
		followMap = new HashMap<>();
		tweetMap = new HashMap<>();
    }
    
	// simulate posting Tweets
    public void postTweet(int userId, int tweetId) {
        // add Tweet to map if not already posted
		tweetMap.putIfAbsent(userId, new ArrayList<>());

		// make list of Tweets for current user
		List<Tweet> tweets = tweetMap.get(userId);

		// add Tweets with metadata
		tweets.add(new Tweet(time++, tweetId, userId, tweets.size()));
    }
    
	// maintain news feed
    public List<Integer> getNewsFeed(int userId) {
        // create list to hold resulting news feed
		List<Integer> result = new ArrayList<>();

		// create max heap to hold most recent posts
		PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
			(a,b) -> b.time - a.time
		);

		// create a set to hold users user follows
		Set<Integer> users = new HashSet<>();

		// add current user to list
		users.add(userId);

		// collect all users user follows
		if(followMap.containsKey(userId)) {
			users.addAll(followMap.get(userId));
		}

		// add each user's most recent tweets
		for(int user : users) {
			// get all Tweets from user
			List<Tweet> tweets = tweetMap.get(user);

			// if user does not have any tweets -> skip this user
			if(tweets == null || tweets.isEmpty()) continue;

			// get index of most recent Tweet
			int lastIndex = tweets.size() - 1;

			// add most recent Tweet to max heap
			maxHeap.offer(tweets.get(lastIndex));
		}

		// filter heap by 10 most recent Tweets
		while(!maxHeap.isEmpty() && result.size() < 10) {
			// get current Tweet
			Tweet current = maxHeap.poll();

			// add current Tweet to resulting list
			result.add(current.tweetId);

			// try to get older post index
			int prevIndex = current.index - 1;

			// if older post exists -> add those to heap
			if(prevIndex >= 0) {
				// get all old Tweets from user
				List<Tweet> tweets = tweetMap.get(current.userId);

				// add previous posts to heap
				maxHeap.offer(tweets.get(prevIndex));
			}
		}

		// return resulting list
		return result;
    }
    
	// simulate following users
    public void follow(int followerId, int followeeId) {
        // add person being followed to follower map
		followMap.putIfAbsent(followerId, new HashSet<>());

		// add person being followed to list of people they follow
		followMap.get(followerId).add(followeeId);
    }
    
	// simulate unfollowing user
    public void unfollow(int followerId, int followeeId) {
        // remove person from being followed only if follower exists
		if(followMap.containsKey(followerId)) {
			followMap.get(followerId).remove(followeeId);
		}
    }
}
