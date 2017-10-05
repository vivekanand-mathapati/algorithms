import java.util.*;

class SpiralTraversal {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int row_size = in.nextInt();
        int col_size = in.nextInt();
        int arr[][] = new int[row_size][col_size];
        for(int i=0;i<row_size;i++)
            for(int j=0;j<col_size;j++)
                arr[i][j] = in.nextInt();
        spiralTravers(row_size,col_size,arr);
    }
    //following method will travers a 2D array in spiral manner 
    // rs - row start
    // cs - column start
    static void spiralTravers(int re, int ce, int arr[][]){
        int i, rs = 0, cs = 0;
        while(rs < re && cs < ce){
            //display top row
            for(i=cs;i<ce;i++)
                System.out.print(arr[rs][i]+" ");
            rs++;
            //display right column
            for(i=rs;i<re;i++)
                System.out.print(arr[i][ce-1]+" ");
            ce--;
            //display bottom row
            if(rs < re){
                for(i=ce-1;i>=cs;i--)
                    System.out.print(arr[re-1][i]+" ");
                re--;
            }
            if(cs<ce){
                for(i=re-1;i>=rs;i--)
                    System.out.print(arr[i][cs]+" ");
                cs++;
            }
        }
    }
}
