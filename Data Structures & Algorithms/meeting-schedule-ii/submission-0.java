/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        List<int []> list = new ArrayList<>();
        int n=intervals.size();

        for(int i=0;i<n;i++){

            list.add(new int []{intervals.get(i).start,+1});
            list.add(new int []{intervals.get(i).end,-1});
        }

        list.sort((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        int total=0;
        int evnt=0;
        for(int i=0;i<list.size();i++){

            evnt+=list.get(i)[1];
            total=Math.max(evnt,total);

        }
        return total;

    }
}
