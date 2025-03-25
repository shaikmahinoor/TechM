package day8;
import java.util.Scanner;

public class CatalanNumber {

public static long findFact(int no) {
	
	long res=1;
	for(int i =1;i<=no;i++)
		res=res*i;
	return res;		
	
}
public static long findCatalan(int n)
{
	// for no = 0 & 1, the catalan number is 1
if(n<=1)
{
return 1;
}
// Calculating 2n!
long fact=findFact(2*n);
// calculating 2nCn
fact=fact/findFact(n);
fact=fact/findFact(n);
//caculating ((1 / (n + 1))* 2nCn)  
fact = fact / (n + 1);  
return fact;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		if (num<=0)
			System.out.println("0");
		else
		{
		for(int i=0;i<num;i++)
		{
			long catlanNo=findCatalan(i);
			System.out.print(catlanNo+" ");
		}
		}
		

	}

}

