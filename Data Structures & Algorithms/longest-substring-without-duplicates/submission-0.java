class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> map = new HashMap<>();

        int ans=0;
        int i=0;
        int j=0;
        int n= s.length();
        while(j<n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()==j-i+1){
                ans=Math.max(ans,j-i+1);
                j++;
            }else{
                while(map.size()<(j-i+1)){
                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i),map.get(s.charAt(i))-1);
                        if(map.get(s.charAt(i))==0){
                            map.remove(s.charAt(i));
                        }
                    }
                    i++;

                }
                j++;
            }
        }
        return ans;
        
    }
}
