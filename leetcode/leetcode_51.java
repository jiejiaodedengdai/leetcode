class Solution {



    List<List<String>> result = new  ArrayList<>() ;

    public List<List<String>> solveNQueens(int n) {

        char[][] chessBoard = new char[n][n];
       for (int i = 0; i < n; i++) {
        Arrays.fill(chessBoard[i], '.'); // 给每一行填充 '.'
        }

        dfs( chessBoard , 0 , n);

        return result;
        
    }


    private void dfs( char[][] chessBoard , int row , int n){
        
        if( row == n ){
            result.add( changeArray( chessBoard) );
            return ;
        }

        for(int col = 0 ;  col < n ; col++){
            
            chessBoard[row][col] = 'Q';
            if( !valid(row , col , chessBoard , n) )
            {
                chessBoard[row][col] = '.';
                continue;
            }
            dfs(chessBoard , row + 1 , n);
            chessBoard[row][col] = '.';
        }

    }

    private List<String> changeArray( char[][] chessBoard ){
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < chessBoard.length ; i++){
            StringBuilder tmp = new StringBuilder();
            for(int j = 0 ; j < chessBoard[i].length ; j++){
                tmp.append( chessBoard[i][j] );
            }
            list.add( tmp.toString() );
        }
        return list;

    }

    private boolean valid( int row , int col ,  char[][] chessBoard , int n){
        
        for(int i = row - 1 ; i >= 0 ; i--){
            if( chessBoard[i][col] == 'Q'){
                return false;
            }
        }

        for(int i = row -1  , j = col - 1 ; j >= 0 && i>= 0 ; i--, j--)
        {
            if( chessBoard[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row - 1 , j = col + 1; j < n && i >= 0 ; i-- , j++ ){
            if( chessBoard[i][j] == 'Q'){
                return false;
            }

        }

        return true;
    }





}