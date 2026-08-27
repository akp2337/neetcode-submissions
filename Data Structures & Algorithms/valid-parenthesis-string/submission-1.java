class Solution {
    public boolean checkValidString(String s) {

        if(s.isEmpty()){
            return true;
        }

        int n= s.length();
        
        int minOpen=0;
        int maxOpen=0;

        for(int i=0;i<n;i++){

            if(s.charAt(i)=='('){
                minOpen++;
                maxOpen++;
            }else if(s.charAt(i)==')'){
                minOpen--;
                maxOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }

            minOpen= Math.max(0,minOpen);
            if(maxOpen<0){
                return false;
            }
        }

        return minOpen==0;
        
    }
}
