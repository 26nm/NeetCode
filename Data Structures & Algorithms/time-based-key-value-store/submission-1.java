/**
    * a data structure design problem
    *
    * design a time-based key-value data structure that supports:
    * -storing multiple values for same key at specified timestamps
    * -retrieving key's value at timestamp
    *
    * set stores key key with value value at given timestamp
    *
    * get returns most recent value of key if set was previously
    * called on it and most recent timestamp for that key
    *
    * to solve this, we can maintain a HashMap to store values
    * 
    * we can use binary search to retrieve values
    *
    * but first we define an inner class Pair 
    */
class TimeMap {
    // define class Pair
    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    // define instance variables
    private Map<String, List<Pair>> times;

    // init variables
    public TimeMap() {
        times = new HashMap<>();
    }
    
    // store key and associated timestamp
    public void set(String key, String value, int timestamp) {
        times.putIfAbsent(key, new ArrayList<>());
        times.get(key).add(new Pair(value, timestamp));
    }
    
    // return most recent value of key and most recent timestamp
    public String get(String key, int timestamp) {
        // if key does not exist -> return empty
        if(!times.containsKey(key)) return "";

        // retrieve list holding values for key
        List<Pair> list = times.get(key);

        // init variables
        int left = 0;
        int right = list.size() - 1;
        String result = "";

        // iterate until left and right intersect
        while(left <= right) {
            // calc current mid and retrieve pair at mid
            int mid = left + (right - left) / 2;
            Pair pair = list.get(mid);

            // get most recent value and timestamp
            if(pair.timestamp <= timestamp) {
                result = pair.value;
                left = mid + 1;

            // get smaller timestamp
            } else {
                right = mid - 1;
            }
        }

        // return most recent value
        return result;
    }
}
