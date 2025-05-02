class Solution {
    public int twoEggDrop(int n) {
 int floors = n;
        int eggs = 2;
        int[][] memo = new int[eggs+1][floors+1];
        for(int[] arr: memo) Arrays.fill(arr,-1);
        return f(eggs,floors,memo);
    }
     public int f(int eggs,int floors, int [][]memo) {
     if(floors == 0 || floors == 1) return floors;
        if(eggs == 1) return floors; 

        int ans = Integer.MAX_VALUE;
        if(memo[eggs][floors] != -1) return memo[eggs][floors];

        for(int i = 1;i<=floors;i++) {
            int min = Math.max(f(eggs-1,i-1,memo),f(eggs,floors-i,memo));
            if(min < ans) ans = min;
        }

        return memo[eggs][floors] = ans+1;
     }
}