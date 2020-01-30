import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetAddressApp {
	public static void main(String[] args) {
		byte[] hostIP={(byte)184, (byte)107, (byte)199, (byte)138};
		String hostName="www.test.com";
     try {
		 //hostAddress=InetAddress.getByName(hostName).getHostAddress()();
		 InetAddress hostInetAddress=InetAddress.getByAddress(hostIP);
		System.out.println("Host Name: "+InetAddress.getByName(hostName).getHostAddress());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
