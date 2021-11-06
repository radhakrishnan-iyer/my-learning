import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ZetaChess {

    class ChessBoard {
        Cell[][] cells = new Cell[8][8];
        Map<Cell,Coin> whiteMap = new HashMap<>();
        Map<Cell,Coin> blackMap = new HashMap<>();

        ChessBoard() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    cells[i][j] = new Cell(i,j,true);
                }
            }

            // White coins
            whiteMap.put(cells[0][0] , new Elephant(cells[0][0], 1));
            whiteMap.put(cells[0][7] , new Elephant(cells[0][7] , 1));
            whiteMap.put(cells[0][1] , new Knight(cells[0][1] , 1));
            whiteMap.put(cells[0][6] , new Knight(cells[0][6] , 1));
            whiteMap.put(cells[0][2] , new Bishop(cells[0][2] , 1));
            whiteMap.put(cells[0][5] , new Bishop(cells[0][5] , 1));
            whiteMap.put(cells[0][3] , new Queen(cells[0][3] , 1));
            whiteMap.put(cells[0][4] , new King(cells[0][4] , 1));
            whiteMap.put(cells[1][0] , new Pawns(cells[1][0], 1));
            whiteMap.put(cells[1][7] , new Pawns(cells[1][7] , 1));
            whiteMap.put(cells[1][1] , new Pawns(cells[1][1] , 1));
            whiteMap.put(cells[1][6] , new Pawns(cells[1][6] , 1));
            whiteMap.put(cells[1][2] , new Pawns(cells[1][2] , 1));
            whiteMap.put(cells[1][5] , new Pawns(cells[1][5] , 1));
            whiteMap.put(cells[1][3] , new Pawns(cells[1][3] , 1));
            whiteMap.put(cells[1][4] , new Pawns(cells[1][4] , 1));

            // Black coins
            blackMap.put(cells[7][0], new Elephant(cells[7][0], 0));
            blackMap.put(cells[7][7], new Elephant(cells[7][7] , 0));
            blackMap.put(cells[7][1], new Knight(cells[7][1] , 0));
            blackMap.put(cells[7][6], new Knight(cells[7][6] , 0));
            blackMap.put(cells[7][2], new Bishop(cells[7][2] , 0));
            blackMap.put(cells[7][5], new Bishop(cells[7][5] , 0));
            blackMap.put(cells[7][3], new Queen(cells[7][3] , 0));
            blackMap.put(cells[7][4], new King(cells[7][4] , 0));
            blackMap.put(cells[6][0], new Pawns(cells[6][0], 0));
            blackMap.put(cells[6][7], new Pawns(cells[6][7] , 0));
            blackMap.put(cells[6][1], new Pawns(cells[6][1] , 0));
            blackMap.put(cells[6][6], new Pawns(cells[6][6] , 0));
            blackMap.put(cells[6][2], new Pawns(cells[6][2] , 0));
            blackMap.put(cells[6][5], new Pawns(cells[6][5] , 0));
            blackMap.put(cells[6][3], new Pawns(cells[6][3] , 0));
            blackMap.put(cells[6][4], new Pawns(cells[6][4] , 0));
        }

        public Map<Cell,Coin> getWhiteMap() {
            return whiteMap;
        }

        public Map<Cell,Coin> getBlackMap() {
            return blackMap;
        }

        // method which will show next valid moves for the player
        public List<Cell> predictNextMoves(int player, Cell currentPosition) {
            if(player==1) {
                Coin c = whiteMap.get(currentPosition);
                return c.nextMoves();
            }
            Coin c = blackMap.get(currentPosition);
            return c.nextMoves();
        }
    }

    class Cell {
        private final int i;
        private final int j;
        private boolean isFree;
        public Cell(int i, int j, boolean isFree) {
            this.i = i;
            this.j = j;
            this.isFree = isFree;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(i) * Objects.hashCode(j);
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Cell))
                return false;
            Cell c = (Cell) o;
            return this.i == c.i && this.j==c.j;
        }
    }

    class ChessService {
        ChessBoard chessBoard;

        boolean updateCell(Cell cell) {
            Map<Cell,Coin> blackMap = chessBoard.getBlackMap();
            Map<Cell,Coin> whiteMap = chessBoard.getWhiteMap();
            if(blackMap.containsKey(cell)) {
                Coin coin = blackMap.get(cell);
                coin.isAlive = false;
                blackMap.remove(cell);
                return true;
            }
            if(whiteMap.containsKey(cell)) {
                Coin coin = whiteMap.get(cell);
                coin.isAlive = false;
                whiteMap.remove(cell);
                return true;
            }
            return false;
        }

        boolean updatePosition(int color, Cell cell, Coin coin) {
            Map<Cell,Coin> blackMap = chessBoard.getBlackMap();
            Map<Cell,Coin> whiteMap = chessBoard.getWhiteMap();
            if(color==1) {
                whiteMap.put(cell, coin);
                return true;
            }
            blackMap.put(cell, coin);
            return true;
        }
    }

    abstract class Coin {
        Cell currentPosition;
        int color; // 1 = white, 0 = black
        private boolean isAlive;
        ChessService chessService;
        abstract List<Cell> nextMoves();

        Coin(Cell currentPosition , int color) {
            this.currentPosition = currentPosition;
            this.color = color;
            this.isAlive = true;
        }

        Coin(Cell currentPosition , int color, boolean isAlive) {
            this.currentPosition = currentPosition;
            this.color = color;
            this.isAlive = isAlive;
        }

        boolean updatePosition(Cell newPosition) {
            if(currentPosition!=null)
                this.currentPosition.isFree = true; // mark prev cell free

            if(!newPosition.isFree) {
                chessService.updateCell(newPosition);
            }

            this.currentPosition = newPosition;
            newPosition.isFree = false;
            chessService.updatePosition(color , newPosition, this);
            return true;
        }
    }

    class Pawns extends Coin {
        public Pawns(Cell initialPosition, int color) {
            super(initialPosition, color);
        }
        @Override
        List<Cell> nextMoves() {
            //implement logic to return list of next valid state
            return null;
        }
    }

    class Knight extends Coin {
        public Knight(Cell initialPosition, int color) {
            super(initialPosition, color);
        }
        @Override
        List<Cell> nextMoves() {
            //implement logic to return list of next valid state

            return null;
        }
    }

    class Elephant extends Coin {
        public Elephant(Cell initialPosition, int color) {
            super(initialPosition, color);
        }
        @Override
        List<Cell> nextMoves() {
            //implement logic to return list of next valid state

            return null;
        }
    }

    class Bishop extends Coin {
        public Bishop(Cell initialPosition, int color) {
            super(initialPosition, color);
        }
        @Override
        List<Cell> nextMoves() {
            //implement logic to return list of next valid state

            return null;
        }
    }

    class Queen extends Coin {
        public Queen(Cell initialPosition, int color) {
            super(initialPosition, color);
        }
        @Override
        List<Cell> nextMoves() {
            //implement logic to return list of next valid state

            return null;
        }
    }

    class King extends Coin {
        public King(Cell initialPosition, int color) {
            super(initialPosition, color);
        }
        @Override
        List<Cell> nextMoves() {
            //implement logic to return list of next valid state

            return null;
        }
    }

}
