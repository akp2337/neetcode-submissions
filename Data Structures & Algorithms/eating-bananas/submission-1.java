class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left=1;
        int right=0;

        int n = piles.length;

        for(int pile:piles){
            right=Math.max(right,pile);
        }

        while(left<=right){

            int mid = left +(right-left)/2;

            long hr=0;

            for(int pil:piles){
                hr+= (pil + mid-1)/mid;
            }
            if(hr <= h){
                right=mid-1;
                
            }else{
                left=mid+1;
            }
        }
        return left;
        
    }
}
