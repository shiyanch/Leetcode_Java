package SquirrelSimulation;

/**
 * 573. Squirrel Simulation
 *
 * There's a tree, a squirrel, and several nuts.
 * Positions are represented by the cells in a 2D grid. Y
 * our goal is to find the minimal distance for the squirrel to collect all the nuts
 * and put them under the tree one by one.
 *
 * The squirrel can only take at most one nut at one time and can move in four directions
 * - up, down, left and right, to the adjacent cell.
 *
 * The distance is represented by the number of moves.
 */
public class SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int s1 = 0;int max = Integer.MIN_VALUE;
        for(int[]nut :nuts){
            int treeToNut = distance(tree,nut);
            int squrToNut = distance(squirrel,nut);
            s1 += 2 * treeToNut;
            max = Math.max(max,treeToNut-squrToNut);
        }
        return s1 - max;
    }

    private int distance(int[] a1, int[] a2){
        return Math.abs(a1[0]-a2[0])+Math.abs(a1[1]-a2[1]);
    }
}
