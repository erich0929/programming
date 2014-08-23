package org.rndclub.swt.browser;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsUtil {
	static Display display = null;

	static String[] imageFileList = null;

	static Image[] images = null;

	public static int IMAGE_NUM = 0;

	public static Color COLOR_WHITE;
	public static Color COLOR_BLACK;
	public static Color COLOR_RED;
	public static Color COLOR_DARK_RED;
	public static Color COLOR_GREEN;
	public static Color COLOR_DARK_GREEN;
	public static Color COLOR_YELLOW;
	public static Color COLOR_DARK_YELLOW;
	public static Color COLOR_BLUE;
	public static Color COLOR_DARK_BLUE;
	public static Color COLOR_MAGENTA;
	public static Color COLOR_DARK_MAGENTA;
	public static Color COLOR_CYAN;
	public static Color COLOR_DARK_CYAN;
	public static Color COLOR_GRAY;
	public static Color COLOR_DARK_GRAY;

	public static Cursor CURSOR_ARROW;
	public static Cursor CURSOR_WAIT;
	public static Cursor CURSOR_CROSS;
	public static Cursor CURSOR_APPSTARTING;
	public static Cursor CURSOR_HELP;
	public static Cursor CURSOR_SIZEALL;
	public static Cursor CURSOR_SIZENESW;
	public static Cursor CURSOR_SIZENS;
	public static Cursor CURSOR_SIZENWSE;
	public static Cursor CURSOR_SIZEWE;
	public static Cursor CURSOR_SIZEN;
	public static Cursor CURSOR_SIZES;
	public static Cursor CURSOR_SIZEE;
	public static Cursor CURSOR_SIZEW;
	public static Cursor CURSOR_SIZENE;
	public static Cursor CURSOR_SIZESE;
	public static Cursor CURSOR_SIZESW;
	public static Cursor CURSOR_SIZENW;
	public static Cursor CURSOR_UPARROW;
	public static Cursor CURSOR_IBEAM;
	public static Cursor CURSOR_NO;
	public static Cursor CURSOR_HAND;

	final public static int IMAGE_ANT = IMAGE_NUM++;
	final public static int IMAGE_BIN = IMAGE_NUM++;
	final public static int IMAGE_BUG = IMAGE_NUM++;
	final public static int IMAGE_CIRCLE = IMAGE_NUM++;
	final public static int IMAGE_CLOSE = IMAGE_NUM++;
	final public static int IMAGE_ERROR = IMAGE_NUM++;
	final public static int IMAGE_FILE = IMAGE_NUM++;
	final public static int IMAGE_NOTE = IMAGE_NUM++;
	final public static int IMAGE_OPEN = IMAGE_NUM++;
	final public static int IMAGE_RUN = IMAGE_NUM++;
	final public static int IMAGE_TABLE = IMAGE_NUM++;
	final public static int IMAGE_TRACE = IMAGE_NUM++;
	final public static int IMAGE_TYPE = IMAGE_NUM++;
	final public static int IMAGE_X = IMAGE_NUM++;
	final public static int IMAGE_IDEA = IMAGE_NUM++;

	final public static int IMAGE_BACK = IMAGE_NUM++;
	final public static int IMAGE_FORWARD = IMAGE_NUM++;
	final public static int IMAGE_STOP = IMAGE_NUM++;
	final public static int IMAGE_REFRESH = IMAGE_NUM++;
	final public static int IMAGE_HOME = IMAGE_NUM++;
	final public static int IMAGE_GO = IMAGE_NUM++;

	public static void init(Display disp) {
		display = disp;

		imageFileList = new String[]{"/org/rndclub/swt/res/images/ant.png",
				"/org/rndclub/swt/res/images/bin.png",
				"/org/rndclub/swt/res/images/goldbug.png",
				"/org/rndclub/swt/res/images/circle.png",
				"/org/rndclub/swt/res/images/close.png",
				"/org/rndclub/swt/res/images/error.png",
				"/org/rndclub/swt/res/images/file.png",
				"/org/rndclub/swt/res/images/note.png",
				"/org/rndclub/swt/res/images/open.png",
				"/org/rndclub/swt/res/images/run.png",
				"/org/rndclub/swt/res/images/table.png",
				"/org/rndclub/swt/res/images/trace.png",
				"/org/rndclub/swt/res/images/type.png",
				"/org/rndclub/swt/res/images/x.png",
				"/org/rndclub/swt/res/images/idea.jpg",

				"/org/rndclub/swt/res/images/back.jpg",
				"/org/rndclub/swt/res/images/forward.jpg",
				"/org/rndclub/swt/res/images/stop.jpg",
				"/org/rndclub/swt/res/images/refresh.jpg",
				"/org/rndclub/swt/res/images/home.jpg",
				"/org/rndclub/swt/res/images/go.jpg"};

		COLOR_WHITE = display.getSystemColor(SWT.COLOR_WHITE);
		COLOR_BLACK = display.getSystemColor(SWT.COLOR_BLACK);
		COLOR_RED = display.getSystemColor(SWT.COLOR_RED);
		COLOR_DARK_RED = display.getSystemColor(SWT.COLOR_DARK_RED);
		COLOR_GREEN = display.getSystemColor(SWT.COLOR_GREEN);
		COLOR_DARK_GREEN = display.getSystemColor(SWT.COLOR_DARK_GREEN);
		COLOR_YELLOW = display.getSystemColor(SWT.COLOR_YELLOW);
		COLOR_DARK_YELLOW = display.getSystemColor(SWT.COLOR_DARK_YELLOW);
		COLOR_BLUE = display.getSystemColor(SWT.COLOR_BLUE);
		COLOR_DARK_BLUE = display.getSystemColor(SWT.COLOR_DARK_BLUE);
		COLOR_MAGENTA = display.getSystemColor(SWT.COLOR_MAGENTA);
		COLOR_DARK_MAGENTA = display.getSystemColor(SWT.COLOR_DARK_MAGENTA);
		COLOR_CYAN = display.getSystemColor(SWT.COLOR_CYAN);
		COLOR_DARK_CYAN = display.getSystemColor(SWT.COLOR_DARK_CYAN);
		COLOR_GRAY = display.getSystemColor(SWT.COLOR_GRAY);
		COLOR_DARK_GRAY = display.getSystemColor(SWT.COLOR_DARK_GRAY);

		CURSOR_ARROW = display.getSystemCursor(SWT.CURSOR_ARROW);
		CURSOR_WAIT = display.getSystemCursor(SWT.CURSOR_WAIT);
		CURSOR_CROSS = display.getSystemCursor(SWT.CURSOR_CROSS);
		CURSOR_APPSTARTING = display.getSystemCursor(SWT.CURSOR_APPSTARTING);
		CURSOR_HELP = display.getSystemCursor(SWT.CURSOR_HELP);
		CURSOR_SIZEALL = display.getSystemCursor(SWT.CURSOR_SIZEALL);
		CURSOR_SIZENESW = display.getSystemCursor(SWT.CURSOR_SIZENESW);
		CURSOR_SIZENS = display.getSystemCursor(SWT.CURSOR_SIZENS);
		CURSOR_SIZENWSE = display.getSystemCursor(SWT.CURSOR_SIZENWSE);
		CURSOR_SIZEWE = display.getSystemCursor(SWT.CURSOR_SIZEWE);
		CURSOR_SIZEN = display.getSystemCursor(SWT.CURSOR_SIZEN);
		CURSOR_SIZES = display.getSystemCursor(SWT.CURSOR_SIZES);
		CURSOR_SIZEE = display.getSystemCursor(SWT.CURSOR_SIZEE);
		CURSOR_SIZEW = display.getSystemCursor(SWT.CURSOR_SIZEW);
		CURSOR_SIZENE = display.getSystemCursor(SWT.CURSOR_SIZENE);
		CURSOR_SIZESE = display.getSystemCursor(SWT.CURSOR_SIZESE);
		CURSOR_SIZESW = display.getSystemCursor(SWT.CURSOR_SIZESW);
		CURSOR_SIZENW = display.getSystemCursor(SWT.CURSOR_SIZENW);
		CURSOR_UPARROW = display.getSystemCursor(SWT.CURSOR_UPARROW);
		CURSOR_IBEAM = display.getSystemCursor(SWT.CURSOR_IBEAM);
		CURSOR_NO = display.getSystemCursor(SWT.CURSOR_NO);
		CURSOR_HAND = display.getSystemCursor(SWT.CURSOR_HAND);

		images = new Image[imageFileList.length];

		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage(disp, imageFileList[i]);
		}
	}

	public static String getImageName(int i) {
		if (i < imageFileList.length) {
			return (imageFileList[i]);
		}
		return (null);
	}

	public static Image getImage(int i) {
		if (i < images.length) {
			return (images[i]);
		}
		return (null);
	}

	public static void setImage(int i, Image image) {
		if (i < images.length) {
			images[i] = image;
		}
	}

	public static Image loadImage(Display display, String path) {
		Image image = null;
		try {
			InputStream stream = GraphicsUtil.class.getResourceAsStream(path);
			// System.out.println("fileName : " + path + ", stream : "
			// + stream);
			if (stream != null) {
				ImageData imageData = new ImageData(stream);
				if (imageData != null) {
					return new Image(display, imageData);// , mask);
				}
			}
		} catch (SWTException e) {
			e.printStackTrace();
		}
		return (image);
	}

	public static void dispose() {
		if (images != null) {
			for (int i = 0; i < images.length; ++i) {
				if (images[i] != null) {
					images[i].dispose();
					images[i] = null;
				}
			}
			images = null;
		}
	}

	public static void setCursorWait(Shell shell, boolean flag) {
		if (flag == true) {
			shell.setCursor(CURSOR_WAIT);
		} else if (flag == false) {
			shell.setCursor(CURSOR_ARROW);
		}
	}

	public static void setCursorArrow(Shell shell) {
		shell.setCursor(CURSOR_ARROW);
	}

	public static void setCursorWait(Shell shell) {
		shell.setCursor(CURSOR_WAIT);
	}

	public static void print() {
		for (int i = 0; i < images.length; i++) {
			System.out.println("[GraphicsUtil-print] images[" + i + "] : "
					+ images[i]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();

		init(display);
		print();
		dispose();
	}
}
