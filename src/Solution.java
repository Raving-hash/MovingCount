class Solution {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        int[][] dp = new int[m][n];
        dfs(dp, k, 0, 0);
        for (int[] ints : dp) {
            for (int i : ints) {
                if (i == 1) res++;
            }
        }
        return res;
    }

    public boolean dfs(int[][] dp, int k, int i, int j){
        if(i < 0 || i > dp.length-1 || j < 0 || j > dp[0].length-1 || dp[i][j] == 2 || dp[i][j] == 1){
            return false;
        }
        if(!qualify(i, j, k)){
            dp[i][j] = 2;
            return false;
        }else{
            dp[i][j] = 1;
        }
       boolean n = dfs(dp, k, i+1, j) ||
        dfs(dp, k, i-1, j) ||
        dfs(dp, k, i, j+1) ||
        dfs(dp, k, i+1, j-1);
        return false;
    }

    public boolean qualify(int i, int j, int k){
        int res = 0;
        while (i / 10 != 0){
            res += i % 10;
            i /= 10;
        }
        res += i;
        while (j / 10 != 0){
            res += j % 10;
            j /= 10;
        }
        res += j;
        return res <= k;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.movingCount(3, 4, 3);
        System.out.println("i = " + i);
    }

}