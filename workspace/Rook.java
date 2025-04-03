//Spencer Gilcrest
//This Piece is a Rook
//The Piece can move straight in all 4 directions for any distance, but cannot move past other peices
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Rook extends Piece{
    
    public Rook(boolean isWhite, String img_file) {
        super(isWhite, img_file);
    }

    public String toString(){
      boolean checkColor = this.getColor();
      String result;
      if (checkColor){
        result = "A White Rook";
      }
      else {
        result = "A Black Rook";
      }
      return result;
        
    }
        
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.

    //pre condition: board is 2d array of squares. start is a square and been initialized.
    //post condition: returns arrayList of squares that the piece could theorhetically capture into on the next move
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
     ArrayList<Square> controlledSquares = new ArrayList<>();
    int boardSize = board.length;
    int startRow = start.getRow();
    int startCol = start.getCol();

    for (int row = startRow - 1; row>=0;  row--){
      controlledSquares.add(board[row][startCol]);
      if (board[row][startCol].getOccupyingPiece() != null){
        break;
      }
    }

    for (int row = startRow + 1; row<boardSize;  row++){
      controlledSquares.add(board[row][startCol]);
      if (board[row][startCol].getOccupyingPiece() != null){
        break;
      }
    }

    for (int col = startCol - 1; col>=0; col--){
      controlledSquares.add(board[startRow][col]);
      if (board[startRow][col].getOccupyingPiece() != null){
        break;
      }
    }

    for (int col = startCol + 1; col < boardSize; col++){
      controlledSquares.add(board[startRow][col]);
      if (board[startRow][col].getOccupyingPiece() != null){
        break;
      }
    }
    return controlledSquares;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    //pre condition: b is of type board and has been properly initialized. start is of type square and has been properly initialized.
    //post condition: returns arrayList of possible moves such that the piece moves like a rook. moves straight in all 4 directions and cannot pass over other pieces. 
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      ArrayList<Square> legalMoves = new ArrayList<>();
      int currentRow = start.getRow();
      int currentCol = start.getCol();

      Square[][] board  = b.getSquareArray();
      int boardSize = board.length;

      boolean isWhite = this.getColor();

      for (int col = currentCol + 1; col < boardSize; col++){
        Square tempSquare = board[currentRow][col];
        if (tempSquare.getOccupyingPiece() == null){
          legalMoves.add(tempSquare);
        }
        else {
          if(tempSquare.isOccupied() && tempSquare.getOccupyingPiece().getColor() != isWhite){
            legalMoves.add(tempSquare);
          }
          break;
        }
      }

      for (int col = currentCol - 1; col >=0; col--){
        Square tempSquare = board[currentRow][col];
        if (tempSquare.getOccupyingPiece() == null){
          legalMoves.add(tempSquare);
        }
        else {
          if(tempSquare.isOccupied() && tempSquare.getOccupyingPiece().getColor() != isWhite){
            legalMoves.add(tempSquare);
          }
          break;
        }
      }

      for (int row = currentRow - 1; row >= 0; row--){
        Square tempSquare = board[row][currentCol];
        if (tempSquare.getOccupyingPiece() == null){
          legalMoves.add(tempSquare);
        }
        else{
          if (tempSquare.isOccupied() && tempSquare.getOccupyingPiece().getColor() != isWhite){
            legalMoves.add(tempSquare);
          }
          break;
        }
      }

      for (int row = currentRow + 1; row < boardSize; row++){
        Square tempSquare = board[row][currentCol];
        if (tempSquare.getOccupyingPiece() == null){
          legalMoves.add(tempSquare);
        }
        else{
          if (tempSquare.isOccupied() && tempSquare.getOccupyingPiece().getColor() != isWhite){
            legalMoves.add(tempSquare);
          }
          break;
        }
      }
      return legalMoves;
    }
}