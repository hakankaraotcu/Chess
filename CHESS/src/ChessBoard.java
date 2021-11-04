
public class ChessBoard {
	
	public boolean whitePlaying = true;
	public final static int WHITE = 0;
	public final static int BLACK = 1;
	public Square[][] squares = new Square[8][8];
	private Piece pieceAt;
	private Square squareAt;
	Square [] key  = new Square[64];

	public ChessBoard() {
		for(int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new Square(i, j , this);
				squares[i][j].setPiece(null);
			}
		}
		
		initialize();
	}
	
	public void initialize() {
		
		for(int i= 0; i < 8; i++) {
			squares[6][i].setPiece(new Pawn(ChessBoard.WHITE, squares[6][i]));
			squares[1][i].setPiece(new Pawn(ChessBoard.BLACK, squares[1][i]));
		}
		
		squares[7][7].setPiece(new Rook(ChessBoard.WHITE, squares[7][7]));
		squares[7][0].setPiece(new Rook(ChessBoard.WHITE, squares[7][0]));
		squares[0][0].setPiece(new Rook(ChessBoard.BLACK, squares[0][0]));
		squares[0][7].setPiece(new Rook(ChessBoard.BLACK, squares[0][7]));
		squares[7][1].setPiece(new Knight(ChessBoard.WHITE, squares[7][1]));
		squares[7][6].setPiece(new Knight(ChessBoard.WHITE, squares[7][6]));
		squares[0][1].setPiece(new Knight(ChessBoard.BLACK, squares[0][1]));
		squares[0][6].setPiece(new Knight(ChessBoard.BLACK, squares[0][6]));
		squares[7][2].setPiece(new Bishop(ChessBoard.WHITE, squares[7][2]));
		squares[7][5].setPiece(new Bishop(ChessBoard.WHITE, squares[7][5]));
		squares[0][2].setPiece(new Bishop(ChessBoard.BLACK, squares[0][2]));
		squares[0][5].setPiece(new Bishop(ChessBoard.BLACK, squares[0][5]));
		squares[7][3].setPiece(new Queen(ChessBoard.WHITE, squares[7][3]));
		squares[0][3].setPiece(new Queen(ChessBoard.BLACK, squares[0][3]));
		squares[7][4].setPiece(new King(ChessBoard.WHITE, squares[7][4]));
		squares[0][4].setPiece(new King(ChessBoard.BLACK, squares[0][4]));
		
		key[0] = squares[7][0];
		key[1] = squares[6][0];
		key[2] = squares[5][0];
		key[3] = squares[4][0];
		key[4] = squares[3][0];
		key[5] = squares[2][0];
		key[6] = squares[1][0];
		key[7] = squares[0][0];		
		key[8] = squares[7][1];
		key[9] = squares[6][1];
		key[10] = squares[5][1];
		key[11] = squares[4][1];
		key[12] = squares[3][1];
		key[13] = squares[2][1];
		key[14] = squares[1][1];
		key[15] = squares[0][1];
		key[16] = squares[7][2];
		key[17] = squares[6][2];
		key[18] = squares[5][2];
		key[19] = squares[4][2];
		key[20] = squares[3][2];
		key[21] = squares[2][2];
		key[22] = squares[1][2];
		key[23] = squares[0][2];
		key[24] = squares[7][3];
		key[25] = squares[6][3];
		key[26] = squares[5][3];
		key[27] = squares[4][3];
		key[28] = squares[3][3];
		key[29] = squares[2][3];
		key[30] = squares[1][3];
		key[31] = squares[0][3];
		key[32] = squares[7][4];
		key[33] = squares[6][4];
		key[34] = squares[5][4];
		key[35] = squares[4][4];
		key[36] = squares[3][4];
		key[37] = squares[2][4];
		key[38] = squares[1][4];
		key[39] = squares[0][4];
		key[40] = squares[7][5];
		key[41] = squares[6][5];
		key[42] = squares[5][5];
		key[43] = squares[4][5];
		key[44] = squares[3][5];
		key[45] = squares[2][5];
		key[46] = squares[1][5];
		key[47] = squares[0][5];
		key[48] = squares[7][6];
		key[49] = squares[6][6];
		key[50] = squares[5][6];
		key[51] = squares[4][6];
		key[52] = squares[3][6];
		key[53] = squares[2][6];
		key[54] = squares[1][6];
		key[55] = squares[0][6];
		key[56] = squares[7][7];
		key[57] = squares[6][7];
		key[58] = squares[5][7];
		key[59] = squares[4][7];
		key[60] = squares[3][7];
		key[61] = squares[2][7];
		key[62] = squares[1][7];
		key[63] = squares[0][7];
	}
	
	public String toString() {
		int num = 8;
		StringBuilder sb = new StringBuilder();
		sb.append("      A   B   C   D   E   F   G   H " + "\n    ---------------------------------");
		for(int i = 0; i < 8; i++) {
			sb.append("\n  " + (num)  + " |");
			for(int j = 0; j < 8; j++) {
				Piece here = squares[i][j].getPiece();
				if(here == null) {
					sb.append("   |");
					continue;
				}
				if(here.getColor() == WHITE) 
					sb.append(" " + squares[i][j].getPiece().toString() + " |");
				if(here.getColor() == BLACK)
					sb.append(" " + squares[i][j].getPiece().toString() + " |");
				
			} sb.append(" " + num);
			sb.append("\n    ---------------------------------");
			num-=1;
			
		} sb.append("\n      A   B   C   D   E   F   G   H ");
		return sb.toString();
	}
	
	public boolean isGameEnded() {
		int blackPieces = 0 ;
		int whitePieces = 0 ;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Piece here = squares[i][j].getPiece();
				if(here == null)
					continue;
				if(here.getColor() == WHITE) whitePieces++;
				if(here.getColor() == BLACK) blackPieces++;
			}
		}
		return blackPieces == 0 || whitePieces == 0 ? true : false;
	}

	public boolean isWhitePlaying() {
		if(whitePlaying == true) return true;
		return false;
	}

	public Piece getPieceAt(String from) {
		
		char ch1 = from.charAt(0);
		char ch2 = from.charAt(1);
		if (ch1 == 'a' && ch2 == '1') this.pieceAt = key[0].getPiece();
		else if (ch1 == 'a' && ch2 == '2') this.pieceAt = key[1].getPiece();
		else if (ch1 == 'a' && ch2 == '3') this.pieceAt = key[2].getPiece();
		else if (ch1 == 'a' && ch2 == '4') this.pieceAt = key[3].getPiece();
		else if (ch1 == 'a' && ch2 == '5') this.pieceAt = key[4].getPiece();
		else if (ch1 == 'a' && ch2 == '6') this.pieceAt = key[5].getPiece();
		else if (ch1 == 'a' && ch2 == '7') this.pieceAt = key[6].getPiece();
		else if (ch1 == 'a' && ch2 == '8') this.pieceAt = key[7].getPiece();
		else if (ch1 == 'b' && ch2 == '1') this.pieceAt = key[8].getPiece();
		else if (ch1 == 'b' && ch2 == '2') this.pieceAt = key[9].getPiece();
		else if (ch1 == 'b' && ch2 == '3') this.pieceAt = key[10].getPiece();
		else if (ch1 == 'b' && ch2 == '4') this.pieceAt = key[11].getPiece();
		else if (ch1 == 'b' && ch2 == '5') this.pieceAt = key[12].getPiece();
		else if (ch1 == 'b' && ch2 == '6') this.pieceAt = key[13].getPiece();
		else if (ch1 == 'b' && ch2 == '7') this.pieceAt = key[14].getPiece();
		else if (ch1 == 'b' && ch2 == '8') this.pieceAt = key[15].getPiece();
		else if (ch1 == 'c' && ch2 == '1') this.pieceAt = key[16].getPiece();
		else if (ch1 == 'c' && ch2 == '2') this.pieceAt = key[17].getPiece();
		else if (ch1 == 'c' && ch2 == '3') this.pieceAt = key[18].getPiece();
		else if (ch1 == 'c' && ch2 == '4') this.pieceAt = key[19].getPiece();
		else if (ch1 == 'c' && ch2 == '5') this.pieceAt = key[20].getPiece();
		else if (ch1 == 'c' && ch2 == '6') this.pieceAt = key[21].getPiece();
		else if (ch1 == 'c' && ch2 == '7') this.pieceAt = key[22].getPiece();
		else if (ch1 == 'c' && ch2 == '8') this.pieceAt = key[23].getPiece();
		else if (ch1 == 'd' && ch2 == '1') this.pieceAt = key[24].getPiece();
		else if (ch1 == 'd' && ch2 == '2') this.pieceAt = key[25].getPiece();
		else if (ch1 == 'd' && ch2 == '3') this.pieceAt = key[26].getPiece();
		else if (ch1 == 'd' && ch2 == '4') this.pieceAt = key[27].getPiece();
		else if (ch1 == 'd' && ch2 == '5') this.pieceAt = key[28].getPiece();
		else if (ch1 == 'd' && ch2 == '6') this.pieceAt = key[29].getPiece();
		else if (ch1 == 'd' && ch2 == '7') this.pieceAt = key[30].getPiece();
		else if (ch1 == 'd' && ch2 == '8') this.pieceAt = key[31].getPiece();
		else if (ch1 == 'e' && ch2 == '1') this.pieceAt = key[32].getPiece();
		else if (ch1 == 'e' && ch2 == '2') this.pieceAt = key[33].getPiece();
		else if (ch1 == 'e' && ch2 == '3') this.pieceAt = key[34].getPiece();
		else if (ch1 == 'e' && ch2 == '4') this.pieceAt = key[35].getPiece();
		else if (ch1 == 'e' && ch2 == '5') this.pieceAt = key[36].getPiece();
		else if (ch1 == 'e' && ch2 == '6') this.pieceAt = key[37].getPiece();
		else if (ch1 == 'e' && ch2 == '7') this.pieceAt = key[38].getPiece();
		else if (ch1 == 'e' && ch2 == '8') this.pieceAt = key[39].getPiece();
		else if (ch1 == 'f' && ch2 == '1') this.pieceAt = key[40].getPiece();
		else if (ch1 == 'f' && ch2 == '2') this.pieceAt = key[41].getPiece();
		else if (ch1 == 'f' && ch2 == '3') this.pieceAt = key[42].getPiece();
		else if (ch1 == 'f' && ch2 == '4') this.pieceAt = key[43].getPiece();
		else if (ch1 == 'f' && ch2 == '5') this.pieceAt = key[44].getPiece();
		else if (ch1 == 'f' && ch2 == '6') this.pieceAt = key[45].getPiece();
		else if (ch1 == 'f' && ch2 == '7') this.pieceAt = key[46].getPiece();
		else if (ch1 == 'f' && ch2 == '8') this.pieceAt = key[47].getPiece();
		else if (ch1 == 'g' && ch2 == '1') this.pieceAt = key[48].getPiece();
		else if (ch1 == 'g' && ch2 == '2') this.pieceAt = key[49].getPiece();
		else if (ch1 == 'g' && ch2 == '3') this.pieceAt = key[50].getPiece();
		else if (ch1 == 'g' && ch2 == '4') this.pieceAt = key[51].getPiece();
		else if (ch1 == 'g' && ch2 == '5') this.pieceAt = key[52].getPiece();
		else if (ch1 == 'g' && ch2 == '6') this.pieceAt = key[53].getPiece();
		else if (ch1 == 'g' && ch2 == '7') this.pieceAt = key[54].getPiece();
		else if (ch1 == 'g' && ch2 == '8') this.pieceAt = key[55].getPiece();
		else if (ch1 == 'h' && ch2 == '1') this.pieceAt = key[56].getPiece();
		else if (ch1 == 'h' && ch2 == '2') this.pieceAt = key[57].getPiece();
		else if (ch1 == 'h' && ch2 == '3') this.pieceAt = key[58].getPiece();
		else if (ch1 == 'h' && ch2 == '4') this.pieceAt = key[59].getPiece();
		else if (ch1 == 'h' && ch2 == '5') this.pieceAt = key[60].getPiece();
		else if (ch1 == 'h' && ch2 == '6') this.pieceAt = key[61].getPiece();
		else if (ch1 == 'h' && ch2 == '7') this.pieceAt = key[62].getPiece();
		else if (ch1 == 'h' && ch2 == '8') this.pieceAt = key[63].getPiece();
		else return null;
		return pieceAt;
	}

	public Square getSquareAt(String to) {
		char ch1 = to.charAt(0);
		char ch2 = to.charAt(1);
		if (ch1 == 'a' && ch2 == '1') this.squareAt = key[0];
		else if (ch1 == 'a' && ch2 == '2') this.squareAt = key[1];
		else if (ch1 == 'a' && ch2 == '3') this.squareAt = key[2];
		else if (ch1 == 'a' && ch2 == '4') this.squareAt = key[3];
		else if (ch1 == 'a' && ch2 == '5') this.squareAt = key[4];
		else if (ch1 == 'a' && ch2 == '6') this.squareAt = key[5];
		else if (ch1 == 'a' && ch2 == '7') this.squareAt = key[6];
		else if (ch1 == 'a' && ch2 == '8') this.squareAt = key[7];
		else if (ch1 == 'b' && ch2 == '1') this.squareAt = key[8];
		else if (ch1 == 'b' && ch2 == '2') this.squareAt = key[9];
		else if (ch1 == 'b' && ch2 == '3') this.squareAt = key[10];
		else if (ch1 == 'b' && ch2 == '4') this.squareAt = key[11];
		else if (ch1 == 'b' && ch2 == '5') this.squareAt = key[12];
		else if (ch1 == 'b' && ch2 == '6') this.squareAt = key[13];
		else if (ch1 == 'b' && ch2 == '7') this.squareAt = key[14];
		else if (ch1 == 'b' && ch2 == '8') this.squareAt = key[15];
		else if (ch1 == 'c' && ch2 == '1') this.squareAt = key[16];
		else if (ch1 == 'c' && ch2 == '2') this.squareAt = key[17];
		else if (ch1 == 'c' && ch2 == '3') this.squareAt = key[18];
		else if (ch1 == 'c' && ch2 == '4') this.squareAt = key[19];
		else if (ch1 == 'c' && ch2 == '5') this.squareAt = key[20];
		else if (ch1 == 'c' && ch2 == '6') this.squareAt = key[21];
		else if (ch1 == 'c' && ch2 == '7') this.squareAt = key[22];
		else if (ch1 == 'c' && ch2 == '8') this.squareAt = key[23];
		else if (ch1 == 'd' && ch2 == '1') this.squareAt = key[24];
		else if (ch1 == 'd' && ch2 == '2') this.squareAt = key[25];
		else if (ch1 == 'd' && ch2 == '3') this.squareAt = key[26];
		else if (ch1 == 'd' && ch2 == '4') this.squareAt = key[27];
		else if (ch1 == 'd' && ch2 == '5') this.squareAt = key[28];
		else if (ch1 == 'd' && ch2 == '6') this.squareAt = key[29];
		else if (ch1 == 'd' && ch2 == '7') this.squareAt = key[30];
		else if (ch1 == 'd' && ch2 == '8') this.squareAt = key[31];
		else if (ch1 == 'e' && ch2 == '1') this.squareAt = key[32];
		else if (ch1 == 'e' && ch2 == '2') this.squareAt = key[33];
		else if (ch1 == 'e' && ch2 == '3') this.squareAt = key[34];
		else if (ch1 == 'e' && ch2 == '4') this.squareAt = key[35];
		else if (ch1 == 'e' && ch2 == '5') this.squareAt = key[36];
		else if (ch1 == 'e' && ch2 == '6') this.squareAt = key[37];
		else if (ch1 == 'e' && ch2 == '7') this.squareAt = key[38];
		else if (ch1 == 'e' && ch2 == '8') this.squareAt = key[39];
		else if (ch1 == 'f' && ch2 == '1') this.squareAt = key[40];
		else if (ch1 == 'f' && ch2 == '2') this.squareAt = key[41];
		else if (ch1 == 'f' && ch2 == '3') this.squareAt = key[42];
		else if (ch1 == 'f' && ch2 == '4') this.squareAt = key[43];
		else if (ch1 == 'f' && ch2 == '5') this.squareAt = key[44];
		else if (ch1 == 'f' && ch2 == '6') this.squareAt = key[45];
		else if (ch1 == 'f' && ch2 == '7') this.squareAt = key[46];
		else if (ch1 == 'f' && ch2 == '8') this.squareAt = key[47];
		else if (ch1 == 'g' && ch2 == '1') this.squareAt = key[48];
		else if (ch1 == 'g' && ch2 == '2') this.squareAt = key[49];
		else if (ch1 == 'g' && ch2 == '3') this.squareAt = key[50];
		else if (ch1 == 'g' && ch2 == '4') this.squareAt = key[51];
		else if (ch1 == 'g' && ch2 == '5') this.squareAt = key[52];
		else if (ch1 == 'g' && ch2 == '6') this.squareAt = key[53];
		else if (ch1 == 'g' && ch2 == '7') this.squareAt = key[54];
		else if (ch1 == 'g' && ch2 == '8') this.squareAt = key[55];
		else if (ch1 == 'h' && ch2 == '1') this.squareAt = key[56];
		else if (ch1 == 'h' && ch2 == '2') this.squareAt = key[57];
		else if (ch1 == 'h' && ch2 == '3') this.squareAt = key[58];
		else if (ch1 == 'h' && ch2 == '4') this.squareAt = key[59];
		else if (ch1 == 'h' && ch2 == '5') this.squareAt = key[60];
		else if (ch1 == 'h' && ch2 == '6') this.squareAt = key[61];
		else if (ch1 == 'h' && ch2 == '7') this.squareAt = key[62];
		else if (ch1 == 'h' && ch2 == '8') this.squareAt = key[63];
		return squareAt;
	}

	public Square[] getSquaresBetween(Square location, Square targetLocation) {
		Square[] b = new Square[8];
		int num = 0;
		if(location.isAtSameColumn(targetLocation)) {
			if(targetLocation.getRow() > location.getRow()) {
				for(int i = location.getRow() + 1; i != targetLocation.getRow(); i++) {
					b[num] = squares[i][location.getCol()];
					num++;
				}
				for(int x = num; x < 8; x++){
					b[x] = squares[location.getRow() + 1][location.getCol()];
				}
			}
			else if(location.getRow() > targetLocation.getRow()) {
				for(int i = location.getRow() - 1; i != targetLocation.getRow(); i--) {
					b[num] = squares[i][location.getCol()];
					num++;
				}
				for(int x = num; x < 8; x++){
					b[x] = squares[location.getRow() - 1][location.getCol()];
				}
			}
		} 
		else if(location.isNeighborColumn(targetLocation)) {
			if(targetLocation.getCol() > location.getCol()) {
				for(int i = location.getCol() + 1; i != targetLocation.getCol(); i++) {
					b[num] = squares[location.getRow()][i];
					num++;
				}
				for(int x = num; x < 8; x++){
					b[x] = squares[location.getRow()][location.getCol() + 1];
				}
			}
			else if(location.getCol() > targetLocation.getCol()) {
				for(int i = location.getCol() - 1; i != targetLocation.getCol(); i--) {
					b[num] = squares[location.getRow()][i];
					num++;
				}
				for(int x = num; x < 8; x++){
					b[x] = squares[location.getRow()][location.getCol() - 1];
				}
			}
		}
		else {
			int i = location.getRow();
			int k = location.getCol();
			int j = targetLocation.getRow();
			int h = targetLocation.getCol();
			if(targetLocation.getRow() > location.getRow() && location.getCol() > targetLocation.getCol()) {
				while(!(i + 1 == targetLocation.getRow() && k - 1 == targetLocation.getCol())) {
					b[num] = squares[i + 1][k - 1];
					i++;
					k--;
					num++;
				}
				for(int x = num; x < 8; x++) {
					b[x] = squares[location.getRow() + 1][location.getCol() - 1];
				}
			}
			else if(location.getRow() > targetLocation.getRow() && location.getCol() > targetLocation.getCol()) {
				while(!(j + 1 == location.getRow() && h + 1 == location.getCol())) {
					b[num] = squares[j + 1][h + 1];
					j++;
					h++;
					num++;
				}
				for(int x = num; x < 8; x++) {
					b[x] = squares[targetLocation.getRow() + 1][targetLocation.getCol() + 1];
				}
			}
			else if(location.getRow() > targetLocation.getRow() && targetLocation.getCol() > location.getCol()) {
				while(!(j + 1 == location.getRow() && h - 1 == location.getCol())) {
					b[num] = squares[j + 1][h - 1];
					j++;
					h--;
					num++;
				}
				for(int x = num; x < 8; x++) {
					b[x] = squares[targetLocation.getRow() + 1][targetLocation.getCol() - 1];
				}
			}
			else if(targetLocation.getRow() > location.getRow() && targetLocation.getCol() > location.getCol()) {
				while(!(i + 1 == targetLocation.getRow() && k + 1 == targetLocation.getCol())) {
					b[num] = squares[i + 1][k + 1];
					i++;
					k++;
					num++;
				}
				for(int x = num; x < 8; x ++) {
					b[x] = squares[location.getRow() + 1][location.getCol() + 1];
				}
			}
		}
		return b;
	}

	public void nextPlayer() {
		if(isWhitePlaying()) whitePlaying = false;
		else whitePlaying = true;
	}
	
}
