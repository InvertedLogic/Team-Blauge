package model;

import java.util.regex.Pattern;

/**
 * @author Lars Raschke, Anke Withake
 *
 */
public class Datum {
	
	public int year;
	public int month;
	public int day;
	
	/**
	 * Creates a new date.
	 * @param day : the day of the date.
	 * @param month : the month of the date.
	 * @param year : the year of the date.
	 */
	public Datum(int day, int month, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/**
	 * Parses a Date into a String.
	 * @param datum : the Date to parse into a String.
	 * @return date : the given Date as a String.
	 */
	public static String toString(Datum datum){
		return(datum.day + "." + datum.month + "." + datum.year);
	}

	/**
	 * Parses a String (format: dd.mm.yyyy) into a Date.
	 * @param date : the String to Parse into a Date.
	 * @return date : the given String as a Date.
	 */
	public static Datum toDate(String date){
		String[] parse = date.split(Pattern.quote("."));
		return (new Datum(Integer.parseInt(parse[0]), Integer.parseInt(parse[1]), Integer.parseInt(parse[2]))) ;
	}

	/**
	 * Returns the days of a given month
	 * @param month : the given month
	 * @return days : the days of the given month.
	 */
	public static int monthInDays(int month){
		switch (month) {
			case 2:
				return 28;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			default:
				return 30;
		}
	}

	/**
	 * Returns the number of days between two dates.
	 * @param start : the start date.
	 * @param end : the end date.
	 * @return days : the days between start and end date.
	 */
	public static int daysBetween(Datum start, Datum end){

		int erg = 0;
		int counter = 0;
		
		if(start.getYear() == end.getYear() && start.getMonth() == end.getMonth()) {
			return(end.getDay() - start.getDay());
		}
		if(start.getYear() == end.getYear()) {
			while(start.month + counter < end.month) {
				erg += monthInDays(start.month + counter);
				counter++;
			}
			return (erg - start.day+end.day);
		}
		if(start.getYear() < end.getYear()) {
			erg = 365 * (end.getYear() - start.getYear());
			if(start.getMonth() > end.getMonth()) {
				while(end.month + counter < start.month) {
					erg -= monthInDays(end.month + counter);
					counter++;
				}
				return(erg - start.getDay() + end.getDay());
			}
			while(start.month + counter < end.month) {
				erg += monthInDays(start.month + counter);
				counter++;
			}
			return (erg - start.day + end.day);
		}
			
		return 0;
	}

	/**
	 * Getter-method for year.
	 * @return year : the year of the date.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Setter-method for year.
	 * @param year : the year of the date.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Getter-method for month.
	 * @return month : the month of the date.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Setter-method for day.
	 * @param month : the month of the date
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Getter-method for day.
	 * @return day : the day of the date.
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Setter-method for day.
	 * @param day : the day of the date.
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * checks if a date is the same as reference date.
	 * @param checkDate : the reference date to compare with.
	 * @return same : <code>true</code> if the date is the same as the reference date.
	 */
	public boolean same(Datum checkDate){
		return (this.year == checkDate.year && this.month == checkDate.month && this.day == checkDate.day);
	}
	
	/**
	 * checks if a date is after a reference date.
	 * @param checkDate : the reference date to compare with.
	 * @return after : <code>true</code> if the date is after the reference date.
	 */
	public boolean after(Datum checkDate){
		if(this.getYear() > checkDate.getYear()) {
			return true;
		}
		if(this.getYear() == checkDate.getYear() && this.getMonth() > checkDate.getMonth()) {
			return true;
		}
		if(this.getYear() == checkDate.getYear() && this.getMonth() == checkDate.getMonth() && this.getDay() > checkDate.getDay()) {
			return true;
		}
		return false;
	}
	
	/**
	 * checks if a date is after a reference date.
	 * @param checkDate : the reference date to compare with.
	 * @return before : <code>true</code> if the date is before the reference date.
	 */
	public boolean before(Datum checkDate){
		if(this.getYear() < checkDate.getYear()) {
			return true;
		}
		if(this.getYear() == checkDate.getYear() && this.getMonth() < checkDate.getMonth()) {
			return true;
		}
		if(this.getYear() == checkDate.getYear() && this.getMonth() == checkDate.getMonth() && this.getDay() < checkDate.getDay()) {
			return true;
		}
		return false;
	}
	
	public boolean between( Datum date1, Datum date2){
		return (date1.before(this) && date2.after(this))||(date1.after(this) && date2.before(this));
	}
	
}
