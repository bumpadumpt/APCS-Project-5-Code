public class Piece {
    // instance variables go here!
    private int row, color, column;

    public Piece(int col, int color, Board board) { // constructor!
        this.color = color;
        this.column = col;
        row = findRow(column, board);

    }

    private int findRow(int column, Board board) { // given the state of the board, and a column, it returns the row
        int[][] boardPieces = board.getBoardPieces();
        if (this instanceof MegaPiece) {
            return 0;
        } else {
            for(int i = boardPieces[column].length-1 ; i >= 0 ; i--) {
                System.out.println(boardPieces[column][i]);
                if(boardPieces[column][i] == 0) {
                    boardPieces[column][i] = color;
                    return i;
                }
            }
            return 0;
        }
    }
    public int getCol() {
        return column;
    } //FIXME
    public int getRow() {
        return row;
    }
    public int getColor() {
        return color;
    }
}
