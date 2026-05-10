/**
* implement a simplified version of Twitter allowing users to post tweets,
* follow/unfollow each other, and view 10 most recent tweets within
* their feed
*
* we'll need a sub-class Tweet to make Tweet objects and store metadata
*
* for postTweet:
* 1. update tweetMap accordingly
*
* 2. make list to get all their Tweets
*
* 3. add new Tweet with metadata to this list
*
* for follow/unfollow:
* 1. update follow map accordingly
*
* for getNewsFeed:
* 1. create a list to store ids for most recent posts
*
* 2. create a heap to process most recent posts
*
* 3. create a set to hold users a user follows
*
* 4. add current user to the set:
*	 -add all users they follow to the set
*
* 5. get most recent posts from each user
*
* 6. filter heap by 10 most recent posts
*
* 7. return resulting list
*/
class Twitter {
	// define instance variables
	private int time;
	private Map<Integer, Set<Integer>> followMap;
	private Map<Integer, List<Tweet>> tweetMap;

	// define sub-class Tweet
	private static class Tweet {
		// define instance variables
		int time;
		int tweetId;
		int userId;
		int index;

		// init variables
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

		// make list to hold all Tweets from user
		List<Tweet> tweets = tweetMap.get(userId);

		// add Tweet to list with metadata
		tweets.add(new Tweet(time++, tweetId, userId, tweets.size()));
    }
    
	// get 10 most recent Tweets
    public List<Integer> getNewsFeed(int userId) {
        // create list to store most recent Tweets by ID
		List<Integer> result = new ArrayList<>();

		// create heap to process most recent Tweets
		PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
			(a,b) -> b.time - a.time
		);

		// create set to store data for user and users they follow
		Set<Integer> users = new HashSet<>();

		// add current user to set
		users.add(userId);

		// add all users user follows to set
		if(followMap.containsKey(userId)) {
			users.addAll(followMap.get(userId));
		}

		// add each user's most recent posts to heap
		for(int user : users) {
			// get list of Tweets for current user
			List<Tweet> tweets = tweetMap.get(user);

			// if they have no posts -> skip them
			if(tweets == null || tweets.isEmpty()) continue;

			// get index of their most recent post
			int lastIndex = tweets.size() - 1;

			// add most recent to heap
			maxHeap.offer(tweets.get(lastIndex));
		}

		// filter heap by top 10 most recent
		while(!maxHeap.isEmpty() && result.size() < 10) {
			// get current Tweet ID
			Tweet current = maxHeap.poll();

			// add current to result
			result.add(current.tweetId);

			// try to get older posts
			int prevIndex = current.index - 1;

			// if it exists -> add those to heap
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
    
	// simulate following user
    public void follow(int followerId, int followeeId) {
        // add person being followed to follower set
		followMap.putIfAbsent(followerId, new HashSet<>());

		// add person being followed to list of following
		followMap.get(followerId).add(followeeId);
    }
    
	// simulate unfollowing user
    public void unfollow(int followerId, int followeeId) {
        // if user exists -> remove person being followed
		if(followMap.containsKey(followerId)) {
			followMap.get(followerId).remove(followeeId);
		}
    }
}
