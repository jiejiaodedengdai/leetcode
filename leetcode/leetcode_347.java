class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        int result[] = new int[k];


        for(int i : nums)
        {
            mp.put(i ,  mp.getOrDefault(i,0) + 1 );
        }

        PriorityQueue< Map.Entry<Integer,Integer> > pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer , Integer> entry : mp.entrySet() )
        {
            if( pq.size() < k)
            {
                pq.offer(entry);
            }
            else if( pq.peek().getValue() < entry.getValue() )
            {
                pq.poll();
                pq.offer(entry);
            }
            
            else{
                ;
            }
        }

        for(int i =  k - 1 ;  i >= 0 ; i--)
        {
            result[i] = pq.poll().getKey();
        }

        return result;

    }
}