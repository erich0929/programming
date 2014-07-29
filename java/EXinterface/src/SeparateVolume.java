package com.erich0929.www;

public class SeparateVolume implements Lendable 
{
	String requestNo;
	String bookTitle;
	String writer;
	String borrower;
	String checkOutDate;
	byte state;

	public SeparateVolume (String requestNo, String bookTitle,
					String writer)
	{
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	public void checkOut (String borrower, String date)
	{
		if (state !=0)
				return;
		this.borrower = borrower;
		this.checkOutDate = date;
		System.out.println ("*" + bookTitle + " 이(가) 대출되었습니다.\n");
		System.out.println ("대출인 : " + borrower);
		System.out.println ("대출일 : " + date + "\n");
	}

	public void checkIn ()
	{
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		System.out.println ("*" + bookTitle + " 이(가) 반납되었습니다.\n");
	}
}
				
