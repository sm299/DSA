package General;

public class PowerExponentiation {
    public static void main(String[] args) {
        power(10, 21);
    }

    
    public static void power(double x, int n) {
        double res=1;
        int n1=n;
        n=Math.abs(n);
        if(x==1 || x==0){
            System.out.println( x);
        }
        if(n1<=Integer.MIN_VALUE && x>0){
            System.out.println(0);
        }

        if(n1<=Integer.MIN_VALUE && x<0){
            System.out.println ((n%2==0)?1:-1);
        }
        while(n!=0){
            if(n%2==0){
                n=n/2;
                x=x*x;
            }else{
                res=res*x;
                n=n-1;
            }
        }
    
        System.out.println ((n1>0)?res:(1/res));
    }

        //System.out.println("Result : "+res);
    }
