class Solution {
    public int countPrimeSetBits(int left, int right) {
          int ans=0;
        int c=0;
        boolean res=false;

        for(int i=left;i<=right;i++){
            ans=hammingWeight(i);
            
            res=isPrime(ans);

            if(res==true){
                c++;
            }
        }
        return c;
    }
       public int hammingWeight(int n) {
        int c=0;
        while(n>0){
            if((n & 1)==1){
                c++;
            }
            n=n>>1;
            
        }
        return c;
    }

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;
 
        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
 
        return true;
    }
}