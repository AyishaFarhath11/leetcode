class Solution {
double RAD, XC, YC;
    public Solution(double radius, double x_center, double y_center) {
        RAD = radius;
        XC = x_center;
        YC = y_center;
    }
    
    public double[] randPoint() {
         double ang = Math.random() * 2 * Math.PI,
            hyp = Math.sqrt(Math.random()) * RAD,
            adj = Math.cos(ang) * hyp,
            opp = Math.sin(ang) * hyp;
        return new double[]{XC + adj, YC + opp};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */