//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//    Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//
//
//    An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//    Note: m and n will be at most 100.
//
//    Example 1:
//
//    Input:
//    [
//    [0,0,0],
//    [0,1,0],
//    [0,0,0]
//    ]
//    Output: 2
//    Explanation:
//    There is one obstacle in the middle of the 3x3 grid above.
//    There are two ways to reach the bottom-right corner:
//    1. Right -> Right -> Down -> Down
//    2. Down -> Down -> Right -> Right

import java.util.Arrays;

public class P63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int l = Math.min(obstacleGrid.length, obstacleGrid[0].length);
        for (int i = 0; i<obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < l ; i++) {
            paths(obstacleGrid, i, i);
            for (int j = i + 1; j < obstacleGrid.length; j ++) {
                paths(obstacleGrid, j, i);
            }
            for (int j = i + 1; j < obstacleGrid[0].length; j ++) {
                paths(obstacleGrid, i, j);
            }
            System.out.println("================");
            System.out.println(Arrays.deepToString(obstacleGrid));
        }

        if (obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == -1 ) {
            return 0;
        } else {
            return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
        }
    }


    private static void paths(int[][] obstacleGrid, int row, int col) {
        if (obstacleGrid[row][col] == -1) {
            return;
        }
        if (row == 0 && col == 0) {
             obstacleGrid[0][0] = 1;
        } else if (row == 0) {
            if (obstacleGrid[row][col-1] != -1) {
                obstacleGrid[row][col] += obstacleGrid[row][col-1];
            } else {
                obstacleGrid[row][col] = -1;
            }
        } else if (col == 0) {
            if (obstacleGrid[row-1][col] != -1) {
                obstacleGrid[row][col] += obstacleGrid[row-1][col];
            } else {
                obstacleGrid[row][col] = -1;
            }
        } else {
            if (obstacleGrid[row-1][col] != -1) {
                obstacleGrid[row][col] += obstacleGrid[row-1][col];
            }
            if (obstacleGrid[row][col-1] != -1) {
                obstacleGrid[row][col] += obstacleGrid[row][col-1];
            }
        }
    }
}
