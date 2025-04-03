//Noam Barak-Medina

//Queen
//moves in all directions, straight and diagonally. Can't skip over pieces.
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Queen extends Piece{

    
    public Queen(boolean isWhite, String img_file) {
    	super(isWhite, img_file);
    }
    @Override
    public String toString() {
    	return "A " + super.toString() + " Queen";
    }

    
   
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece could move there legally.
    @Override
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
    	ArrayList<Square> legalSquares = new ArrayList<>();
    	int posRow = start.getRow();
    	int posCol = start.getCol();
    	//Right (east)
    	for(int i = 1; posCol + i <= 7; i++){
    		if(board[posRow][posCol+i].isOccupied()) {
    			System.out.println("occupied");
    			legalSquares.add(board[posRow][posCol+i]);
    			break;
    		} else {
    			legalSquares.add(board[posRow][posCol+i]);
    		}
    	}
    	//Left (west)
    	for(int i = 1; posCol - i >= 0; i++){
    		if(board[posRow][posCol-i].isOccupied()) {
    			System.out.println("occupied");
    			legalSquares.add(board[posRow][posCol-i]);
    			break;
    		} else {
    			legalSquares.add(board[posRow][posCol-i]);
    		}
    	}
    	//Down (South)
    	for(int i = 1; posRow + i <= 7; i++){
    		if(board[posRow+i][posCol].isOccupied()) {
    			System.out.println("occupied");
    			legalSquares.add(board[posRow+i][posCol]);
    			break;
    		} else {
    			legalSquares.add(board[posRow+i][posCol]);
    		}
    	}
    	//Up (north)
    	for(int i = 1; posRow - i >= 0; i++){
    		if(board[posRow-i][posCol].isOccupied()) {
    			System.out.println("occupied");
    			legalSquares.add(board[posRow-i][posCol]);
    			break;
    		} else {
    			legalSquares.add(board[posRow-i][posCol]);
    		}
    	}
    	//South-East
    	for(int i = 1; (posRow + i <= 7)&&(posCol + i <= 7); i++){
    		if(board[posRow+i][posCol+i].isOccupied()) {
    			System.out.println("occupied");
    			legalSquares.add(board[posRow+i][posCol+i]);
    			break;
    		} else {
    			legalSquares.add(board[posRow+i][posCol+i]);
    		}
    	}
    	//South-West
    	for(int i = 1; (posRow + i <= 7)&&(posCol - i >= 0); i++){
    		if(board[posRow+i][posCol-i].isOccupied()) {
    			System.out.println("occupied");
    			legalSquares.add(board[posRow+i][posCol-i]);
    			break;
    		} else {
    			legalSquares.add(board[posRow+i][posCol-i]);
    		}
    	}
    	//North-West
    	for(int i = 1; (posRow - i >= 0)&&(posCol - i >= 0); i++){
    		if(board[posRow-i][posCol-i].isOccupied()) {
    			System.out.println("occupied");
    			legalSquares.add(board[posRow-i][posCol-i]);
    			break;
    		} else {
    			legalSquares.add(board[posRow-i][posCol-i]);
    		}
    	}
    	//North-East
    	for(int i = 1; (posRow - i >= 0)&&(posCol + i <= 7); i++){
    		if(board[posRow-i][posCol+i].isOccupied()) {
    			System.out.println("occupied");
    			legalSquares.add(board[posRow-i][posCol+i]);
    			break;
    		} else {
    			legalSquares.add(board[posRow-i][posCol+i]);
    		}
    	}
    	ArrayList<Square> controlledSquares = new ArrayList<Square>(legalSquares.size());
    	for(int i =0;i < controlledSquares.size(); i++) {
    		controlledSquares.set(i, legalSquares.get(i));
    	}
    	for(Square s : controlledSquares) {
    		System.out.print(s + ", ");
    	};
    	System.out.println(" ");
    	return controlledSquares;
    	
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    
    //My piece is the queen, it can move in any direction, in straight lines (upward, downward, left, right) and diagonally (NE, NW, SE, SW)
    //It cannot skip over its own or opponent pieces, but can capture enemy pieces
    @Override
    public ArrayList<Square> getLegalMoves(Board b, Square start){
    	ArrayList<Square> legalSquares = new ArrayList<>();
    	int posRow = start.getRow();
    	int posCol = start.getCol();
    	//Right (east)
    	for(int i = 1; posCol + i <= 7; i++){
    		if(b.getSquareArray()[posRow][posCol+i].isOccupied()) {
    			System.out.println("occupied");
    			
    			if(b.getSquareArray()[posRow][posCol+i].getOccupyingPiece().getColor() != getColor()) {
    				legalSquares.add(b.getSquareArray()[posRow][posCol+i]);
    				System.out.println("Test");
    				break;
    			} else {
    				break;
    			}
    		} else {
    			legalSquares.add(b.getSquareArray()[posRow][posCol+i]);
    		}
    	}
    	//Left (west)
    	for(int i = 1; posCol - i >= 0; i++){
    		if(b.getSquareArray()[posRow][posCol-i].isOccupied()) {
    			if(b.getSquareArray()[posRow][posCol-i].getOccupyingPiece().getColor() == !getColor()) {
    				legalSquares.add(b.getSquareArray()[posRow][posCol-i]);
    				break;
    			} else {
    				break;
    			}
    		} else {
    			legalSquares.add(b.getSquareArray()[posRow][posCol-i]);
    		}
    	}
    	//Down (South)
    	for(int i = 1; posRow + i <= 7; i++){
    		if(b.getSquareArray()[posRow+i][posCol].isOccupied()) {
    			if(b.getSquareArray()[posRow+i][posCol].getOccupyingPiece().getColor() == !getColor()) {
    				legalSquares.add(b.getSquareArray()[posRow+i][posCol]);
    				break;
    			} else {
    				break;
    			}
    		} else {
    			legalSquares.add(b.getSquareArray()[posRow+i][posCol]);
    		}
    	}
    	//Up (north)
    	for(int i = 1; posRow - i >= 0; i++){
    		if(b.getSquareArray()[posRow-i][posCol].isOccupied()) {
    			if(b.getSquareArray()[posRow-i][posCol].getOccupyingPiece().getColor() == !getColor()) {
    				legalSquares.add(b.getSquareArray()[posRow-i][posCol]);
    				break;
    			} else {
    				break;
    			}
    		} else {
    			legalSquares.add(b.getSquareArray()[posRow-i][posCol]);
    		}
    	}
    	//South-East
    	for(int i = 1; (posRow + i <= 7)&&(posCol + i <= 7); i++){
    		if(b.getSquareArray()[posRow+i][posCol+i].isOccupied()) {
    			if(b.getSquareArray()[posRow+i][posCol+i].getOccupyingPiece().getColor() == !getColor()) {
    				legalSquares.add(b.getSquareArray()[posRow+i][posCol+i]);
    				break;
    			} else {
    				break;
    			}
    		} else {
    			legalSquares.add(b.getSquareArray()[posRow+i][posCol+i]);
    		}
    	}
    	//South-West
    	for(int i = 1; (posRow + i <= 7)&&(posCol - i >= 0); i++){
    		if(b.getSquareArray()[posRow+i][posCol-i].isOccupied()) {
    			if(b.getSquareArray()[posRow+i][posCol-i].getOccupyingPiece().getColor() == !getColor()) {
    				legalSquares.add(b.getSquareArray()[posRow+i][posCol-i]);
    				break;
    			} else {
    				break;
    			}
    		} else {
    			legalSquares.add(b.getSquareArray()[posRow+i][posCol-i]);
    		}
    	}
    	//North-West
    	for(int i = 1; (posRow - i >= 0)&&(posCol - i >= 0); i++){
    		if(b.getSquareArray()[posRow-i][posCol-i].isOccupied()) {
    			if(b.getSquareArray()[posRow-i][posCol-i].getOccupyingPiece().getColor() == !getColor()) {
    				legalSquares.add(b.getSquareArray()[posRow-i][posCol-i]);
    				break;
    			} else {
    				break;
    			}
    		} else {
    			legalSquares.add(b.getSquareArray()[posRow-i][posCol-i]);
    		}
    	}
    	//North-East
    	for(int i = 1; (posRow - i >= 0)&&(posCol + i <= 7); i++){
    		if(b.getSquareArray()[posRow-i][posCol+i].isOccupied()) {
    			if(b.getSquareArray()[posRow-i][posCol+i].getOccupyingPiece().getColor() == !getColor()) {
    				legalSquares.add(b.getSquareArray()[posRow-i][posCol+i]);
    				break;
    			} else {
    				break;
    			}
    		} else {
    			legalSquares.add(b.getSquareArray()[posRow-i][posCol+i]);
    		}
    	}
    	System.out.println(legalSquares);				
    	return legalSquares;
    }
}