class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ini=image[sr][sc];
        int ans[][]=image;
        int dr[]={-1,0,+1,0};
        int dc[]={0,+1,0,-1};
        dfs(sr,sc,ans,image,color,dr,dc,ini);
        return ans;
    }
    private void dfs(int row,int col, int[][]ans, int[][]image,int color, int[]dr,int[]dc,int ini){
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            if(nrow>=0 && nrow<n && ncol>=0 &&ncol<m && image[nrow][ncol]==ini && ans[nrow][ncol]!=color)
            {
                dfs(nrow,ncol,ans,image,color,dr,dc,ini);
            }
        }
    }
}