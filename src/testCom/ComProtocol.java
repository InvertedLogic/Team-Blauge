package testCom;

import java.awt.List;

public class ComProtocol {

	public String reqChangeAttrByID(int id, String attr, String value, int timeStamp) {
		String str = null;
		str = "changeAttrByID("+id+","+attr+","+value+","+timeStamp+")";
		return str;
	}
	
	public Request valChangeAttrByID(String str) {
		Request l = null;
		String s = str.split("\\(")[1];
		String id = s.split("\\,")[0];
		String attr = s.split("\\,")[1];
		String val = s.split("\\,")[2];
		s = s.split("\\,")[3];
		String time = s.substring(0, s.length()-1);
		
		l = new Request(Integer.valueOf(id), attr, val, Integer.valueOf(time));
		
		return l;
	}
}
