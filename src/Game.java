public class Game {

    static int[] board = new int[9];
    public static void main(String[] args) throws Exception {
        int n = 1 ;
        for(int i=0 ; i<9 ; i++){
            board[i] = n ;
            n++ ;
        }
        
        printBoard();
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
}
