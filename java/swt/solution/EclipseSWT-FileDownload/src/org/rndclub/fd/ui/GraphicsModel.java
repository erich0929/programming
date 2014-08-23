package org.rndclub.fd.ui;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphicsModel {
	// static ImageLoader imageLoader = null;

	// static ImageData[] imageDataArray;

	static Display display = null;

	static String[] imageFileList = null;

	static Image[] images = null;

	public static int IMAGE_NUM = 0;

	final public static int IMAGE_ICON = IMAGE_NUM++;

	final public static int IMAGE_BODY = IMAGE_NUM++;

	final public static int IMAGE_CHANGE = IMAGE_NUM++;

	final public static int IMAGE_REFRESH = IMAGE_NUM++;

	final public static int IMAGE_START = IMAGE_NUM++;

	final public static int IMAGE_STOP = IMAGE_NUM++;

	final public static int IMAGE_CLOSEBUTTON = IMAGE_NUM++;

	final public static int IMAGE_DOWNLOAD = IMAGE_NUM++;
	final public static int IMAGE_PENTA_LOGO = IMAGE_NUM++;

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

	public static void init(Display disp) {
		display = disp;

		imageFileList = new String[]{"/org/rndclub/fd/images/icon.gif",
				"/org/rndclub/fd/images/main.jpg",
				"/org/rndclub/fd/images/change.jpg",
				"/org/rndclub/fd/images/refresh.jpg",
				"/org/rndclub/fd/images/start.jpg",
				"/org/rndclub/fd/images/stop.jpg",
				"/org/rndclub/fd/images/close.jpg",
				"/org/rndclub/fd/images/download.jpg",
				"/org/rndclub/fd/images/penta_logo.gif"};

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

	public static Image loadImage(Display display, String fileName) {
		Image image = null;
		try {
			InputStream stream = GraphicsModel.class
					.getResourceAsStream(fileName);
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
		if (COLOR_WHITE != null) {
			COLOR_WHITE.dispose();
			COLOR_BLACK.dispose();
			COLOR_RED.dispose();
			COLOR_DARK_RED.dispose();
			COLOR_GREEN.dispose();
			COLOR_DARK_GREEN.dispose();
			COLOR_YELLOW.dispose();
			COLOR_DARK_YELLOW.dispose();
			COLOR_BLUE.dispose();
			COLOR_DARK_BLUE.dispose();
			COLOR_MAGENTA.dispose();
			COLOR_DARK_MAGENTA.dispose();
			COLOR_CYAN.dispose();
			COLOR_DARK_CYAN.dispose();
			COLOR_GRAY.dispose();
			COLOR_DARK_GRAY.dispose();

			CURSOR_ARROW.dispose();
			CURSOR_WAIT.dispose();
			CURSOR_CROSS.dispose();
			CURSOR_APPSTARTING.dispose();
			CURSOR_HELP.dispose();
			CURSOR_SIZEALL.dispose();
			CURSOR_SIZENESW.dispose();
			CURSOR_SIZENS.dispose();
			CURSOR_SIZENWSE.dispose();
			CURSOR_SIZEWE.dispose();
			CURSOR_SIZEN.dispose();
			CURSOR_SIZES.dispose();
			CURSOR_SIZEE.dispose();
			CURSOR_SIZEW.dispose();
			CURSOR_SIZENE.dispose();
			CURSOR_SIZESE.dispose();
			CURSOR_SIZESW.dispose();
			CURSOR_SIZENW.dispose();
			CURSOR_UPARROW.dispose();
			CURSOR_IBEAM.dispose();
			CURSOR_NO.dispose();
			CURSOR_HAND.dispose();
		}

		if (images != null) {
			for (int i = 0; i < images.length; ++i) {
				if (images[i] != null) {
					images[i].dispose();
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
