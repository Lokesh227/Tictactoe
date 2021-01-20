import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
       static ArrayList<Integer> Playerposition = new ArrayList<Integer>();
       static ArrayList<Integer> Cpuposition = new ArrayList<Integer>();

       public static void PrintGameboard(char [][] gameboard) {
			for(char[] row : gameboard) {
				for(char c :row) {
					System.out.print(c);
				}
				System.out.println();
			}
     }
	public static void main(String[] args) {
		char [][]gameboard= {{' ','|',' ','|',' '},
					{'-','+','-','+','-'},
					{' ','|',' ','|',' '},
					{'-','+','-','+','-'},
					{' ','|',' ','|',' '}};  
	
       PrintGameboard(gameboard);
       while(true) {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the posistion (1-9)");
      
       int PlayerPos =sc.nextInt();
       while(Playerposition.contains(PlayerPos)||Cpuposition.contains(PlayerPos))
       {
    	   System.out.println("Position is already taken..!");
    	   PlayerPos =sc.nextInt();
       }
       if(PlayerPos >0 && PlayerPos <10) {
       PlacePiece(gameboard, PlayerPos,"Player");
       }
       else
       {
    	   System.out.println("Enter valid value");
    	   PlayerPos =sc.nextInt();
    	   PlacePiece(gameboard, PlayerPos,"Player");
       }
       
       String result=CheckWinner();
       if(result.length() > 0) {
           System.out.println(result);
           break;
           }
     
      
       Random ram=new Random();
       
    	   int pos=ram.nextInt(9)+1;
    	   while(Playerposition.contains(pos)||Cpuposition.contains(pos))
           {
    		    pos=ram.nextInt(9)+1;
           }
    	
       PlacePiece(gameboard,pos,"Cpu");
       
       PrintGameboard(gameboard);
       
       result= CheckWinner();
       if(result.length() > 0) {
       System.out.println(result);
         break;
       }
       }    
	}
   public static void PlacePiece(char [][]gameboard,int pos,String user) {
	   char symbol=' ';
	   if(user.equals("Player")) {
		   symbol='X';
		   Playerposition.add(pos);
	   }
	   else if(user.equalsIgnoreCase("Cpu")) {
		   symbol='O';
		   Cpuposition.add(pos);
	   }
		   
       switch(pos) {
	       case 1:
	    	   gameboard[0][0]=symbol;
	    	   break;
	       case 2:
	    	   gameboard[0][2]=symbol;
	    	   break;
	       case 3:
	    	   gameboard[0][4]=symbol;
	    	   break;
	       case 4:
	    	   gameboard[2][0]=symbol;
	    	   break;
	       case 5:
	    	   gameboard[2][2]=symbol;
	    	   break;
	       case 6:
	    	   gameboard[2][4]=symbol;
	    	   break;
	       case 7:
	    	   gameboard[4][0]=symbol;
	    	   break;
	       case 8:
	    	   gameboard[4][2]=symbol;
	    	   break;
		   case 9 :
			   gameboard[4][4]=symbol;
			   break;
			default :
			   break;  
       }
     
   }
   public static String CheckWinner() {
	   List toprow=Arrays.asList(1,2,3);
	   List midrow=Arrays.asList(4,5,6);
	   List botrow=Arrays.asList(7,8,9);
	   List topcolm=Arrays.asList(1,4,7);
	   List midcolm=Arrays.asList(2,5,8);
	   List botcolm=Arrays.asList(3,6,8);
	   List cross1=Arrays.asList(1,5,9);
	   List cross2=Arrays.asList(7,5,3);
	   
	   List<List> Winning=new ArrayList<List>();
       Winning.add(toprow);
       Winning.add(midrow);
       Winning.add(botrow);
       Winning.add(topcolm);
       Winning.add(midcolm);
       Winning.add(botcolm);
       Winning.add(cross1);
       Winning.add(cross2);
       for(List l:Winning) {
    	   if(Playerposition.containsAll(l)) {
    		   return "You won..!:)";
    	   }
    	   else if(Cpuposition.containsAll(l)) {
    		   return "Cpu won..!Sorry..:(";
    	   }
    	   else if(Playerposition.size()+Cpuposition.size()==9) {
    		   return "CAT:";
       }
    		   
       }
       
       
       return "";
   }
	
}
