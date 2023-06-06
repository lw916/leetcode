class Solution {
    public int equalPairs(int[][] grid) {
        int result = 0;
        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid.length; j++ ){
                int k =0;
                while( k < grid.length ){
                    if(grid[i][k] == grid[k][j]){
                        k++;
                        if(k == grid.length - 1){
                            result++;
                            break;
                        }else{
                            continue;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return result;
    }

    // 哈希表解题思路
    // 把矩阵放入哈希表
    // 首先将矩阵的行放入哈希表中统计次数，哈希表的键可以是将行拼接后的字符串，也可以用各语言内置的数据结构，然后分别统计每一列相等的行有多少，求和即可。
    public int equalPairs2(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<List<Integer>, Integer>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr.add(grid[i][j]);
            }
            if (cnt.containsKey(arr)) {
                res += cnt.get(arr);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[][] grid = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(S.equalPairs(grid));
    }
}

