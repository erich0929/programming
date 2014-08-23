package org.rndclub.fd.ui;

import java.awt.Toolkit;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.rndclub.fd.http.IProgress;
import org.rndclub.fd.main.FileDownload;
import org.rndclub.fd.main.ThreadDownload;
import org.rndclub.fd.model.FileItem;
import org.rndclub.fd.model.FileList;
import org.rndclub.fd.util.FomatterModel;
import org.rndclub.fd.util.LoggerModel;

public class ClientCompoDesign extends Composite implements IProgress {

	public static int COLUMN_COUNT = 0;

	public static final int COLUMN_NAME = COLUMN_COUNT++;

	public static final int COLUMN_SIZE = COLUMN_COUNT++;

	public static final int COLUMN_TYPE = COLUMN_COUNT++;

	public static final int COLUMN_PATH = COLUMN_COUNT++;

	public static final int COLUMN_URL = COLUMN_COUNT++;

	Display display = null;

	Shell shell = null;

	Composite parent = null;

	Composite baseComp = null;

	Label downloadLable = null;

	Text downloadText = null;

	Button downloadButton = null;

	Group fileGroup = null;

	Label fileGroupLabel = null;

	Table fileTable = null;

	Label fileLabel = null;

	Button refreshButton = null;

	Button startButton = null;

	Button stopButton = null;

	Group statusGroup = null;

	Label statusGroupLabel = null;

	Label xLabel = null;

	ProgressBar xProgress = null;

	Label tLabel = null;

	ProgressBar tProgress = null;

	Label eLabel = null;

	Button closeButton = null;

	int totalSize = 0;

	int xCount = 0;

	int tCount = 0;

	ThreadDownload th = null;

	long startTime = 0;

	long prevTime = 0;

	public ClientCompoDesign(Composite parent, int style) {
		super(parent, style);

		this.parent = parent;
		this.display = parent.getDisplay();
		this.shell = parent.getShell();

		createUi();
		doLayout();
		addListener();
	}

	public boolean init() {
		refresh();
		return true;
	}

	public void createUi() {
		baseComp = this;

		downloadLable = new Label(baseComp, SWT.NONE);
		downloadLable.setText("LOCATION :");
		downloadText = new Text(baseComp, SWT.BORDER | SWT.MULTI);
		downloadText.setText("E:\\Temp");
		downloadText.setEditable(false);
		downloadButton = new Button(baseComp, SWT.NONE);
		downloadButton.setText(FileDownload.labels.get("button.change"));

		fileGroupLabel = new Label(baseComp, SWT.NONE);
		fileGroupLabel.setText("Download Files");
		fileTable = new Table(baseComp, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI
				| SWT.FULL_SELECTION);
		fileTable.setHeaderVisible(true);
		fileTable.setLinesVisible(true);
		final String[] cTitles = new String[]{"Name", "Size", "Type", "Path"};
		for (int i = 0; i < cTitles.length; i++) {
			TableColumn column = new TableColumn(fileTable, SWT.NONE);
			column.setText(cTitles[i]);
			if (i == COLUMN_NAME) {
				column.setAlignment(SWT.LEFT);
			} else if (i == COLUMN_SIZE) {
				column.setAlignment(SWT.RIGHT);
			} else if (i == COLUMN_TYPE) {
				column.setAlignment(SWT.CENTER);
			} else if (i == COLUMN_PATH) {
				column.setAlignment(SWT.LEFT);
			}
		}
		for (int i = 0; i < 4; i++) {
			fileTable.getColumn(i).pack();
		}
		fileLabel = new Label(baseComp, SWT.NONE);
		fileLabel.setText("Count : 0 Total : 0 B");

		refreshButton = new Button(baseComp, SWT.NONE);
		refreshButton.setText(FileDownload.labels.get("button.refresh"));
		startButton = new Button(baseComp, SWT.NONE);
		startButton.setText(FileDownload.labels.get("button.start"));
		stopButton = new Button(baseComp, SWT.NONE);
		stopButton.setText(FileDownload.labels.get("button.stop"));
		startButton.setEnabled(false);
		stopButton.setEnabled(false);

		statusGroupLabel = new Label(baseComp, SWT.NONE);
		statusGroupLabel.setText("Status");
		xLabel = new Label(baseComp, SWT.NONE);
		xLabel.setText("Progressing");
		xProgress = new ProgressBar(baseComp, SWT.SMOOTH);
		tLabel = new Label(baseComp, SWT.NONE);
		tLabel.setText("Total Progressing");
		tProgress = new ProgressBar(baseComp, SWT.SMOOTH);
		eLabel = new Label(baseComp, SWT.NONE);
		eLabel.setText("Speed : 0 Kbps Elabsed : 00:00:00 Remain 00:00:00");

		closeButton = new Button(baseComp, SWT.NONE);
		closeButton.setText(FileDownload.labels.get("button.close"));
	}

	public void doLayout() {
		// Shell
		this.setBackgroundMode(SWT.IMAGE_JPEG);
		this.setBackgroundImage(GraphicsModel
				.getImage(GraphicsModel.IMAGE_DOWNLOAD));

		// Download Location
		downloadLable.setBounds(10, 47, 77, 65-43);
		downloadText.setBounds(84, 43, 331-84+1, 63-43+1);
		downloadButton.setBounds(341, 43, 417-341+1, 63-43+1);

		// Download File List
		fileGroupLabel.setBounds(29, 88, 161-29, 100-83);
		fileTable.setBounds(26, 111, 404-21, 237-111+2);
		fileLabel.setBounds(26, 242, 166-26, 256-240);

		// Command Button
		refreshButton.setBounds(15, 267, 139-15+1, 286-267+4);
		startButton.setBounds(151, 267, 275-151+1, 286-267+4);
		stopButton.setBounds(291, 267, 415-291+1, 286-267+4);

		// Download Status & Progress
		statusGroupLabel.setBounds(26, 309, 200, 15);
		xLabel.setBounds(28, 330, 200, 14);
		xProgress.setBounds(26, 344, 404-26, 358-344);
		tLabel.setBounds(28, 365, 200, 14);
		tProgress.setBounds(26, 378, 404-26, 392-378);
		eLabel.setBounds(28, 398, 380, 14);

		// Close Button
		closeButton.setBounds(339, 421, 415-339+1, 441-421+1);
	}

	public void addListener() {
		downloadButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				changeDir();
			}
		});

		refreshButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				refresh();
			}
		});

		startButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				download();
			}
		});

		stopButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				stop();
			}
		});

		closeButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				exit();
			}
		});
	}

	public void setEnable(boolean flag) {
		downloadButton.setEnabled(flag);
		refreshButton.setEnabled(flag);
		startButton.setEnabled(flag);
		stopButton.setEnabled(!flag);
	}

	private void changeDir() {
		DirectoryDialog dialog = new DirectoryDialog(shell);
		// dialog.setFilterPath("e:\\temp");
		String dirName = dialog.open();
		LoggerModel
				.logln("[ClientComposite#downloadButton-widgetSelected] dir : "
						+ dirName);
		if (dirName != null) {
			downloadText.setText(dirName);
		}
	}

	private void exit() {
		String title = "Confirm!!!";
		String message = "Close?";
		int style = SWT.OK | SWT.CANCEL | SWT.ICON_QUESTION;
		MessageBox dialog = new MessageBox(shell, style);
		dialog.setText(title);
		dialog.setMessage(message);

		int flag = dialog.open();
		if (flag == SWT.OK) {
			stop();
			shell.dispose();
		}
	}

	public void refresh() {
		setEnable(false);

		String downUrl = FileDownload.params.getParameter("serverUrl")
				+ FileDownload.params.getParameter("downUrl");
		LoggerModel.logln("[refresh] downUrl : '" + downUrl + "'");
		FileList fileList = FileList.makeInstance(downUrl);
		int n = fileList.size();
		if (n > 0) {
			fileTable.removeAll();
			totalSize = 0;
			for (int i = 0; i < n; i++) {
				FileItem item = (FileItem) fileList.get(i);
				TableItem tableItem = new TableItem(fileTable, SWT.NONE);
				tableItem.setData(item);

				tableItem.setText(COLUMN_NAME, item.getName());
				tableItem.setText(COLUMN_SIZE, item.getSizeWithComma());
				tableItem.setText(COLUMN_TYPE, item.getType());
				tableItem.setText(COLUMN_PATH, item.getPath());
				totalSize += item.getSize();
			}
			for (int i = 0; i < fileTable.getColumnCount(); i++) {
				fileTable.getColumn(i).pack();
			}
			startButton.setEnabled(true);
			stopButton.setEnabled(true);

			setFileInfo(n, totalSize);
		} else {
			startButton.setEnabled(false);
			stopButton.setEnabled(false);
		}
		xProgress.setSelection(0);
		tProgress.setSelection(0);
		setEnable(true);
	}

	public void download() {
		setEnable(false);
		String dir = downloadText.getText();
		LoggerModel.logln("[download] dir : '" + dir + "'");

		ArrayList fileList = new ArrayList();
		for (int i = 0; (fileTable != null) && (i < fileTable.getItemCount()); i++) {
			TableItem tableItem = fileTable.getItem(i);
			FileItem item = (FileItem) tableItem.getData();
			fileList.add(item);
		}

		init(totalSize);
		th = new ThreadDownload(FileDownload.client, this, dir, fileList);
		th.start();
	}

	public void init(final int total) {
		xCount = 0;
		tCount = 0;
		final int tmax = total;

		startTime = System.currentTimeMillis();
		display.syncExec(new Runnable() {

			public void run() {
				xProgress.setSelection(xCount);
				tProgress.setSelection(tCount);
				tProgress.setMaximum(tmax);
			}
		});
	}

	public void initStatge(int init, int max) {
		xCount = init;
		final int fmax = max;
		display.syncExec(new Runnable() {

			public void run() {
				xProgress.setSelection(xCount);
				xProgress.setMaximum(fmax);
			}
		});
	}

	public void incP(int i) {
		xCount += i;
		tCount += i;

		long currentTime = System.currentTimeMillis();
		final int eTime = (int) (currentTime - startTime);
		if ((currentTime - prevTime) >= 100) {
			final int speed = (int) (((float) tCount / (float) (eTime)) * 1000 / 1000);
			LoggerModel.logln("[incP] count : " + xCount + "," + tCount
					+ ", \teTime:" + eTime + ", \tspeed:" + speed);
			final int rTime = (int) (((float) (totalSize - tCount)) / (float) speed);
			LoggerModel.logln("[incP] time : " + currentTime + ","
					+ currentTime + " --> " + eTime + ", \tspeed:" + speed
					+ ",\trTime:" + rTime);
			display.syncExec(new Runnable() {

				public void run() {
					xProgress.setSelection(xCount);
					tProgress.setSelection(tCount);

					eLabel.setText("Speed : "
							+ FomatterModel.getNumberWithComma(speed)
							+ " Kbps Elabsed : "
							+ FomatterModel.getTimeStr(eTime, ":") + " Remain "
							+ FomatterModel.getTimeStr(rTime, ":"));
				}
			});
			prevTime = currentTime;
		}
	}

	public void setFileInfo(int num, int totalSize) {
		String str = FomatterModel.getNumberWithComma(totalSize);
		fileLabel.setText("Count : " + num + " Total : " + str + " B");
	}

	public void stop() {
		LoggerModel.logln("[stop] STOP...");
		if (th != null) {
			th.kill();
		}
		th = null;

		display.syncExec(new Runnable() {

			public void run() {
				xCount = 0;
				tCount = 0;
				xProgress.setSelection(xCount);
				tProgress.setSelection(tCount);
				setEnable(true);
				startButton.setEnabled(false);
			}
		});
	}

	public void finish() {
		LoggerModel.logln("[finish] FINISH...");
		if (th != null) {
			th.kill();
		}
		th = null;

		display.syncExec(new Runnable() {

			public void run() {
				xCount = xProgress.getMaximum();
				tCount = tProgress.getMaximum();
				xProgress.setSelection(xCount);
				tProgress.setSelection(tCount);
				setEnable(true);
				startButton.setEnabled(false);
			}
		});
	}

	public void dispose() {
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("LGEPIS File Download");

		GraphicsModel.init(display);

		shell.setLayout(new FillLayout());
		new ClientCompoDesign(shell, SWT.NONE);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int w = toolkit.getScreenSize().width;
		int h = toolkit.getScreenSize().height;
		shell.setLocation((int) ((w / 4 * 1) / 3), (int) ((h / 4 * 1) / 3));
		shell.pack();

		shell.setFocus();

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
