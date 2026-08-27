class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length;
        int totalGas= 0;
        int totalCost= 0;

        int start=0;
        int currentGas=0;
        for(int i =0;i<n;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];

            int gain = gas[i]-cost[i];

            currentGas+=gain;
            if(currentGas<0){
                start = i+1;
                currentGas =0;
            }

        }
        return totalGas>=totalCost?start:-1;
        
    }
}
