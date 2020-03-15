package com.leetcode.dp;

public class UniquePathsII {


    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
     * （在下图中标记为“Finish”）。现在考虑网格中有障碍物。
     * 那么从左上角到右下角将会有多少条不同的路径？问总共有多少条不同的路径？
     * 链接：https://leetcode-cn.com/problems/unique-paths
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid==null||obstacleGrid.length<1) return 0;

        int m=obstacleGrid.length,n=obstacleGrid[0].length;

        if(m==1||n==1) return obstacleGrid[0][0]==0?1:0;
        int[][] dps = new int[m][n];
        dps[0][0]=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dps[i][j]=0;
                }else{
                    if(i-1>=0&&j-1<0){
                        dps[i][j] = dps[i - 1][j];
                    }else if(j-1>=0&&i-1<0){
                        dps[i][j] = dps[i][j - 1];
                    }else if(i-1>=0&&j-1>=0){
                        dps[i][j] = dps[i][j - 1] + dps[i - 1][j];
                    }
                }
            }
        }
        return dps[m-1][n-1];
    }

    public static void main(String[] args) {


        UniquePathsII paths = new UniquePathsII();

        int[][]grids={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(paths.uniquePathsWithObstacles(grids));
    }
}
