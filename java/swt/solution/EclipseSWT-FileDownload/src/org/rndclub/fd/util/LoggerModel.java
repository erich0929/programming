package org.rndclub.fd.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerModel {
	private static File fileLoggerRoot = null;

	private static PrintWriter fout = null;

	private static long logCount = 0;

	private static boolean stdout = false;

	private static boolean enable = false;
	private static String dir = null;

	public static void setDir(String dir) {
		LoggerModel.dir = dir;
	}

	public static void init() {
		if (enable == false) {
			return;
		}
		create();
	}

	public static boolean create() {
		try {
			if (fileLoggerRoot == null) {
				if (dir != null) {
					fileLoggerRoot = new File(dir);
				} else {
					fileLoggerRoot = new File("D:\\Temp");
				}
				System.out.println("fileLoggerRoot : " + fileLoggerRoot);
				if (!fileLoggerRoot.exists()) {
					System.out.println("if (!fileLoggerRoot.exists())");
					fileLoggerRoot.mkdir();
				}
			}

			String datetime = FomatterModel.getCurrentDate() + "-"
					+ FomatterModel.getCurrentTime(false);
			String filename = "lgepis-logs-" + datetime + ".dat";
			File fileRecord = new File(fileLoggerRoot, filename);
			FileWriter fwriter = new FileWriter(fileRecord);

			fout = new PrintWriter(fwriter);

			return true;
		} catch (IOException e) {
			enable = false;
			e.printStackTrace();
		}
		return false;
	}

	public static void log(Exception e) {
		if ((enable == false) || (e == null)) {
			return;
		}

		if (fout == null) {
			if (create() == false) {
				return;
			}
		}

		e.printStackTrace(fout);
		fout.flush();

		if (stdout == true) {
			e.printStackTrace(System.out);
		}

		logCount++;
	}

	public static void log(String title, String msg) {
		if ((enable == false) || (msg == null)) {
			return;
		}

		if (fout == null) {
			if (create() == false) {
				return;
			}
		}

		msg = "[" + logCount + "] [" + title + "] " + msg;
		fout.println(msg);
		fout.flush();

		if (stdout == true) {
			LoggerModel.logln(msg);
		}

		logCount++;
	}

	public static void logln(String msg) {
		if ((enable == false) || (msg == null)) {
			return;
		}

		if (fout == null) {
			if (create() == false) {
				return;
			}
		}

		fout.println(msg);
		fout.flush();

		if (stdout == true) {
			System.out.println(msg);
		}

		logCount++;
	}

	public static void log(String msg) {
		if ((enable == false) || (msg == null)) {
			return;
		}

		if (fout == null) {
			if (create() == false) {
				return;
			}
		}

		fout.print(msg);
		fout.flush();

		if (stdout == true) {
			System.out.print(msg);
		}
	}

	public static void close() {
		if (fout != null) {
			fout.close();
		}
	}

	public static void stdout(boolean flag) {
		stdout = flag;
	}

	public static boolean getStdout() {
		return stdout;
	}

	public static void enable(boolean flag) {
		enable = flag;
	}

	public static boolean getEnable() {
		return enable;
	}

	public static void test() {
		stdout(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoggerModel.test();
	}
}
