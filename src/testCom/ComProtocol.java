package testCom;

import java.awt.List;

public class ComProtocol {

	/**
	 * 
	 * @param int id -> id des zu ändernden objekts
	 * @param String attr -> zu änderndes attribut des objekts
	 * @param String value -> zu schreibender wert in das attribut
	 * @param int timeStamp -> zeitstempel der letzten aktualisierung
	 * @return String str -> anfrage von client an server
	 */
	public String reqChangeAttrByID(int id, String attr, String value, int timeStamp) {
		String str = null;
		str = "changeAttrByID(" + id + "," + attr + "," + value + "," + timeStamp + ")";
		return str;
	}

	/**
	 * 
	 * @param String str -> anfrage von client
	 * @return Request req -> objekt mit attributen der anfrage
	 */
	public Request valChangeAttrByID(String str) {
		Request req = null;
		String s = str.split("\\(")[1];
		String s1[] = s.split("\\,");
		String id = s1[0];
		String attr = s1[1];
		String val = s1[2];
		s = s1[3];
		String time = s.substring(0, s.length() - 1);

		req = new Request(Integer.valueOf(id), attr, val, Integer.valueOf(time));

		return req;
	}
}
