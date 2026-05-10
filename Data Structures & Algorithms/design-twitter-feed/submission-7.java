/**
* implement a simplifed version Twitter allowing users to post tweets,
* follow/unfollow each other, and view 10 most recent Tweets within
* their own feed
*
* we need a sub-class Twitter to represent posts and their metadata
*
* for postTweet:
* 1. update tweetMap
*
* 2. make list to store all posts tied to user
*
* 3. add to this list with post metadata
*
* for follow/unfollow:
* 1. update follow map accordingly
*
* for getNewsFeed:
* 1. create a list to store most recent post by id
*
* 2. create a heap to process most recent posts
*
* 3. create a set to hold current user and users they follow
*	 -add user and all users they follow
*
* 4. get most recent posts for user and users they follow, move onto
*	 heap
*
* 5. filter heap by top 10 most recent posts
*
* 6. return resulting list
* 
*/
class Twitter {
	// define variables
	int time;
	Map<Integer, Set<Integer>> followMap;
	Map<Integer, List<Tweet>> tweetMap;

	// define sub-class Tweet
	private static class Tweet {
		// define variables
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
    
	// simulate posting a Tweet
    public void postTweet(int userId, int tweetId) {
        // put in Tweet map if not already posted
		tweetMap.putIfAbsent(userId, new ArrayList<>());

		// make list to hold all users posts
		List<Tweet> tweets = tweetMap.get(userId);

		// add post with metadata
		tweets.add(new Tweet(time++, tweetId, userId, tweets.size()));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // create list to store most recent posts by id
		List<Integer> result = new ArrayList<>();

		// create max heap to process most recent posts
		PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
			(a,b) -> b.time - a.time
		);

		// create set to store user and all they follow
		Set<Integer> users = new HashSet<>();

		// add current user to set
		users.add(userId);

		// add all users they follow to list
		if(followMap.containsKey(userId)) {
			users.addAll(followMap.get(userId));
		}

		// extract most recent posts from each user to heap
		for(int user : users) {
			// get all posts for current user
			List<Tweet> tweets = tweetMap.get(user);

			// if they do not have any posts -> skip them
			if(tweets == null || tweets.isEmpty()) continue;

			// get index of most recent posts
			int lastIndex = tweets.size() - 1;

			// add to heap
			maxHeap.offer(tweets.get(lastIndex));
		}

		// filter heap by 10 most recent
		while(!maxHeap.isEmpty() && result.size() < 10) {
			// get current post
			Tweet current = maxHeap.poll();

			// add current post id to result
			result.add(current.tweetId);

			// try to get older post
			int prevIndex = current.index - 1;

			// if older post exists -> add to heap
			if(prevIndex >= 0) {
				// get all users old posts
				List<Tweet> tweets = tweetMap.get(current.userId);

				// add most recent posts to heap
				maxHeap.offer(tweets.get(prevIndex));
			}
		}

		// return resulting list
		return result;
    }
    
    public void follow(int followerId, int followeeId) {
        // update follow map
		followMap.putIfAbsent(followerId, new HashSet<>());
		followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // update follow map
		if(followMap.containsKey(followerId)) {
			followMap.get(followerId).remove(followeeId);
		}
    }
}
