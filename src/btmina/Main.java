package btmina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] grid = new String[3][3];
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            grid[i][0] = grid[i][1] = grid[i][2] = " ";
            System.out.println("| " + grid[i][0] + " " + grid[i][1] +" " + grid[i][2] + " |");
        }
        System.out.println("---------");
        boolean won = false;
        int a, y;
        int turn = 0;
        while(!won){
            boolean acceptable = false;
            boolean free = false;
            while(!acceptable || !free){
                System.out.println("Enter the coordinates:");
                a = scanner.nextInt();
                y = scanner.nextInt();
                if(a > 3 || y > 3 || a < 1 || y < 1){
                    System.out.println("Coordinates should be from 1 to 3!");
                }
                else{
                    acceptable = true;
                    if((grid[a-1][y-1].equals(" "))){
                        free = true;
                        if(turn % 2 == 0)
                            grid[a-1][y-1] = "X";
                        else
                            grid[a-1][y-1] = "O";
                        System.out.println("---------");
                        for(int i = 0; i < 3; i++){

                            System.out.println("| " + grid[i][0] + " " + grid[i][1] +" " + grid[i][2] + " |");
                        }
                        System.out.println("---------");
                        turn++;
                    }

                    else{
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            }
            if(turn >= 5){
                String winner = null;
                for(int i = 0; i < 3; i++){
                    if (grid[i][0].equals(grid[i][1]) && grid[i][0].equals(grid[i][2]) && !(grid[i][0].equals(" "))) {
                        winner = grid[i][0];
                        won = true;
                    }
                }
                for(int j = 0; j < 3; j = j + 1){
                    if(grid[0][j].equals(grid[1][j]) && grid[0][j].equals(grid[2][j]) && !(grid[2][j].equals(" "))){
                        winner = grid[0][j];
                        won = true;
                    }
                }
                if((grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2])) || grid[0][2].equals(grid[1][1]) && grid[0][2].equals(grid[2][0]) && !(grid[1][1].equals(" ")) ){
                    winner = grid[1][1];
                    won = true;
                }
                if(winner == null && turn == 9){
                    System.out.println("Draw");
                    won = true;
                }
                else if(won) {
                    System.out.println(winner + " wins");
                    won = true;
                }
            }
        }
        scanner.close();
    }
}


