/**
* another data structure implementation
*
* we are asked to implement a time-based key-value data structure
* supporting:
* -storing multiple values for same key at specified time stamps
* -retrieving key's value at specified timestamp
*
* we can start by defining instance variables:
* -String key
* -String value
* -int timestamp
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
    
    // store values and associated timestamps in map
    public void set(String key, String value, int timestamp) {
        times.putIfAbsent(key, new ArrayList<>());
        times.get(key).add(new Pair(value, timestamp));
    }
    
    // retrieve value associated with key and timestamp not exceeding query
    public String get(String key, int timestamp) {
        // if key absent, return empty
        if(!times.containsKey(key)) return "";

        // hold list associated with key
        List<Pair> list = times.get(key);

        // init variables
        int left = 0;
        int right = list.size() - 1;
        String result = "";

        // iterate until left and right intersect
        while(left <= right) {
            // calc current mid and retrieve associated pair
            int mid = left + (right - left) / 2;
            Pair pair = list.get(mid);

            // get most recent key value and timestamp NOT EXCEEDING query
            if(pair.timestamp <= timestamp) {
                result = pair.value;
                left = mid + 1;

            // find smaller timestamp
            } else {
                right = mid - 1;
            }
        }

        // return most recent key value
        return result;
    }
}
