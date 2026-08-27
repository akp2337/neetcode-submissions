class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> ans = new ArrayList<>();

        if(s==null || s.length()==0){
            return ans;
        }
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0 ;i<n;i++){

            map.put(s.charAt(i),i);
        }

        int size =0;
        int end=0;

        for(int i =0;i<n;i++){
        
            char c= s.charAt(i);
            size++;
            end = Math.max(end,map.get(c));

            if(end==i){
                ans.add(size);
                size=0;
            }

        }
        return ans;

        
        
    }
}
