class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> oq = new ArrayList<>();
        int m = queries.length;

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][1]);  // mi
            temp.add(queries[i][0]);  // xi
            temp.add(i);              // index
            oq.add(temp);
        }

        // Sort based on mi
        Collections.sort(oq, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });

        int[] ans = new int[m];
        Arrays.fill(ans, -1);

        Trie trie = new Trie();
        int ind = 0;
        int n = nums.length;

        for (int i = 0; i < m; i++) {
            int mi = oq.get(i).get(0);
            int xi = oq.get(i).get(1);
            int queryIndex = oq.get(i).get(2);

            while (ind < n && nums[ind] <= mi) {
                trie.insert(nums[ind]);
                ind++;
            }

            if (ind != 0) {
                ans[queryIndex] = trie.getmax(xi);
            }
        }

        return ans;
    }
}
class Node{
    Node[] links = new Node[2];
    Node(){}
    public boolean containsKey(int bit){
        return links[bit]!=null;
    }
    public void put(int bit,Node node){
        links[bit]=node;
    }
    public Node get(int bit){
        return links[bit];
    }
}
public class Trie{

    private static Node root;

    public Trie(){
        root = new Node();
    }

    public static  void insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = ((num>>i) & 1);
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    }
    public int getmax(int num){
        Node node=root;
        int maxnum=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.containsKey(1-bit)){
                maxnum=maxnum|(1<<i);
                node=node.get(1-bit);
            }
            else{
                node=node.get(bit);
            }
        }
        return maxnum;
    }

}
