import java.util.Scanner;;
public class Game {

    static int[] board = new int[9];
    static char next = 'O' ;
    static boolean status = true ;
    public static void main(String[] args) throws Exception {
        

        int initial = 1 ;
        for(int i=0 ; i<9 ; i++){
            board[i] = initial ;
            initial++ ;
        }
        System.out.println("The first move is O :");
        while (status) {
            printBoard();

            if(validMove(input())){
                System.out.println("yes");
            }
            else{
                System.out.println("No");
            }
        }
        
        
       
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
            if(input == board[i]) return true;
        }
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
}
