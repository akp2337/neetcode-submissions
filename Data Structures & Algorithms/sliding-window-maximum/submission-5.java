class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        Deque<Integer> que = new LinkedList<>();

        while (j < n) {

            // Remove smaller elements from the back
            while (!que.isEmpty() && nums[que.peekLast()] < nums[j]) {
                que.pollLast();
            }

            que.addLast(j);

            // FIXED: remove elements which are outside current window
            while (!que.isEmpty() && que.peekFirst() < i) {
                que.pollFirst();
            }

            if (j - i + 1 == k) {

                list.add(nums[que.peekFirst()]);

                i++;
            }

            j++;
        }

        int[] ans = new int[list.size()];

        for (int ii = 0; ii < list.size(); ii++) {
            ans[ii] = list.get(ii);
        }

        return ans;
    }
}