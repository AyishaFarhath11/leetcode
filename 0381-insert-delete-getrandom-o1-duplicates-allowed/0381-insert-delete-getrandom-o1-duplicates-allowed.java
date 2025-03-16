class RandomizedCollection {
HashMap<Integer,Integer> map ;
     List<Integer> nums;
     Random rand = new Random();
    public RandomizedCollection() {
         map = new HashMap<>();
         nums = new ArrayList<>();
    }
    
    public boolean insert(int val) {
         boolean result = !map.containsKey(val);

        map.put(val,map.getOrDefault(val,0)+1);
        nums.add(val);
        return result;
    }
    
    public boolean remove(int val) {
         if(!map.containsKey(val)) return false;
        map.put(val, map.get(val) - 1);
        nums.remove((Integer) val);
        if (map.get(val) == 0) map.remove(val);
        return true;
    }
    
    public int getRandom() {
         return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */