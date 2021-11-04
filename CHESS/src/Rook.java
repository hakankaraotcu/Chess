
public class Rook extends Piece {
	
	boolean initialLocation = true;
	
	public Rook(int color, Square location) {
		super(color, location);
	}
	
	@Override
	public boolean canMove(String to) {
		boolean validMove = false;
		Square targetLocation = location.getBoard().getSquareAt(to);
		int rowDistance = targetLocation.getRowDistance(location);
		int colDistance = targetLocation.getColDistance(location);
		if (this.location.isAtSameColumn(targetLocation)) {
			if (rowDistance > 0 && rowDistance <= 8) {
				if(rowDistance == 1) {
					validMove = targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color;
				}
				else if(initialLocation) {
					Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
					validMove = (targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color) && (between[0].isEmpty() && between[1].isEmpty() && between[2].isEmpty() && between[3].isEmpty() && between[4].isEmpty() && between[5].isEmpty() && between[6].isEmpty());
				}
				return validMove;
			} else if (rowDistance < 0 && rowDistance >= -8) {
				if(rowDistance == -1) {
					validMove = targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color;
				}
				else if(initialLocation) {
					Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
					validMove = (targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color) && (between[0].isEmpty() && between[1].isEmpty() && between[2].isEmpty() && between[3].isEmpty() && between[4].isEmpty() && between[5].isEmpty() && between[6].isEmpty());
				}
			}
		} else if (this.location.isNeighborColumn(targetLocation) && location.getRow() == targetLocation.getRow()) {
			if (colDistance > 0 && colDistance <= 8) {
				if(colDistance == 1) {
					validMove = targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color;
				}
				else if(initialLocation) {
					Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
					validMove = (targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color) && (between[0].isEmpty() && between[1].isEmpty() && between[2].isEmpty() && between[3].isEmpty() && between[4].isEmpty() && between[5].isEmpty() && between[6].isEmpty());
				}
				return validMove;
			} else if (colDistance < 0 && colDistance >= -8) {
				if(colDistance == -1) {
					validMove = targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color;
				}
				else if(initialLocation) {
					Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
					validMove = (targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color) && (between[0].isEmpty() && between[1].isEmpty() && between[2].isEmpty() && between[3].isEmpty() && between[4].isEmpty() && between[5].isEmpty() && between[6].isEmpty());
				}
			}
		}
		return validMove;
	}
	
	@Override
	public void move(String to) {
		Square targetLocation = location.getBoard().getSquareAt(to);
		targetLocation.setPiece(this);
		location.clear();
		location = targetLocation;
		location.getBoard().nextPlayer();
	}
	@Override
	public String toString() {
		return color == ChessBoard.WHITE ? "R" : "r";
	}
}
