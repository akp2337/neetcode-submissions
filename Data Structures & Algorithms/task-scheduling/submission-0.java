class Solution {
    public int leastInterval(char[] tasks, int n) {

        int [] count = new int [26];
        for(char task:tasks){

            count[task-'A']+=1;

        }

        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<26;i++){
            if(count[i]>0){
                que.add(count[i]);
            }
        }

        int time =0;

        while(!que.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int process=0;
            for(int i=0;i<=n;i++){
                if(!que.isEmpty()){

                    int freq= que.poll();
                    freq--;
                    if(freq>0){
                        list.add(freq);
                    }
                    process++;

                }
            }

            for(int val: list){
                que.add(val);
            }

            if(!que.isEmpty()){
                time+=n+1;
            }else{
                time+=process;
            }
        }
        return time;

        
    }
}
