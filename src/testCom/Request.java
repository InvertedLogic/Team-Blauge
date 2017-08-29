package testCom;

public class Request {
	int id;
	String attr;
	String value;
	int timeStamp;

	Request(int id, String attr, String value, int timeStamp) {
		this.id = id;
		this.attr = attr;
		this.value = value;
		this.timeStamp = timeStamp;
	}

}
