public class Board {
    // declare instance variables here!
    int x;
    int y;
    private int[][] pieces;
    public Board(int x, int y) { // constructor!
        this.x = x;
        this.y = y;
        pieces = new int[x][y];
        for(int i = 0 ; i < x ; i++) {
            for(int j = 0 ; j < y ; j++) {
                pieces[i][j] = 0;
            }
        }
    }
    public void placePiece(Piece p) { // updates the state of the board with the information of the Piece
        if (p instanceof MegaPiece) {
            // hmm
        } else {
            pieces[p.getCol()][p.getRow()] = p.getColor();
        }
    }


    public int[][] getBoardPieces() { // getter function for boardPieces array
        return pieces;
    }

    public void displayAll() { // displays the entire board
        // that's quite a nice display we've got right now (displays nothing)
        System.out.println(" ");
        for(int i = 0 ; i < pieces.length ; i ++) {
            System.out.print(i);
        }
        for(int i = 0 ; i < pieces[0].length ; i ++) {
            System.out.println("#");
            for(int j = 0 ; j < pieces.length ; j ++) {
                System.out.print(".");
            }
            System.out.print("#");
        }
        for(int i = 0 ; i < pieces.length + 2 ; i ++) {
            System.out.print("#");
        }
    }
    public boolean checkForWin(int player) { //FIXME
        String checkVert = "";
        for (int[] piece : pieces) {
            checkVert = "";
            for (int j = 0; j < pieces[0].length; j++) {
                checkVert += piece[j];
            }
            if(player == 1) {
                if (checkVert.contains("11111")) {
                    return true;
                }
            } else {
                if (checkVert.contains("22222")) {
                    return true;
                }
            }
        }
        String checkHorz = "";
        for(int i = 0 ; i < pieces[0].length ; i++) {
            checkHorz = "";
            for (int[] piece : pieces) {
                checkHorz += piece[i];
            }
            if(player == 1) {
                if (checkHorz.contains("11111")) {
                    return true;
                }
            } else {
                if (checkHorz.contains("22222")) {
                    return true;
                }
            }
        }
        String checkDiag = "";
        for(int i = 5 ; i < pieces.length ; i++) {
            checkDiag = "";
            for (int j = 0 ; j < pieces.length ; j ++) {
                checkDiag += pieces[i-j][j];
            }
            if(player == 1) {
                if (checkDiag.contains("11111")) {
                    return true;
                }
            } else {
                if (checkDiag.contains("22222")) {
                    return true;
                }
            }
        }

        return false;
    }

}
