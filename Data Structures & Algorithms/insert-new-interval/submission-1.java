class Solution {
    public int[][] insert(int[][] interval, int[] newInterval) {

        List<int []> list = new ArrayList<>();

        for(int i=0;i<interval.length;i++){
            list.add(new int []{interval[i][0], interval[i][1]});
        }
        list.add( newInterval);

        int [][] intervals= list.toArray(new int[list.size()][]);

        int n= intervals.length;
        List<int []> ans = new ArrayList<>();

        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        int start =intervals[0][0];
        int end = intervals[0][1];

        for(int i =1;i<n;i++){
            if(end>=intervals[i][0]){
                end =Math.max(end,intervals[i][1]);
            }else{
                ans.add(new int []{start,end});
                start= intervals[i][0];
                end = intervals[i][1];
            }

        }
        ans.add(new int []{start,end});

        return ans.toArray(new int [ans.size()][]);
        
    }
}
