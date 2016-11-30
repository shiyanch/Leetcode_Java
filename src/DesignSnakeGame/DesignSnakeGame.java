package DesignSnakeGame;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 353. Design Snake Game
 *
 * Design a Snake game that is played on a device with screen size = width x height.
 * Play the game online if you are not familiar with the game.
 *
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * You are given a list of food's positions in row-column order.
 * When a snake eats the food, its length and the game's score both increase by 1.
 *
 * Each food appears one by one on the screen.
 * For example, the second food will not appear until the first food was eaten by the snake.
 *
 * When a food does appear on the screen,
 * it is guaranteed that it will not appear on a block occupied by the snake.
 */

public class DesignSnakeGame {
    //2D position info is encoded to 1D and stored as two copies
    private final Set<Integer> set; // this copy is good for fast loop-up for eating body case
    private final Deque<Integer> body; // this copy is good for updating tail
    private int score;
    private final int[][] food;
    private int foodIndex;
    private final int width;
    private final int height;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        set.add(0); //intially at [0][0]
        body = new LinkedList<>();
        body.offerLast(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        //case 0: game already over: do nothing
        if (score == -1) {
            return -1;
        }

        // compute new head
        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;
        switch (direction) {
            case "U" : rowHead--;
                break;
            case "D" : rowHead++;
                break;
            case "L" : colHead--;
                break;
            default :  colHead++;
        }
        int head = rowHead * width + colHead;

        //case 1: out of boundary or eating body
        set.remove(body.peekLast()); // new head is legal to be in old tail's position, remove from set temporarily
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }

        // add head for case2 and case3
        set.add(head);
        body.offerFirst(head);

        //case2: eating food, keep tail, add head
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(body.peekLast()); // old tail does not change, so add it back to set
            foodIndex++;
            return ++score;
        }

        //case3: normal move, remove tail, add head
        body.pollLast();
        return score;
    }

    public static void main(String[] args) {
        int[][] food = {{2,0}, {0,0}, {0,2}, {0,1}, {2,2}, {0,1}};
        DesignSnakeGame snakeGame = new DesignSnakeGame(3,3, food);
        String moves = "DDRUULDRRULLDRU";
        for (char c : moves.toCharArray()) {
            System.out.println(snakeGame.move("" + c));
        }
    }
}
