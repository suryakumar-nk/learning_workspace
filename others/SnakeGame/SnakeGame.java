package others.SnakeGame;

import java.util.Scanner;

public class SnakeGame {

    public void start() {
        var grid = new Grid();
        Scanner sc = new Scanner(System.in);
        boolean status = true;
        System.out.println("\n\n\nThe snake Head is @ and use ['U','D','R','L'] for movement");        
        while (status) {
            grid.printGrid();
            System.out.print("Enter the Direction: ");
            String d = sc.next();
            status = switch (d) {
                case "U" -> grid.moveUp();    
                case "D" -> grid.moveDown();
                case "R" -> grid.moveRight();
                case "L" -> grid.moveLeft();     
                default -> printDefault();
            };
        }
        sc.close();
    }

    private boolean printDefault() {
        System.out.println("Enter the correct Direction ['U','D','R','L']");
        return true;
    }
    
    public static void main(String[] args) {
        var snakeGame = new SnakeGame();
        snakeGame.start();
    }
}


// System.out.println("Enter the correct Direction ['U','D','R','L']")