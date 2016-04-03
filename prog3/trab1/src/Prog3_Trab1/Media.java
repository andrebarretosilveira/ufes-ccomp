package Prog3_Trab1;

import java.io.Serializable;

abstract class Media implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int NOTWATCHED = 0;
	public static final int WATCHED = 1;
	public static final int WANT = 2;
	private long mediaId;
	private int mediaTypeId = 0;
	private boolean[] consumptionStatus = new boolean[3];
	private Loan loan;
	private double price = 0;
	private String name;
	private Genre genre;
	
	public Media(long mediaId,int mediaTypeId,String name,Genre genre) {
		this.mediaId = mediaId;
		this.name = name;
		this.mediaTypeId = mediaTypeId;
		this.genre = genre;
	}
	
	public final long getMediaId() {
		return mediaId;
	}
	public final int getMediaTypeId() {
		return mediaTypeId;
	}
	public final boolean getConsumptionStatus(int consumptionStatusType) {
		if(consumptionStatusType >= 0 && consumptionStatusType <= 2) {
			return this.consumptionStatus[consumptionStatusType];
		}
		return false;
	}
	public final Loan getLoan() {
		return loan;
	}
	public final double getPrice() {
		return price;
	}
	public final String getName() {
		return name;
	}
	public final Genre getGenre() {
		return genre;
	}
	
	public final void setLoan(Loan loan) {
		this.loan = loan;
	}
	public final void setPrice(double price) {
		this.price = price;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final void setGenre(Genre genre) {
		this.genre = genre;
	}
	public final void setConsumptionStatus(int consumptionStatusType,boolean value) {
		if(consumptionStatusType >= 0 && consumptionStatusType <= 2) {
			this.consumptionStatus[consumptionStatusType] = value;
		}
	}

	
}
