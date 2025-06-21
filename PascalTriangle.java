import java.util.ArrayList;
import java.util.List;

public class PascalTriangle{
    //Brute Force
    // public static void main(String[] args) {
        
  
    // int numRows=5;
    // List<List<Integer>> list=new ArrayList<>();
    // for(int i=0;i<numRows;i++){
    //     List<Integer> row=new ArrayList<>();
    //     for(int j=0;j<=i;j++){
    //         if(j==0 || j==i){
    //             row.add(1);
    //         } else {
    //             int value = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
    //             row.add(value);
    //         }
    //     }
    //     list.add(row);
    // }
    // System.out.println(list);
    // }

    //if asked to return the value at a specific row and column//(n-1)C(r-1)
    // public void NcrMethod(int n,int r){
    //     long res=1;
    //     for(int i=0;i<r;i++){
    //         res=res*(n-i)/(i+1);
    //     }
    // }
    //if asked to return the value of the nth row
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long value = 1; // Start with the first element which is always 1
        for (int i = 0; i <= rowIndex; i++) {
            row.add((int) value);
            value = value * (rowIndex - i) / (i + 1); // Calculate the next value using nCr formula
        }
        return row;
    }
    public static void main(String[] args) {
        int numRows = 5;
        for(int i=0; i < numRows; i++) {
            List<Integer> row = getRow(i);
            System.out.println(row);
        }
    }
}

