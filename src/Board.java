public class Board {
    private String[][] squares;

    public Board() {
        squares = new String[10][10];
        for (int c = 0; c < squares[0].length; c++) {
            for (int r = 0; r < squares.length; r++) {
                squares[r][c] = "-";
            }
        }
    }

    public String toString(){
        String s = "";
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[0].length; c++) {
                s = s + (squares[r][c] + " ");
            }
            s = s + "\n";
        }
        return s;
    }

    public boolean addShip(int row,int col,int len,boolean horizontal) {
        boolean mrBooleanWillPayYouAVisitIfYouAreNotCareful = false;
        if (horizontal) {
            if ((col - 1) + len <= 10) {
                mrBooleanWillPayYouAVisitIfYouAreNotCareful = true;
                for (int c = 0; c < len; c++) {
                    if (squares[row - 1][(col - 1) + c].equals("b")) {
                        mrBooleanWillPayYouAVisitIfYouAreNotCareful = false;
                        break;
                    } else {
                        squares[row - 1][(col - 1) + c] = "b";
                    }
                }
            } else {
                mrBooleanWillPayYouAVisitIfYouAreNotCareful = false;
            }
        } else if (!horizontal) {
            if ((row - 1) + len <= 10) {
                mrBooleanWillPayYouAVisitIfYouAreNotCareful = true;
                for (int r = 0; r < len; r++) {
                    if (squares[(row - 1) + r][col - 1].equals("b")) {
                        mrBooleanWillPayYouAVisitIfYouAreNotCareful = false;
                        break;
                    } else {
                        squares[(row - 1) + r][col - 1] = "b";
                    }
                }
            } else {
                mrBooleanWillPayYouAVisitIfYouAreNotCareful = false;
            }
        }
        return mrBooleanWillPayYouAVisitIfYouAreNotCareful;
    }

    public boolean foundShip(int len) {
        boolean moreBooleansHolyMoly = false;
        int counter = 0;
        int totalCounter = 0;
        //checking horizontal
        for (int r = 0; r < squares.length; r++) {
            counter = 0;
            for (int c = 0; c < squares[0].length; c++) {
                if (squares[r][c].equals("b")) {
                    counter++;
                } else if (counter == len) {
                    moreBooleansHolyMoly = true;
                } else {
                    counter = 0;
                }
            }
            if (counter == len) {
                moreBooleansHolyMoly = true;
            }
        }
        //checking vertical
        for (int c = 0; c < squares[0].length; c++) {
            counter = 0;
            for (int r = 0; r < squares.length; r++) {
                if (squares[r][c].equals("b")) {
                    counter++;
                } else if (counter == len) {
                    moreBooleansHolyMoly = true;
                } else {
                    counter = 0;
                }
            }
            if (counter == len) {
                moreBooleansHolyMoly = true;
            }
        }

        //checking special case where 2 ships of length 4 are found but only take up 7 squares, resulting in the boolean being true
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[0].length; c++) {
                if (squares[r][c].equals("b")) {
                    totalCounter++;
                }
            }
        }

        return moreBooleansHolyMoly;
    }

    public int shoot(int row, int col) {
        int kablow = -1;
        if (row <= 10 && row > 0 && col <= 10 && col > 0) {
            if (squares[row - 1][col - 1].equals("-")) {
                squares[row - 1][col - 1] = "m";
                kablow = 0;
            } else if (squares[row - 1][col - 1].equals("b")) {
                squares[row - 1][col - 1] = "x";
                kablow = 1;
            } else if (squares[row - 1][col - 1].equals("x") || squares[row - 1][col - 1].equals("m")) {
                kablow = 2;
            }
        }
        return kablow;
    }

    public boolean gameOver() {
        boolean done = true;
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[0].length; c++) {
                if (squares[r][c] == "b") {
                    done = false;
                    break;
                }
            }
        }
        return done;
    }
}