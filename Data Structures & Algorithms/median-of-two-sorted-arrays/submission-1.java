class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n= nums1.length;
        int m= nums2.length;

        int i=0;
        int j=0;

        int [] merge= new int [n+m];
        int ii=0;

        while(i<n && j<m){
            if(nums1[i]>nums2[j]){
                merge[ii]=nums2[j];
                j++;
                ii++;
            }else{
                merge[ii]=nums1[i];
                ii++;
                i++;

            }
        }

        while (i < n) {
            merge[ii] = nums1[i];
            i++;
            ii++;
        }

        // FIXED: Copy remaining elements from nums2
        while (j < m) {
            merge[ii] = nums2[j];
            j++;
            ii++;
        }

        if((n+m)%2!=0){
            return merge[(int)(n+m)/2];
        }else{

            int t=(n+m)/2;

            return (double)(merge[t-1]+ merge[t])/2;
        }
        
    }
}
