class Solution {
    public int bitwiseComplement(int n) {
         if(n==0){
            return 1;
        }
        int ans = 0;
        int i = 0;
        while(n>0){
            if((n&1) != 1){
                ans = (ans ^ (1<<i));
            }
            n >>= 1;
            i++;
        }
        return ans;
    }
}