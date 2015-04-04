package natural;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Utility {

	public static Natural findMinimum(ArrayList<Natural> list) {
		Collections.sort(list, Natural.comparatorByNumber());
		return list.get(0);
	}

	public static Natural findMaximum(ArrayList<Natural> list) {
		Collections.sort(list, Natural.comparatorByNumber());
		return list.get(list.size()-1);
	}

	public static Natural findMinimum(ArrayList<Natural> list,
			Comparator <Natural> compare) {
		Natural zero=new Natural(11);
		Natural one=new Natural(2); 
		int x=compare.compare(zero, one);
		
		if(x>0){
			Collections.sort(list,Natural.comparatorByNumber());
		}else{
			Collections.sort(list, Natural.comparatorByAlpha());
		}
		return list.get(0);
	}

	public static Natural findMaximum(ArrayList<Natural> list,
			Comparator <Natural> compare) {
		Natural zero=new Natural(11);
		Natural one=new Natural(2); 
		int x=compare.compare(zero, one);
		
		if(x>0){
			Collections.sort(list,Natural.comparatorByNumber());
		}else{
			Collections.sort(list, Natural.comparatorByAlpha());
		}
		return list.get(list.size()-1);
	}

}
