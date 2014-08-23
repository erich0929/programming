package org.rndclub.fd.ui;

import java.awt.Toolkit;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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


public class ClientCompoRaw extends Composite implements IProgress {

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

	Composite downloadComp = null;

	Label downloadLable = null;

	Text downloadText = null;

	Button downloadButton = null;

	Group fileGroup = null;

	Label fileGroupLabel = null;

	Table fileTable = null;

	Label fileLabel = null;

	Composite commandComp = null;

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

	Composite bottomComp = null;

	Button closeButton = null;

	int totalSize = 0;

	int xCount = 0;

	int tCount = 0;

	ThreadDownload th = null;

	long startTime = 0;

	long prevTime = 0;

	public ClientCompoRaw(Composite parent, int style) {
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

		downloadComp = new Composite(baseComp, SWT.NONE);
		downloadLable = new Label(downloadComp, SWT.NONE);
		downloadLable.setText("LOCATION :");
		downloadText = new Text(downloadComp, SWT.BORDER | SWT.MULTI);
		downloadText.setText("E:\\Temp");
		downloadText.setEditable(false);
		downloadButton = new Button(downloadComp, SWT.NONE);
		downloadButton.setText(FileDownload.labels.get("button.change"));

		fileGroup = new Group(baseComp, SWT.SHADOW_NONE);
		fileGroup.setText("Download Files");
		fileTable = new Table(fileGroup, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI
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
		fileLabel = new Label(fileGroup, SWT.NONE);
		fileLabel.setText("Count : 0 Total : 0 B");

		commandComp = new Composite(baseComp, SWT.NONE);
		refreshButton = new Button(commandComp, SWT.NONE);
		refreshButton.setText(FileDownload.labels.get("button.refresh"));
		startButton = new Button(commandComp, SWT.NONE);
		startButton.setText(FileDownload.labels.get("button.start"));
		stopButton = new Button(commandComp, SWT.NONE);
		stopButton.setText(FileDownload.labels.get("button.stop"));
		startButton.setEnabled(false);
		stopButton.setEnabled(false);

		statusGroup = new Group(baseComp, SWT.SHADOW_NONE);
		statusGroup.setText("Status");
		xLabel = new Label(statusGroup, SWT.NONE);
		xLabel.setText("Progressing");
		xProgress = new ProgressBar(statusGroup, SWT.SMOOTH);
		tLabel = new Label(statusGroup, SWT.NONE);
		tLabel.setText("Total Progressing");
		tProgress = new ProgressBar(statusGroup, SWT.SMOOTH);
		eLabel = new Label(statusGroup, SWT.NONE);
		eLabel.setText("Speed : 0 Kbps Elabsed : 00:00:00 Remain 00:00:00");

		bottomComp = new Composite(baseComp, SWT.NONE);
		closeButton = new Button(bottomComp, SWT.NONE);
		closeButton.setText(FileDownload.labels.get("button.close"));
	}

	public void doLayout() {
		// Main
		GridLayout gridLayout = new GridLayout(1, false);
		this.setLayout(gridLayout);

		GridData data = new GridData(GridData.BEGINNING
				| GridData.FILL_HORIZONTAL);
		downloadComp.setLayoutData(data);

		// Download Location
		gridLayout = new GridLayout(3, false);
		downloadComp.setLayout(gridLayout);

		data = new GridData(GridData.BEGINNING);
		downloadLable.setLayoutData(data);
		data = new GridData(GridData.CENTER | GridData.FILL_HORIZONTAL);
		downloadText.setLayoutData(data);
		data = new GridData(GridData.END);
		downloadButton.setLayoutData(data);

		data = new GridData(GridData.BEGINNING | GridData.FILL_HORIZONTAL);
		fileGroup.setLayoutData(data);

		// Download File List
		gridLayout = new GridLayout(1, false);
		fileGroup.setLayout(gridLayout);

		data = new GridData(GridData.BEGINNING | GridData.FILL_HORIZONTAL);
		data.heightHint = 128;
		data.grabExcessVerticalSpace = true;
		fileTable.setLayoutData(data);
		data = new GridData(GridData.BEGINNING | GridData.FILL_HORIZONTAL);
		fileLabel.setLayoutData(data);

		// Command Button
		data = new GridData(GridData.BEGINNING | GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		commandComp.setLayoutData(data);

		FillLayout fillLayout = new FillLayout();
		commandComp.setLayout(fillLayout);

		// Download Status & Progress
		data = new GridData(GridData.BEGINNING | GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		statusGroup.setLayoutData(data);

		gridLayout = new GridLayout(1, false);
		gridLayout.horizontalSpacing = gridLayout.verticalSpacing = 2;
		statusGroup.setLayout(gridLayout);

		data = new GridData(GridData.FILL_HORIZONTAL);
		xProgress.setLayoutData(data);

		data = new GridData(GridData.FILL_HORIZONTAL);
		tProgress.setLayoutData(data);

		data = new GridData(GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		xLabel.setLayoutData(data);

		data = new GridData(GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		tLabel.setLayoutData(data);

		data = new GridData(GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		eLabel.setLayoutData(data);

		// Close Button
		data = new GridData(GridData.BEGINNING | GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		bottomComp.setLayoutData(data);

		gridLayout = new GridLayout(1, false);
		bottomComp.setLayout(gridLayout);

		data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		data.grabExcessHorizontalSpace = true;
		closeButton.setLayoutData(data);
	}

	public void addListener() {
		downloadButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
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
				String title = "Confirm!!!";
				String message = "Close?";
				int style = SWT.OK | SWT.CANCEL | SWT.ICON_QUESTION;
				MessageBox dialog = new MessageBox(shell, style);
				dialog.setText(title);
				dialog.setMessage(message);

				int flag = dialog.open();
				if (flag == SWT.OK) {
					stop();
					display.dispose();
				}
			}
		});
	}

	public void setEnable(boolean flag) {
		downloadButton.setEnabled(flag);
		refreshButton.setEnabled(flag);
		startButton.setEnabled(flag);
		stopButton.setEnabled(!flag);
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
		new ClientCompoRaw(shell, SWT.NONE);

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
