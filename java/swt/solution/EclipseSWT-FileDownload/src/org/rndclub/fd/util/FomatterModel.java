package org.rndclub.fd.util;

import java.util.Calendar;

public class FomatterModel {// implements AmsTableInterface {
	public final static int DEFAULT_TIME_UNIT = 1000;

	public FomatterModel() {
	}

	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		int yyyy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;
		int dd = cal.get(Calendar.DAY_OF_MONTH);

		String date = "" + yyyy;
		if (mm >= 10) {
			date += mm;
		} else {
			date += "0" + mm;
		}
		if (dd >= 10) {
			date += dd;
		} else {
			date += "0" + dd;
		}

		return (date);
	}

	public static String getCurrentTime(boolean milli) {
		Calendar cal = Calendar.getInstance();
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		int mm = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);

		String time = "";
		if (hh >= 10) {
			time += hh;
		} else {
			time += "0" + hh;
		}
		if (mm >= 10) {
			time += mm;
		} else {
			time += "0" + mm;
		}
		if (ss >= 10) {
			time += ss;
		} else {
			time += "0" + ss;
		}
		if (milli == true) {
			int msec = cal.get(Calendar.MILLISECOND);
			if (msec < 10) {
				time += "00" + msec;
			} else if (msec < 100) {
				time += "0" + msec;
			} else {
				time += msec;
			}
		}

		return (time);
	}

	public static String getNumberWithComma(int num) {
		StringBuffer strBuf = new StringBuffer();
		String str = "" + num;
		for (int i = 1, n = str.length() - 1; n >= 0; i++, n--) {
			strBuf.insert(0, str.charAt(n));
			if ((i % 3 == 0) && (n > 0)) {
				strBuf.insert(0, ',');
			}
		}

		return strBuf.toString();
	}

	public static String getTimeStr(long time, String delim) {
		StringBuffer strBuf = new StringBuffer();

		// int msec = (int)(time % 1000);
		time = time / 1000;
		int sec = (int) (time % 60);
		time = time / 60;
		int min = (int) (time % 60);
		int hour = (int) (time / 60);

		if (hour < 10) {
			strBuf.append("0" + hour);
		} else {
			strBuf.append("" + hour);
		}
		strBuf.append(delim);
		if (min < 10) {
			strBuf.append("0" + min);
		} else {
			strBuf.append("" + min);
		}
		strBuf.append(delim);
		if (sec < 10) {
			strBuf.append("0" + sec);
		} else {
			strBuf.append("" + sec);
		}

		return (strBuf.toString());
	}

	public static void main(String[] args) {
		LoggerModel.enable(true);
		LoggerModel.stdout(true);

		LoggerModel.logln(FomatterModel.getCurrentDate());
		LoggerModel.logln(FomatterModel.getCurrentTime(false));
		LoggerModel.logln(FomatterModel.getCurrentTime(true));
		LoggerModel.logln(FomatterModel.getNumberWithComma(1));
		LoggerModel.logln(FomatterModel.getNumberWithComma(10));
		LoggerModel.logln(FomatterModel.getNumberWithComma(100));
		LoggerModel.logln(FomatterModel.getNumberWithComma(1000));
		LoggerModel.logln(FomatterModel.getNumberWithComma(10000));
	}
}
