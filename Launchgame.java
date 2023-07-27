package Tictactoe;
import java.util.Scanner;

class TicTacToe {
	// using static we can able access the variable in any other class in java.
	 static char[][] board;
	
	public TicTacToe() {
		board =new char [3][3];
		// /u0000  unicode followed by java as it was null character.
		initBoard();
	}
	void initBoard()
{
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]= ' ';
		      }
	       }
		}
	 void dispBoard() {
		System.out.println("*************");		
		for(int i=0;i<board.length;i++) 
		{
			System.out.print("|  ");
			
			for(int j=0;j<board[i].length;j++) {
			 System.out.print(board[i][j] + "|  ");
		      }
			System.out.println(" ");
			System.out.println("*************");
	       }
	}
	// using static we can able access the variable in any other class in java.
	static void placeMark(int row, int col, char mark ) {
		if(row >=0 && row <=2  && col >=0 && col <=2 ) {
			board[row][col]= mark;
			}
		else {
			System.out.println("Invalid position");
		}
	}
	
	// using static keyword we can call the function without creating a object where we can use the class
	static boolean checkColwin() {
    	for(int j=0;j<=2; j++) {
    		if(board[0][j]!= ' ' && board[0][j ]== board[1][j] && board[1][j] == board[2][j]  ) {
    			return true;
    		}
    	}
        return false;
    }

   static  boolean checkRowwin() {
    	for(int i=0;i<=2; i++ ) {
    		if(board[i][0]!= ' ' && board[i][0]== board[i][1] && board[i][1] == board[i][2]  ) {
    			return true;
    		}
    	}
         return false;
    }

   static  boolean checkDiagwin() {
    		if(board[0][0]!= ' ' && board[0][0]== board[1][1] && board[1][1] == board[2][2] 
    				|| board[0][2]!= ' ' && board[0][2]== board[1][1] && board[1][1]== board[2][0]) {
    			return true;
    		}else {
    		return false;
         }
    }
   static boolean checkDraw() {
	   for(int i=0;i<=2;i++) {
		   for(int j=0;j<=2;j++) {
			   if(board[i][j]== ' ') {
				   return false;
			   }
		   }
	   }
	   return true;
   }

}




class humanPlayer{
	String name;
	char mark ;
	
	humanPlayer(String name,char mark)
{
		this.name =name;
		this.mark =mark;
		
		}
	void makeMove() {
		Scanner scan =new Scanner (System.in);
		int row;
		int col;
		do {
			
			System.out.println("enter the position");
			row = scan.nextInt();
			col = scan.nextInt();
			if(TicTacToe.board[row][col]!= ' ') {
				System.out.println("dei olunga aduda... (invalid move) ");
			}
			
		}while(!validMove(row,col));
		TicTacToe.placeMark(row,col,mark);
		
	}
	
	boolean validMove(int row ,int col) {
		   if(row >=0 && row <=2  && col >=0 && col <=2 ) {
			   if(TicTacToe.board[row][col]==' ') {
				   return true;
			   }
		   }
		   return false;		
	}
}


public class Launchgame {

	public static void main(String[] args) {
            TicTacToe t =new TicTacToe();
            t.dispBoard();
           humanPlayer p1= new humanPlayer ("karthick",'X');
           humanPlayer p2= new humanPlayer ("kavi",'O');   
           humanPlayer cp ;
           // reference type assignment an object in java can have multiple references, so we can assign an object with multiple object in class.
           cp =p1;
          while(true) {
        	  System.out.println(cp.name +" turn ");
              cp.makeMove();
              t.dispBoard();
              if(TicTacToe.checkColwin() ||TicTacToe.checkRowwin() || TicTacToe.checkDiagwin()) {
              	System.out.println(cp.name +" has won");
              	break;
              }else if(TicTacToe.checkDraw()) {
            	  System.out.println(" match is draw");
            	  break;
              }
              if (cp==p1){
                         cp = p2;         
              }else {
              	cp = p1;
              }          
          }
	      
	}

}













