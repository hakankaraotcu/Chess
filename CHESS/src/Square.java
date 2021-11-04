
public class Square {
	int color;
	private int row;
	private int col;
	private ChessBoard board;
	private Piece piece;
	
	public Square(int row, int col, ChessBoard board) {
		this.row = row;
		this.col = col;
		this.board = board;
		if((row & 1) == (col & 2)) {
			color = ChessBoard.WHITE;
		} else {
			color = ChessBoard.BLACK;
		}
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public ChessBoard getBoard() {
		return board;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public int getRowDistance(Square location) {
		int rowDistance = location.getRow() - row;
		return rowDistance;
	}
	
	public boolean isEmpty() {
		return piece == null ? true : false;
	}

	public boolean isAtSameColumn(Square targetLocation) {
		return col == targetLocation.getCol() ? true : false;
	}

	public boolean isNeighborColumn(Square targetLocation) {
		return row == targetLocation.getRow() || row + 1 == targetLocation.getRow() || row - 1 == targetLocation.getRow() ? true : false;
	}

	public void clear() {
		piece = null;
	}

	public boolean isAtLastRow(int color) {
		this.color = color;
		return row == 0 || row == 7 ? true : false;
	}
	

	public void putNewQueen(int color) {
		setPiece(new Queen(color, board.squares[row][col]));
	}

	public int getColDistance(Square location) {
		int colDistance = location.getCol() - col;
		return colDistance;
	}

	public int getDifRowCol(Square location) {
		int difRowCol = location.getRow() - row;
		return difRowCol;
	}
}
