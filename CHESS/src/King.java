
public class King extends Piece {
	
	boolean initialLocation = true;
	
	public King(int color, Square location) {
		super(color, location);
	}
	
	@Override
	 public boolean canMove(String to) {
		boolean validMove = false;
		Square targetLocation = location.getBoard().getSquareAt(to);
		int rowDistance = targetLocation.getRowDistance(location);
		int colDistance = targetLocation.getColDistance(location);
		if(this.location.isAtSameColumn(targetLocation)) {
			if(rowDistance == 1 || rowDistance == -1) {
				validMove = (targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color);
			}
		} else if(this.location.isNeighborColumn(targetLocation)) {
			if(colDistance == 1 || colDistance == -1) {
				validMove = (targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color);
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
		return color == ChessBoard.WHITE ? "K" : "k";
	}
}
