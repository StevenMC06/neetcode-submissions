class Solution {
    public boolean isValidSudoku(char[][] board) {
         HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] square = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            square[i] = new HashSet<>();
        }
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if(val == '.') {
                    continue;
                }

                int boxIndex = (i/3) * 3 + (j/3);


                if(rows[i].contains(val) || columns[j].contains(val) || square[boxIndex].contains(val)){
                    return false;
                }
                rows[i].add(val);
                columns[j].add(val);
                square[boxIndex].add(val);

            }
        }
        return true;
    }
}