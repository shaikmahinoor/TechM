package day8;
import java.util.ArrayList;
import java.util.HashMap;

public class List{
	   	
	 public static void main(String[] args) {
		 
		 int n=10;
		 ArrayList<Integer> c= new ArrayList<Integer>();
		 c.add(1);
		 for(int i=1;i<=n;i++)
		 {
			 c.add(catalanfunc(c,i));
		 }
		 System.out.println(c);
	      	
	    	
	    }

	private static Integer catalanfunc(ArrayList<Integer> c, int z) {
		// TODO Auto-generated method stub
		
		
		int cat=0;
		for(int i=0;i<z;i++)
		{
			cat=cat+c.get(i)*c.get(z-i-1);
		}
		
				
		return cat;
	}
}

