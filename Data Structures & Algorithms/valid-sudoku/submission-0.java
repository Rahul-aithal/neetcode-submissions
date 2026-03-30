class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> row = new HashMap<Integer,HashSet<Character>>();
        HashMap<Integer,HashSet<Character>> col = new HashMap<Integer,HashSet<Character>>();
        HashMap<List<Integer>,HashSet<Character>> sqr = new HashMap<List<Integer>,HashSet<Character>>();

for(int i=0;i<9;i++){
    HashSet<Character> set  = new HashSet<Character>();
    row.put(i,set);
   
    }
    for(int i=0;i<9;i++){
    HashSet<Character> set  = new HashSet<Character>();
    col.put(i,set);
   
    }
    for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
    HashSet<Character> set  = new HashSet<Character>();
    List<Integer> list = new ArrayList<Integer>();
    list.add(i);
    list.add(j);
    sqr.put(list,set);
            }
    }

    for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                    if(board[i][j]=='.'){
                        continue;
                    }
                List<Integer> list = new ArrayList<Integer>();
                list.add(i/3);
                list.add(j/3); 
   System.out.println(i+" "+j);
                    System.out.println(board[i][j]);
                    System.out.println(
                         row.get(i).contains(board[i][j]) 
                    );
                      System.out.println(
                    col.get(j).contains(board[i][j])
                    );
                      System.out.println(
                    sqr.get(list).contains(board[i][j]) 
                    );
                if(
                    row.get(i).contains(board[i][j]) ||
                    col.get(j).contains(board[i][j]) ||
                    sqr.get(list).contains(board[i][j])                
                ){
                 

                    return false;
                }else{
                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    sqr.get(list).add(board[i][j]);

                }
            }
    }
    return true;
    }
}
