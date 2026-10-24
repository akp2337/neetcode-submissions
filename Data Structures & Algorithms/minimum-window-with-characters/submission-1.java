class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int size = map.size();
        int j = 0;
        int i = 0;
        int temp = Integer.MAX_VALUE;
        String ans = "";

        while (j < n) {

            char ch = s.charAt(j);

            if (map.containsKey(ch)) {

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    size--;
                }
            }

            if (size == 0) {

                // FIXED: keep shrinking while window is valid
                while (i <= j && size == 0) {

                    // FIXED: check current valid window BEFORE removing
                    if (j - i + 1 < temp) {
                        temp = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }

                    char left = s.charAt(i);

                    if (map.containsKey(left)) {

                        map.put(left, map.get(left) + 1);

                        if (map.get(left) == 1) {
                            size++;
                        }
                    }

                    i++;
                }
            }

            j++;
        }

        return ans;
    }
}