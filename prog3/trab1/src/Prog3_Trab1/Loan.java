package Prog3_Trab1;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.io.Serializable;
import java.util.Calendar;

final class Loan implements Comparable<Object>,Serializable {

	private static final long serialVersionUID = 1L;
	private String person;
	private Media lentMedia;
	private Date startDate;
	private Date limitReturnDate;
	private Date returnDate;
	
	public Loan(String personName,Media lent_media,Date limitReturnDate) {
		this.person = personName;
		this.limitReturnDate = limitReturnDate;
		this.returnDate = null;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		this.lentMedia = lent_media;
		lent_media.setLoan(this);
		this.startDate = calendar.getTime();
	}
	
	public Loan(String personName,Media lent_media,Date startDate,Date limitReturnDate) {
		this.person = personName;
		this.limitReturnDate = limitReturnDate;
		this.startDate = startDate;
		this.lentMedia = lent_media;
	}
	
	public String getPersonName() {
		return person;
	}
	
	public Media getLentMedia() {
		return this.lentMedia;
	}

	public Date getStartDate() {
		return startDate;
	}
	
	public boolean isReturned() {
		return this.returnDate != null;
	}
	
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	public boolean isLate() {
		if(this.limitReturnDate != null && this.returnDate != null) {
			return (this.limitReturnDate.getTime() - this.returnDate.getTime() < 0);
		}
		return false;
	}
	
	private long calculateDaysLate(Calendar calendar) {
		Date returnDate;
		if(this.isReturned()) {
			returnDate = this.returnDate;
		}
		else {
			returnDate = calendar.getTime();
		}
		long diff = this.limitReturnDate.getTime() - returnDate.getTime();
		if(diff < 0) {
			diff *= -1;
			return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		}
		return 0;
	}
	
	public long daysLate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		return calculateDaysLate(calendar);
	}
	
	public long daysLate(Calendar calendar) {
		return calculateDaysLate(calendar);
	}

	@Override
	public int compareTo(Object o) {
		Loan loan = (Loan) o;
		int compare_dates = this.startDate.compareTo(loan.getStartDate());
		if(compare_dates == 0) {
			int compare_names = this.getPersonName().compareTo(loan.getPersonName());
			return compare_names;
		}
		return compare_dates;
	}

	
}
