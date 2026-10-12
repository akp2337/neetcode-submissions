class Solution {
    public int trap(int[] height) {

        int n= height.length;
        int [] maxR= new int [n];
        int [] maxL  = new int[n];
        int [] maxW= new int [n];

        maxL[0]=height[0];
        for(int i=1;i<n;i++){
            maxL[i]= Math.max(height[i],maxL[i-1]);
        }

        maxR[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            maxR[i]= Math.max(height[i],maxR[i+1]);
        }

        for(int i=0;i<n;i++){
            maxW[i]=Math.min(maxL[i], maxR[i]);
        }

        int total=0;
        for(int i=0;i<n;i++){
            total+=maxW[i]-height[i];
        }
        return total;
        
    }
}
