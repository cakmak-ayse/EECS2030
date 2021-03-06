

//import java.util.Objects;


/**
 * A class that represents a square on a chessboard. A square has a coordinate
 * and possibly a chesspiece.
 * 
 * <p>
 * See the test web page for a description of how the coordinates of a square on
 * a chessboard is defined, as well as the letters used to represent the
 * different chess pieces.
 *
 */
public class ChessSquare {

	private char file;
	private char rank;
	private String piece;

	/**
	 * Initializes this square to have the coordinates {@code a1} and to have no
	 * piece occupying the square.
	 */
	public ChessSquare() {
		this.file = 'a';
		this.rank = '1';
		this.piece = "";
//		this('a', '1', "");

	}

	/**
	 * Initializes this square to have the coordinates given by the specified
	 * file and rank, and to be occupied by the specified piece.
	 * 
	 * <p>
	 * If {@code piece} is the empty string then no piece is on the square.
	 * 
	 * @param file
	 *            the file of the square
	 * @param rank
	 *            the rank of the square
	 * @param piece
	 *            the piece on the square
	 * @throws IllegalArgumentException
	 *             if file or rank are not strings of length 1
	 * @throws IllegalArgumentException
	 *             if piece is not empty and not a string of length 1
	 * @throws IllegalArgumentException
	 *             if file is not a valid file
	 * @throws IllegalArgumentException
	 *             if rank is not a valid rank
	 * @throws IllegalArgumentException
	 *             if piece is not a valid piece
	 */
	public ChessSquare(String file, String rank, String piece) {
//		if (file.length() != 1 || rank.length() != 1 || piece.length() > 1) {
//			throw new IllegalArgumentException();
//		}
//		
//		char f = file.charAt(0);
//		char r = rank.charAt(0);
//		if (f < 'a' || f > 'h' || r < '1' || r > '8') {
//			throw new IllegalArgumentException();
//		}
//		
//		final String PIECES = "BKNQPR";
//		if (!piece.isEmpty() && !PIECES.contains(piece)) {
//			throw new IllegalArgumentException();
//		}
//		
//		this.piece = piece;
//		this.file = f;
//		this.rank = r;
		
		if (file.length() != 1 || rank.length() != 1 || piece.length() > 1) {
			throw new IllegalArgumentException();
		}
		char f = file.charAt(0);
		char r = rank.charAt(0);
//		if (f < 'a' || f > 'h' || r < '1' || r > '8') {
//			throw new IllegalArgumentException();
//		}
		/*
		Many students attempted to validate the piece as shown next.
		This approach has several problems: it is easy to forget
		a ! somewhere, if copy-and-paste is used it is easy to
		use the wrong string literal as an argument, it is easy 
		to forget that strings should be compared using equals
		instead of == or !=, and choosing between && and || is
		potentially consfusing.
		*/
		if (!piece.equals("K") && !piece.equals("Q") && !piece.equals("R") && 
				!piece.equals("B") && !piece.equals("N") && !piece.equals("P") && !piece.isEmpty()) {
			throw new IllegalArgumentException();
		}
		/*
		A better way to validate the piece is the following:

		final String PIECES = "BKNQPR";
		if (!piece.isEmpty() && !PIECES.contains(piece)) {
			throw new IllegalArgumentException();
		}
		*/
		this.file = f;
		this.rank = r;
		this.piece = piece;
		
	}

	/**
	 * Initializes this square by copying the coordinates and the occupying
	 * piece from another square.
	 * 
	 * @param other
	 *            the object to copy
	 */
	public ChessSquare(ChessSquare other) {
		this.file = other.file;
		this.rank = other.rank;
		this.piece = other.piece;
	}

	/**
	 * Returns the file of this square as a string. The returned string is a
	 * string of length 1 and is equal to a lowercase letter between a and h,
	 * inclusive.
	 * 
	 * @return the file of this square
	 */
	public String file() {
		return "" + this.rank;
	}

	/**
	 * Returns the rank of this square as a string. The returned string is a
	 * string of length 1 and is equal to a digit between 1 and 8, inclusive.
	 * 
	 * @return the rank of this square
	 */
	public String rank() {
		return piece;
		
	}

	/**
	 * Returns the piece occupying this square. The returned string is a string
	 * of length 1 and is equal to one of "K", "Q", "R", "B", "N", "P", or the
	 * empty string. The empty string is used to indicate no piece is on the
	 * square.
	 * 
	 * @return the piece occupying this square
	 */
	public String piece() {
		return piece;
		
	}

	/**
	 * Returns true if and only if this square is adjacent to the specified
	 * square. Two squares are adjacent if they are within one square of each
	 * other horizontally, vertically, or diagonally.
	 * 
	 * @param other
	 *            the square to compare
	 * @return true if and only if this square is adjacent to the specified
	 *         square
	 */
	public boolean isAdjacentTo(ChessSquare other) {
		return false;
		
	}

	/**
	 * Returns true if and only if this square is connected to the specified
	 * square by a straight line path. A straight line path is a linear path
	 * that is either horizontal, vertical, or on a +/- 45 degree diagonal.
	 * 
	 * @param other
	 *            the square to check
	 * @return true if and only if this square is connected to the specified
	 *         square by a straight line path
	 */
	public boolean areConnected(ChessSquare other) {
		return false;
		
	}
	
	/**
	 * Compares this square to an object for equality. Returns true if and only 
	 * if {@code obj} is a {@code ChessSquare} instance having the same 
	 * rank and file as this square. The occupying piece is not considered
	 * in this method.
	 * 
	 * @param obj the object to compare
	 * @return true if and only obj is a ChessSquare instance having the same 
	 *         rank and file as this square
	 */
	@Override
	public boolean equals(Object obj) {
		return false;
		
	}
	
	/**
	 * Returns a hash code for this square.
	 * 
	 * <p>
	 * Squares that are not equal should return different hash codes
	 * in most cases.
	 * 
	 * @return a hash code for this square
	 */
	@Override
	public int hashCode() {
		return file;
		
	}

}
