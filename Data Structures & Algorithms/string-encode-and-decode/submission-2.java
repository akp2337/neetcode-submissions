class Solution {

    public String encode(List<String> strs) {

        StringBuilder str = new StringBuilder();

        for (String st : strs) {
            str.append(st.length()).append('#').append(st);
        }

        return str.toString();
    }

    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();

        int i = 0;
        int n = str.length();

        while (i < n) {

            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            j++;

            String st = str.substring(j, j + length);

            ans.add(st);

            i = j + length;
        }

        return ans;
    }
}