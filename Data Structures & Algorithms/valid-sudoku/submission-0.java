class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                char num = board[i][j];

                // Ignore empty cells
                if (num == '.') {
                    continue;
                }

                // Find which 3x3 box this cell belongs to
                int boxIndex = (i / 3) * 3 + (j / 3);

                // Duplicate in row
                if (!rows[i].add(num)) {
                    return false;
                }

                // Duplicate in column
                if (!cols[j].add(num)) {
                    return false;
                }

                // Duplicate in 3x3 box
                if (!boxes[boxIndex].add(num)) {
                    return false;
                }
            }
        }

        return true;
    }
}
