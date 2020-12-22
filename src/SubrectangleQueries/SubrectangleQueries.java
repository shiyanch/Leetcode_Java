package SubrectangleQueries;

import java.util.ArrayList;
import java.util.List;

/**
 * 1476. Subrectangle Queries
 *
 * Implement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of integers in the constructor and supports two methods:
 *
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *
 * Updates all values with newValue in the subrectangle whose upper left coordinate is (row1,col1) and bottom right coordinate is (row2,col2).
 * 2. getValue(int row, int col)
 *
 * Returns the current value of the coordinate (row,col) from the rectangle.
 */
public class SubrectangleQueries {
    private final List<Operation> operations = new ArrayList<>();
    private final int[][] initialRectangle;
    public SubrectangleQueries(int[][] rectangle) {
        initialRectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        operations.add(new Operation(row1, col1, row2, col2, newValue));
    }

    public int getValue(int row, int col) {
        int value = initialRectangle[row][col];
        for (Operation operation : operations) {
            if (hasBeenUpdated(row, col, operation)) {
                value = operation.newValue;
            }
        }
        return value;
    }

    private boolean hasBeenUpdated(int row, int col, Operation operation) {
        return operation.row1 <= row && row <= operation.row2 && operation.col1 <= col && col <= operation.col2;
    }

    private static class Operation {
        int row1, col1, row2, col2, newValue;
        Operation(int row1, int col1, int row2, int col2, int newValue) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.newValue = newValue;
        }
    }
}
