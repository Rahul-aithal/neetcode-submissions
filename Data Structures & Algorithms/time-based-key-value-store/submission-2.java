class TimeMap {
    HashMap<String, List<String>> keyValue;
    HashMap<String, List<Integer>> timeStamp;
    public TimeMap() {
        keyValue = new HashMap<>();
        timeStamp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (keyValue.containsKey(key)) {
            keyValue.get(key).add(value);
            timeStamp.get(key).add(timestamp);

        } else {
            List<String> list;
            List<Integer> stamp;
            list = new ArrayList<String>();
            list.add(value);
            stamp = new ArrayList<Integer>();
            keyValue.put(key, list);

            stamp.add(timestamp);
            timeStamp.put(key, stamp);
        }
    }

    public String get(String key, int timestamp) {
        if(!timeStamp.containsKey(key)) return "";
        List<Integer> stamp = timeStamp.get(key);
        List<String> list = keyValue.get(key);
        String recentVal = "";
        int low = 0, high = stamp.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (stamp.get(mid) == timestamp) {
            
                    return list.get(mid);
                
            }
            if (stamp.get(mid) < timestamp) {
                
                    recentVal = list.get(mid);


                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return recentVal;
    }
}
