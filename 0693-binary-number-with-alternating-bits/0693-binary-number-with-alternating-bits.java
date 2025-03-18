class Solution {
    public boolean hasAlternatingBits(int n) {
        int x=n^(n>>1);// XOR n with n shifted right
        return (x & (x + 1)) == 0;// Check if all bits are 1s
    }
}