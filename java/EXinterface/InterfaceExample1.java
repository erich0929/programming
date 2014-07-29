/* import com.erich0929.www.SeparateVolume; */
/* import com.erich0929.www.AppCDInfo; */
import com.erich0929.www.*;

class InterfaceExample1
{
	public static void main (String agrs[])
	{
		SeparateVolume obj1 = new SeparateVolume ("863?774개", "개미", "베르베르");
		AppCDInfo obj2 = new AppCDInfo ("2055-7001", "Redhat Fedora");
		obj1.checkOut ("김영숙", "20140128");
		obj2.checkOut ("김수혜", "20140128");
		obj1.checkIn ();
		obj2.checkIn ();
	}
}

