class Solution {
   class Info implements Comparable<Info> {

        int val;
        int row;
        int col;

        public Info(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Info i){
            return this.val - i.val;
        }
    }

    public int swimInWater(int[][] grid) {

        PriorityQueue<Info> pq = new PriorityQueue<>();
        int minTime = grid[0][0];

        int m = grid.length;
        int n = grid[0].length;

        boolean isVis[][] = new boolean[m][n];

        pq.add(new Info(minTime,0,0));
        isVis[0][0] = true;

        int rowDir[] = {0,0,-1,1};
        int colDir[] = {-1,1,0,0};

        while(!pq.isEmpty()){

            Info curr = pq.remove();
            minTime = Math.max(minTime,curr.val);

            if(curr.row == m-1 && curr.col==n-1){
                return minTime;
            }

            for(int i=0; i<4; i++){
                int newR = curr.row + rowDir[i];
                int newC = curr.col + colDir[i];

                if(newR>=0 && newR<m && newC>=0 && newC<n && !isVis[newR][newC]){
                    isVis[newR][newC] = true;
                    pq.add(new Info(grid[newR][newC],newR,newC));
                }
            }
        } 
        return minTime;  
    }
}