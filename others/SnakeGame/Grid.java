package others.SnakeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    char[][] grid;
    List<int[]> snake = new ArrayList<>();
    private void addFood() {
        var random = new Random();
        int val = 0;
        for (int i=0; i<10; i++) {
            val = random.nextInt(99)+1;
            grid[val/10][val%10] = 'F';
        }
    }

    public Grid() {
        this.grid = new char[10][10];
        addFood();
        grid[0][0] = 'F';
        grid[1][0] = '@';
        snake.add(new int[]{1,0});
    }

    private void checkFood(int[] head) {
        if (this.grid[head[0]][head[1]] == 'F') {
            this.grid[head[0]][head[1]] = '@';
            var list = new ArrayList<int[]>();
            list.add(head);
            list.addAll(snake);
            snake = list;
        } else {
            this.grid[head[0]][head[1]] = '@';
            if (snake.size() == 1) {
                this.grid[snake.get(0)[0]][snake.get(0)[1]] = '*';
                snake.clear();
                snake.add(head);
            } else {
                var list = new ArrayList<int[]>();
                list.add(head);
                var end = snake.get(snake.size()-1);
                this.grid[end[0]][end[1]] = '*';
                snake.remove(snake.size()-1);
                list.addAll(snake);
                snake = list;
            }
        }
    }

    private boolean rightLeft(int[] head) {
        if (head[1] < 0 || head[1] > 9) {
            System.out.println("Ouch You Failed :(");
            return false;
        }
        if (this.grid[head[0]][head[1]] == '@') {
            System.out.println("Ouch You Failed :(");
            return false;
        }
        checkFood(head);
        return true;
    }

    public boolean moveRight() {
        var head = snake.get(0).clone();
        head[1]++;
        return rightLeft(head);
    }

    public boolean moveLeft() {
        var head = snake.get(0).clone();
        head[1]--;
        return rightLeft(head);
    }

    private boolean upDown(int[] head) {
        if (head[0] < 0 || head[0] > 9) {
            System.out.println("Ouch You Failed :(");
            return false;
        }
        if (this.grid[head[0]][head[1]] == '@') {
            System.out.println("Ouch You Failed :(");
            return false;
        } 
        checkFood(head);
        return true;
    }

    public boolean moveDown() {
        var head = snake.get(0).clone();
        head[0]++;
        return upDown(head);
    }
    
    public boolean moveUp() {
        var head = snake.get(0).clone();
        head[0]--;
        return upDown(head);
    }

    public void printGrid() {
        int n = grid.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                var val = grid[i][j] != 'F' && grid[i][j] != '@' ? '*' : grid[i][j];
                System.out.print(val+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
