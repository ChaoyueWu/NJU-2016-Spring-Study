/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
*/
/*
【解析】

思路：动态规划

用一个二维数组ans[][]表示到每个格子时，勇士到每一步时至少需要的魔力，如ans[i][j]表示勇士在[i, j]处至少需要ans[i][j]魔力才能到达[m, n]救出皇后。

技巧：从[m, n]往回遍历到[1, 1]

动规方程：如果当前位置魔力正且大于等于右边/下边需要的魔力，则该处不需要额外的魔力，否则，勇士到达该处时需有一定的魔力来满足该处和右边/下边需要的魔力。
*/
public class Solution {  
    public int calculateMinimumHP(int[][] dungeon) {  
        int m = dungeon.length;  
        int n = dungeon[0].length;  
          
        int[][] ans = new int[m][n];  
          
        //初始化最后一行和最后一列  
        ans[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 0 : -dungeon[m - 1][n - 1];  
        for (int i = m - 2; i >= 0; i--) {  
            ans[i][n - 1] = dungeon[i][n - 1] >= ans[i + 1][n - 1] ? 0 : ans[i + 1][n - 1] - dungeon[i][n - 1];  
        }  
        for (int j = n - 2; j >= 0; j--) {  
            ans[m - 1][j] = dungeon[m - 1][j] >= ans[m - 1][j + 1] ? 0 : ans[m - 1][j + 1] - dungeon[m - 1][j];  
        }  
          
        //从右下角往左上角遍历  
        for (int i = m - 2; i >= 0; i--) {  
            for (int j = n - 2; j >= 0; j--) {  
                int down = dungeon[i][j] >= ans[i + 1][j] ? 0 : ans[i + 1][j] - dungeon[i][j];  
                int right = dungeon[i][j] >= ans[i][j + 1] ? 0 : ans[i][j + 1] - dungeon[i][j];  
                ans[i][j] = Math.min(down, right);  
            }  
        }  
          
        //要保证勇士活着，至少需要1魔力  
        return ans[0][0] + 1;  
    }  
}  
/*
解题思路：动态规划。
求从右下角到左上角需要的hp值。
dp[i][j]表示从(i,j)这个位置到达右下角需要的最小hp值
dungeon[i][j]表示这个位置的格子的数值
dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j+1]) - dungeon[i][j])
[cpp]
*/
#include <vector>  
#include <cmath>  
  
using namespace std;  
  
class Solution {  
public:  
    int calculateMinimumHP(vector<vector<int> > &dungeon) {  
         if(dungeon.empty())  
          return 0;  
        vector<vector<int> > dp(dungeon.size());  
        for(int i = 0; i < dp.size(); i++) {  
            dp[i].reserve(dungeon[i].size());  
        }  
        int m = dungeon.size();  
        int n = dungeon[0].size();  
        if(dungeon[m - 1][n - 1] >= 0) {  
            dp[m - 1][n - 1] = 1;  
        } else {  
            dp[m - 1][n - 1] = 1 - dungeon[m - 1][n - 1];  
        }  
  
        for(int i = m - 2; i >= 0; i--) {  
            dp[i][n - 1] = max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);  
        }  
        for(int j = n - 2; j >= 0; j--) {  
            dp[m - 1][j] = max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);  
        }  
        for(int i = m - 2; i >= 0; i--) {  
            for(int j = n - 2; j >= 0; j--) {  
                dp[i][j] = max(min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);  
            }  
        }  
  
        return dp[0][0];  
        }  
      
}; 
//上面两种（一种java解法，一种cpp解法，都是从后往前推导）
/*
bit几乎所有人的一种解法
采用递归+动态规划的方法
从前往后一步一步走
*/
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        Integer[][] arr = new Integer[dungeon.length][dungeon[0].length];

        return calculate(dungeon, 0, 0, arr);
    }

    // return the min HP from (i, j) to the end (dungeon.length-1, dungeon[0].length-1)
    private int calculate(int[][] dungeon, int i, int j, Integer[][] arr) {
        if (arr[i][j] != null)
            return arr[i][j];

        if (dungeon.length-1==i && dungeon[0].length-1==j) {
            arr[i][j] = Math.max(1, -dungeon[i][j]+1);
            return arr[i][j];
        }

        int fromRow = Integer.MAX_VALUE;
        if (i<dungeon.length-1) {
            int past = calculate(dungeon, i+1, j, arr);
            fromRow = Math.max(1, past-dungeon[i][j]);
        }
        
        int fromCol = Integer.MAX_VALUE;
        if (j<dungeon[0].length-1) {
            int past = calculate(dungeon, i, j+1, arr);
            fromCol = Math.max(1, past-dungeon[i][j]);
        }

        arr[i][j] = Math.min(fromRow, fromCol);
        return arr[i][j];
    }
}