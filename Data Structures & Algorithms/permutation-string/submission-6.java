class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int size = map.size();

        while (j < s2.length()) {

            char ch = s2.charAt(j);

            // Add current character
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    size--;
                }
            }

            // Window bigger than s1
            if (j - i + 1 > s1.length()) {

                char left = s2.charAt(i);

                if (map.containsKey(left)) {
                    if (map.get(left) == 0) {
                        size++;
                    }

                    map.put(left, map.get(left) + 1);
                }

                i++;
            }

            // All required characters matched
            if (size == 0) {
                return true;
            }

            j++;
        }

        return false;
    }
}