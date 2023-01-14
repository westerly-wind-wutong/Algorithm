package edu.B_分治法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/14 01:14
 * @Version 1.0
 * @Description: 棋盘覆盖问题
 */
public class B5_棋盘覆盖问题 {
    static int[][] board = new int[100][100];
    static int t = 0;
    public static void main(String[] args) {
        ChessBoard(0,0,2,2,4);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
                System.out.print(board[i][j]+" ");
            System.out.println();;
        }
        System.out.println();;
    }
    public static void  ChessBoard(int tr, int tc, int dr, int dc, int size)
    {
        int s, t1;
        if (size == 1) return;                  //棋盘只有一个方格且是特殊方格
        t1 = ++t;    // L型骨牌编号
        s = size/2;                          // 划分棋盘
        if (dr < tr + s && dc < tc + s)           //特殊方格在左上角子棋盘中
            ChessBoard(tr, tc, dr, dc, s);          //递归处理子棋盘
        else{               //用 t 号L型骨牌覆盖右下角，再递归处理子棋盘
            board[tr + s - 1][tc + s - 1] = t1;
            ChessBoard(tr, tc, tr+s-1, tc+s-1, s);
        }
        if (dr < tr + s && dc >= tc + s)          //特殊方格在右上角子棋盘中
            ChessBoard(tr, tc+s, dr, dc, s);        //递归处理子棋盘
        else {               //用 t 号L型骨牌覆盖左下角，再递归处理子棋盘
            board[tr + s - 1][tc + s] = t1;
            ChessBoard(tr, tc+s, tr+s-1, tc+s, s);
        }
        if (dr >= tr + s && dc < tc + s)         //特殊方格在左下角子棋盘中
            ChessBoard(tr+s, tc, dr, dc, s);       //递归处理子棋盘
        else {              //用 t 号L型骨牌覆盖右上角，再递归处理子棋盘
            board[tr + s][tc + s - 1] = t1;
            ChessBoard(tr+s, tc, tr+s, tc+s-1, s);
        }
        if (dr >= tr + s && dc >= tc + s)        //特殊方格在右下角子棋盘中
            ChessBoard(tr+s, tc+s, dr, dc, s);      //递归处理子棋盘
        else {              //用 t 号L型骨牌覆盖左上角，再递归处理子棋盘
            board[tr + s][tc + s] = t1;
            ChessBoard(tr+s, tc+s, tr+s, tc+s, s);
        }
    }
}
