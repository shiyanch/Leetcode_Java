package WalkingRobotSimulation;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 874. Walking Robot Simulation
 *
 * A robot on an infinite grid starts at point (0, 0) and faces north.
 * The robot can receive one of three possible types of commands:
 *
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Some of the grid squares are obstacles.
 *
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 *
 * If the robot would try to move onto them, the robot stays on the previous grid square instead
 * (but still continues following the rest of the route.)
 *
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 *
 * Example:
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 */
public class WalkingRobotSimulation {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] currPos = {0, 0};
        int currDirectionIndex = 0;
        int maxDistanceSquare = 0;
        Set<Integer> obstaclesOnGrid = Arrays.stream(obstacles).map(this::hashPos).collect(Collectors.toSet());
        for (int command : commands) {
            if (command < 0) {
                currDirectionIndex = nextDirection(currDirectionIndex, command);
            } else {
                int steps = command;
                while (steps > 0 && !obstaclesOnGrid.contains(hashPos(nextPosition(currPos, currDirectionIndex)))) {
                    steps--;
                    currPos = nextPosition(currPos, currDirectionIndex);
                }
                // hits obstacle or finishes moving command.
                maxDistanceSquare = Math.max(maxDistanceSquare, currPos[0] * currPos[0] + currPos[1] * currPos[1]);
            }
        }
        return maxDistanceSquare;
    }

    private int nextDirection(int currentDirectionIndex, int signal) {
        int nextDirectionIndex = (currentDirectionIndex + (signal == -1 ? 1 : -1)) % DIRECTIONS.length;
        if (nextDirectionIndex < 0) {
            nextDirectionIndex += DIRECTIONS.length;
        }
        return nextDirectionIndex;
    }

    private int[] nextPosition(int[] currPos, int currDirectionIndex) {
        return new int[] {currPos[0] + DIRECTIONS[currDirectionIndex][0], currPos[1] + DIRECTIONS[currDirectionIndex][1]};
    }

    private int hashPos(int[] position) {
        return position[0] * 100000 + position[1];
    }

    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};

        System.out.println(new WalkingRobotSimulation().robotSim(commands, obstacles));
    }
}
