package test;

import model.*;

public class testing {
	// Graphtesting
	public static void main(String[] args) {
		Statusliste list = new Statusliste();
		Status toDo = new Status("toDo");
		Status doing = new Status("doing");
		Status finished = new Status("finished");
		Status start = new Status("start");
		list.insertStatus(start);
		list.insertStatus(doing);
		list.insertStatus(finished);
		list.insertBetween(toDo, start, doing);
		
		System.out.println(list.getAll());
	}
}
