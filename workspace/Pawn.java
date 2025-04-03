//Name: Anthony
//Piece: Pawn
//Description: Can move one square forward, or two squares if on the starting column. Captures forward diagnaolly. 
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
public class Pawn extends Piece{
    
    public Pawn(boolean isWhite, String img_file) {
        super (isWhite, img_file);
    }

    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    //Pre-Condition: Takes into two argument, the board itself alongside the starting square for the piece. User must click on this piece.
    //Post-condition: Returns a list of tiles which the piece we are currently looking at controls.
    public ArrayList<Square> getControlledSquares(Square [][] board, Square start) {
      ArrayList<Square> tile = new ArrayList<Square>(); 
      boolean color = !start.getOccupyingPiece().getColor();
      if (color == true){
      if(start.getCol() != 7){
        tile.add(board[start.getRow() - 1][start.getCol() + 1]);
        }
      if (start.getCol() != 0){
        tile.add(board[start.getRow() - 1][start.getCol() - 1]);
      }
    }
      if (color == false){
        if(start.getCol() != 7){
          tile.add(board[start.getRow() + 1][start.getCol() + 1]);
          }
        if (start.getCol() != 0){
          tile.add(board [start.getRow() + 1][start.getCol() - 1]);
        }
      }
      return tile;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    //Pre-Condition: Takes in the board itself, alongside the starting square of the piece. This piece must be a pawn. User must click on this piece.
    //Post-Condition: Will return a list of legal moves, which from the current postion the pawn can move to.
  
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      ArrayList<Square> tile = new ArrayList<Square>(); 
      boolean color = !start.getOccupyingPiece().getColor();
      if(color == true){
      //if moving for the first time 
      int potential = start.getRow();
      potential = potential - 1;
      if(b.getSquareArray()[potential][start.getCol()].isOccupied() == false){
        tile.add(b.getSquareArray()[potential][start.getCol()]);
        }
      if (start.getRow() == 6){
        potential = potential - 1;
        if(b.getSquareArray()[potential][start.getCol()].isOccupied() == false){
          tile.add(b.getSquareArray()[potential][start.getCol()]);
          }
      }
      if (start.getCol() != 0 && b.getSquareArray()[start.getRow() - 1][start.getCol() - 1].isOccupied() && b.getSquareArray()[start.getRow() - 1][start.getCol() - 1].getOccupyingPiece().getColor() != false) {
          tile.add(b.getSquareArray()[start.getRow() - 1][start.getCol() - 1]);
      }
      if (start.getCol() != 7 && b.getSquareArray()[start.getRow() - 1][start.getCol() + 1].isOccupied() && b.getSquareArray()[start.getRow() - 1][start.getCol() + 1].getOccupyingPiece().getColor() != false) {
        tile.add(b.getSquareArray()[start.getRow() - 1][start.getCol() + 1]);
    }
      
    }
    if(color == false){
      //if moving for the first time
      int potential = start.getRow();
      potential = potential + 1;
      if(b.getSquareArray()[potential][start.getCol()].isOccupied() == false){
        tile.add(b.getSquareArray()[potential][start.getCol()]);
        }
      if (start.getRow() == 1){
        potential = potential + 1;
        if(b.getSquareArray()[potential][start.getCol()].isOccupied() == false){
          tile.add(b.getSquareArray()[potential][start.getCol()]);
          }
      }
      if (start.getCol() != 0 && b.getSquareArray()[start.getRow() + 1][start.getCol() - 1].isOccupied() && b.getSquareArray()[start.getRow() + 1][start.getCol()- 1].getOccupyingPiece().getColor() != true) {
        tile.add(b.getSquareArray()[start.getRow() + 1][start.getCol() - 1]);
    }
    if (start.getCol() != 7 && b.getSquareArray()[start.getRow() + 1][start.getCol() + 1].isOccupied() && b.getSquareArray()[start.getRow() + 1][start.getCol() + 1].getOccupyingPiece().getColor() != true) {
      tile.add(b.getSquareArray()[start.getRow() + 1][start.getCol() + 1]);
  }
    }
    
    return tile;
  }
  //Pre-condition: A pawn is moved
  //Post-condtion: Returns a string, stating the color of the pawn which just moved. 
  public String toString(){
    
    return "A " + this.getColor() + " pawn";
  }
}