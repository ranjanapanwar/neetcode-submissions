class TimeMap {

    Map<String, List<Pair<Integer, String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(timeMap.get(key) != null){
            timeMap.get(key).add(new Pair<>(timestamp, value));
        }else{
            List<Pair<Integer, String>> list = new ArrayList<>();
            list.add(new Pair<>(timestamp, value));
            timeMap.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if(timeMap.containsKey(key)){
            List<Pair<Integer, String>> sortedList = timeMap.get(key);
            int l = 0;
            int r = sortedList.size() - 1;

            while(l <= r){
                int mid = (l + r)/2;
                if(sortedList.get(mid).getKey() <= timestamp){
                    result = sortedList.get(mid).getValue();
                    l = mid + 1;
                }else{
                r = mid - 1;
                }
            }
        }
        return result;
    }

    private static class Pair<K,V>{
        private K key;
        private V value;

        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public V getValue(){
            return value;
        }

        public K getKey(){
            return key;
        }

        public void setKey(K key){
            this.key = key;
        }

        public void setValue(V value){
            this.value = value;
        }
    }
}