
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TestDSA {

    //brute Force
//     public static void main(String[] args) {
        
//     int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//     int rows=matrix.length;
//     int columns=matrix[0].length;

//     for(int i=0;i<rows;i++){
//         for(int j=0;j<columns;j++){
           
//             System.out.print(" "+matrix[i][j]);
            
//         }
//         System.out.println();
//     }


//     for(int i=0;i<rows;i++){
//         for(int j=0;j<columns;j++){
//             if(matrix[i][j]==0){
//                 markRow(i,matrix);
//                 markColumn(j,matrix);
//                 //break;
//             }
//         }
//     }

//     for(int i=0;i<rows;i++){
//         for(int j=0;j<columns;j++){
//             if(matrix[i][j]==-1){
//                 matrix[i][j]=0;
//             }
//         }
//     }
    
//     for(int i=0;i<rows;i++){
//         for(int j=0;j<columns;j++){
           
//             System.out.print(" " +matrix[i][j]);
         
//         }
//         System.out.println();
//     }

// }

// static void markRow(int i, int[][] matrix){
//     for(int j=0;j<matrix[0].length;j++){
//         if(matrix[i][j]!=0){
//             matrix[i][j]=-1;
//         }
//     }
// }
// static void markColumn(int j, int[][] matrix){
//     for(int i=0;i<matrix.length;i++){
//         if(matrix[i][j]!=0){
//             matrix[i][j]=-1;
//         }
//     }
//     }


//better One
//     public static void main(String[] args) {
        
//      int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//      int rows=matrix.length;
//      int columns=matrix[0].length;
//      int[] arrRow=new int[rows];
//      int[] arrColumn=new int[columns];

//      for(int i=0;i<rows;i++){
//         for(int j=0;j<columns;j++){
           
//             System.out.print(" "+matrix[i][j]);
            
//        }
//         System.out.println();
//      }
//      for(int i=0;i<rows;i++){
//          for(int j=0;j<columns;j++){
//              if(matrix[i][j]==0){
//                 arrRow[i]=1;
//                 arrColumn[j]=1;
//                  //break;
//              }
//          }
//      }

//      for(int i=0;i<rows;i++){
//          for(int j=0;j<columns;j++){
//             if(arrRow[i] ==1 || arrColumn[j]==1){
//                 matrix[i][j]=0;
//             }
//          }
//     }

//      for(int i=0;i<rows;i++){
//          for(int j=0;j<columns;j++){
           
//              System.out.print(" "+matrix[i][j]);
            
//         }
//          System.out.println();
//     }
// }

//Optimal Approach
public static void main(String[] args) {
        
    int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    int col0=1;
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            System.out.print(" "+matrix[i][j]);
       }
         System.out.println();
      }

    for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[0].length;j++){
              if(matrix[i][j]==0){
                if(j!=0){
                 matrix[0][j]=0;
                }
                else{
                 col0=0;
                }
                 matrix[i][0]=0;
                }
          }
       }
   
   for(int i=matrix.length-1;i>0;i--){
         for(int j=matrix[0].length-1;j>0;j--){
            if(matrix[0][j]==0 || matrix[i][0]==0){
                matrix[i][j]=0;
            }
          }
    }
    if(matrix[0][0]==0){
        for(int j=0;j<matrix[0].length;j++){
            matrix[0][j]=0;
        }
    }
    if(col0==0){
        for(int i=0;i<matrix.length;i++){
            matrix[i][0]=0;
        }
    }

    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            System.out.print(" "+matrix[i][j]);
       }
         System.out.println();
      }


}

}
