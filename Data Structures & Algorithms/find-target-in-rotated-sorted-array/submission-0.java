class Solution {
    public int search(int[] nums, int target) {

        int n= nums.length;

        if(n==1){
            if(nums[0]==target){
                return 0;
            }
            return -1;
        }

        int start = 0;
        int end = n-1;

        while(start<end){
            int mid = start +(end - start)/2;

            if(nums[mid]>nums[end]){
                start=mid+1;
            }else{
                end= mid;
            }
        }

        int leftBs=bs(0,start-1, nums,target);
        int rightBs=bs(start,n-1,nums,target);

        if(leftBs==-1 && rightBs==-1){
            return -1;
        }else if(leftBs==-1){
            return rightBs;
        }else{
            return leftBs;
        }
        
    }

    public int bs(int start , int end , int [] arr, int target){

        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return mid;

            }else if(arr[mid]>target){
                end= mid-1;
            }else {
                start=mid+1;
            }
        }
        return -1;
    }
}
