import co.kr.jaso.hello.thrift.generated.*;
import org.apache.thrift.TException;  

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.THsHaServer.*;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
public class HelloServer{

	 public static void main(String[] args) throws Exception{
		 if(args.length <1){
			 System.out.println("Usage java HelloServer <port>");
			 System.exit(0);
		 }
		TServerSocket serverTransport = new TServerSocket(7911);
		 int port = Integer.parseInt(args[0]);
		 final TNonblockingServerSocket socket = new TNonblockingServerSocket(port);
		 final HelloService.Processor processor = new HelloService.Processor(new HelloHandler());
		 final TServer server = new THsHaServer(new THsHaServer.Args (socket));

		 System.out.println("started port : " + port);
		 server.serve();

	 }
}
	
