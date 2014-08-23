package org.rndclub.swt.graphics.begin;


public class GenThread extends Thread {
	UiThreadTest uiThread = null;

	public GenThread(UiThreadTest uiThread) {
		this.uiThread = uiThread;
	}

	public void run() {
		uiThread.setText("FROM... "+this.getName());
	}

	public static void main(String[] args) {
		UiThreadTest uiThreadTest = new UiThreadTest();
		GenThread genThread = new GenThread(uiThreadTest);
		genThread.start();
	}
}
