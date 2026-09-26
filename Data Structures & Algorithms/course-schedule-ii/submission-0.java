class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

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

        int [] result = new int [numCourses];
        Arrays.fill(result,-1);

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
        int i=0;
        while(!que.isEmpty()){
            int course= que.poll();
            result[i]=course;
            i++;

            for(int node: adj.get(course)){
                degree[node]-=1;
                if(degree[node]==0){
                    que.offer(node);
                }
            }
        }

        for(int ii=0;ii< numCourses;ii++){
            if(result[ii]==-1){
                return new int [0];
            }
        }

        return result;
        
        
    }
}
