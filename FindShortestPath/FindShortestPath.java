public class FindShortestPath {
    public static void main(String[] args) {
        int[][]m = new int[4][4];
        m[0][1] = 1;
//        m[1][2] = 1;
        m[2][2] = 1;
        findNumPossiblePaths(m, 4, 4);
        System.out.println("find number of paths " + count);
//        Assetions.assertEquals(count, 4);
    }



    public static int count =0;
    public static int findNumPossiblePaths(int[][] m, int mr, int mc) {
        traverse(m, mc, mr, 0, 0);
        return count;
    }

    public static void traverse(int[][] m, final int mc, final int mr, int x, int y) {
        if(x == mc-1 && y == mr-1) {
            count++;
            return ;
        }
        if(canMoveRight(m, mc, x, y)) {
            traverse(m, mc, mr, x+1, y);
        }
        if(canMoveDown(m, mr, x, y)) {
            traverse(m, mc, mr, x, y+1);
        }

    }

    public static boolean canMoveRight(int[][] m, int mc, int x, int y) {
        if(x>=mc-1){
            return false;
        } else {
            return !(m[x+1][y] == 1);
        }
    }
    public static boolean canMoveDown(int[][] m, int mr, int x, int y) {
        if(y>=mr-1){
            return false;
        } else {
            return !(m[x][y+1] == 1);
        }
    }
}
