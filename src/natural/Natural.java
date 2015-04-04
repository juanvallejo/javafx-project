package natural;

import java.util.Comparator;
import java.util.List;

public class Natural implements Comparable<Natural>{
	int natural;
	List<Natural>naturals;
	public Natural(int i){
		//try{
			if(i>=0){
			natural=i;
			}else{
				throw new RuntimeException(); 
			}
		//}catch(Exception e){
		//	System.out.println("Input was not a natural number");
		//}
	}
	public int intValue(){
		return natural;
	}
	public static Comparator<Natural> comparatorByNumber() {

		// TODO Auto-generated method stub
		Comparator <Natural> number_compare=new Comparator<Natural>(){
	        public int compare(Natural o1, Natural o2) {
	            return o1.compareTo(o2);
	        }
		};
		return number_compare;
	}

	public static Comparator<Natural> comparatorByAlpha() {
		// TODO Auto-generated method stub
		Comparator <Natural> alpha_compare=new Comparator<Natural>(){
	        public int compare(Natural o1, Natural o2) {
	        	return o1.toString().compareTo(o2.toString());
	        }
	    };
		return alpha_compare;
	}
	@Override
	public boolean equals(Object o){
		if(this.intValue()==((Natural) o).intValue()){//i get the feeling this won't work
			return true;
		}
		return false;
		
	}
	@Override
	public String toString(){
		return ""+natural;	
	}
	public int compareTo(Natural one) {//probably have this backwards
		if(this.intValue()>one.intValue()){
			return 1;
		}
		if(this.intValue()<one.intValue()){
			return -1;
		}
		return 0;
	}
	
	

}
