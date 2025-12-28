package BitManipulation;

public class XorTillN {
    public static void main(String[] args) {
        //N%4=1 -> result=1
        //N%4=2 -> result=N+1
        //N%4=3 -> result=0
        //N%4=0 -> result=N
        //TC -> O(1) SC->O(1)
        int n = 13;
        if (n % 4 == 1) {
            System.out.println(1);
        } else if (n % 4 == 2) {
            System.out.println(n + 1);
        } else if (n % 4 == 3) {
            System.out.println(0);
        } else {
            System.out.println(n);
        }
    }
    
    //if you want to go for xor from l to r
    //then xor from 1->(l-1) and then 1->r and then xor those two , 
    // as N xor N is 0, they will end up having xor from l to r
}
