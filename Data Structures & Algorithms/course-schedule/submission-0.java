class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] course:prerequisites){
            int c= course[0];
            int pre = course[1];
            adj.get(pre).add(c);
        }

        int [] degree = new int [numCourses];
        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            for(int x:adj.get(i)){
                degree[x]+=1;
            }
        }

        for(int i=0;i<numCourses;i++){
            if(degree[i]==0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int course= que.poll();
            ans.add(course);

            for(int node: adj.get(course)){
                degree[node]-=1;
                if(degree[node]==0){
                    que.offer(node);
                }
            }
        }

        return ans.size()==numCourses?true:false;
        
    }
}
