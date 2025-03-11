class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
         int n = barcodes.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : barcodes){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        pq.addAll(hm.keySet());
        int i=0;
        int [] res=new int[n];
        while(!pq.isEmpty()){
            int code = pq.poll();
            int freq = hm.remove(code);
            while(freq-->0){
                if(i>=n)i=1;
                res[i]=code;
                i+=2;
            }
        }
        return res;
    }
}