package HW;

import java.util.HashMap;
import java.util.Map;

public class AddRet {
	
	private Map<Integer,String> mapOne = new HashMap<>();
	
	public void add(int num, String str) {
		mapOne.put(num, str);
		
		
	}
	public String get(int num) {
		return mapOne.get(num);
		
		
	}

	

	

}
