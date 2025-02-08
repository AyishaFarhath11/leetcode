class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
         if(target>x+y){
            return false;
        }
        int gcd=0;
        if(x>y)
            gcd = gcd(x,y);
        else{
            gcd = gcd(y,x);
        }
        if(gcd==0){
            return false;
        }
        return target%gcd==0;
    }
      private int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}