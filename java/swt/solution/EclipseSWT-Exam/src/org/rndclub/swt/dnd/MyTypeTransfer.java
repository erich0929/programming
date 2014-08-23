package org.rndclub.swt.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

public class MyTypeTransfer extends ByteArrayTransfer {
	private static final String MYTYPE_NAME = "my_type_name";
	private static final int MYTYPE_ID = registerType(MYTYPE_NAME);
	private static MyTypeTransfer INSTANCE = new MyTypeTransfer();

	private MyTypeTransfer() {
	}

	public static MyTypeTransfer getInstance() {
		return INSTANCE;
	}

	public void javaToNative(Object object, TransferData transferData) {
		if (object == null || !(object instanceof MyType[])) {
			return;
		}

		if (isSupportedType(transferData)) {
			MyType[] myTypes = (MyType[]) object;
			try {
				// write data to a byte array and then ask super to convert to
				// pMedium
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				DataOutputStream out = new DataOutputStream(bout);
				for (int i = 0, length = myTypes.length; i < length; i++) {
					byte[] buffer = myTypes[i].fileName.getBytes();
					out.writeInt(buffer.length);
					out.write(buffer);
					out.writeLong(myTypes[i].fileLength);
					out.writeLong(myTypes[i].lastModified);
				}
				byte[] buffer = bout.toByteArray();
				out.close();

				super.javaToNative(buffer, transferData);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Object nativeToJava(TransferData transferData) {
		if (isSupportedType(transferData)) {

			byte[] buffer = (byte[]) super.nativeToJava(transferData);
			if (buffer == null) {
				return null;
			}

			MyType[] myData = new MyType[0];
			try {
				ByteArrayInputStream bin = new ByteArrayInputStream(buffer);
				DataInputStream in = new DataInputStream(bin);
				while (in.available() > 20) {
					MyType datum = new MyType();

					int size = in.readInt();
					byte[] name = new byte[size];
					in.read(name);
					datum.fileName = new String(name);
					datum.fileLength = in.readLong();
					datum.lastModified = in.readLong();

					MyType[] newMyData = new MyType[myData.length + 1];
					System.arraycopy(myData, 0, newMyData, 0, myData.length);
					newMyData[myData.length] = datum;
					myData = newMyData;
				}
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			return myData;
		}

		return null;
	}

	protected String[] getTypeNames() {
		return new String[]{MYTYPE_NAME};
	}

	protected int[] getTypeIds() {
		return new int[]{MYTYPE_ID};
	}
}
