class Solution {
    public int minCut(String s) {
        int n=s.length();
        int [] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return f(0,n,s,dp)-1;
    }
   
    public static int f(int i, int n, String s,int[] dp){

        if(i==n) return 0;
        int mincost=Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        for(int j=i;j<n;j++){
            if(isPal(i,j,s))
            {
                int cost=1+f(j+1,n,s,dp);
                mincost=Math.min(cost,mincost);
            }
        }
        return dp[i]=mincost;
    }
    public static boolean isPal(int i,int j, String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}