import java.util.Scanner;;
public class Game {

    static char[] board = new char[9];
    static char next = 'O' ;
    static boolean status = true ;
    public static void main(String[] args) throws Exception {
        

        
        for(int i=0 ; i<9 ; i++){
            board[i] = (char) (i + '1') ; // here it convets from ascii thats why we add '1' 
        }

        System.out.println("The first move is O :");
        while (status) {
            if(!checkWining())
            {
                System.out.println("Next to play: " + next );
                printBoard();
                int move = input();
                if(validMove(move) ){
                    board[move -1] = next ;
                    changPlay(next);
                }
            }

        }
        changPlay(next);
        System.out.println(next + " has won");
        
       
    }


    public static void printBoard(){
        int index = 0;
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(j == 2){
                    System.out.print(board[index] );
                }
                else{
                    System.out.print(board[index] + " | ");
                }
                index++ ;
            }
            if(i==2){
                System.out.println("\n");
            }
            else{
                System.out.println("\n--| --| --");
            }
            
        }
    }

    public static boolean validMove(int input){ // this method insures that the int is in range and is not already taken
        if(input > 9 || input <= 0){
            System.out.println("Enter a number between 0 => 9");
            return false ;
        }
        for(int i=0 ; i<9 ; i++){
            if(input == (int) (board[i] - '0')) return true; // here we subtracy '0' because when we type cast a char 
        }                                                    // java converts it to ascii                
        System.out.println("this move is already taken! ");
        return false;
    }

    public static int input(){ // this function takes input and insures that it is an number else itreturns -1 which will 
    // return false in the validMove methode .
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a number: ");
    String line = scan.next();
        try{
            int n = Integer.valueOf(line);
            return n;
        }
        catch(Exception e){
        System.out.println("You didnt enter a Number dummy !");
        }
        return -1 ;
    }

    public static void changPlay(char Next){
        if(Next == 'O') next = 'X';
        else next = 'O';
    }


    public static boolean checkHorizontal(){
        for(int i=0 ; i <=6 ; i+= 3){
            if(board[i] == board[i+1] && board[i] == board[i+2]) return true ;
            
        }
        return false ; 
    }


    public static boolean checkVertical(){
        for(int i=0 ; i <3 ; i++){
            if(board[i] == board[i+3] && board[i] == board[i+6]) return true ;
            
        }
        return false ; 
    }

    public static boolean checkDiagonal(){
        if(board[0] == board[4] && board[0] == board[8]) return true ;
        if(board[2] == board[4] && board[2] == board[6]) return true ;
        return false ; 
    }

    public static boolean checkWining(){
        if(checkDiagonal() || checkHorizontal() || checkVertical() ){
            System.out.println("Game over !");
            status = false ;
            return true ;
        } 
        return false ;
    }

}
