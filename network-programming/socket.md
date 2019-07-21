# Socket

## simple socket

### server

```java
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Server sv = new Server();
		sv.ServerRun();
	}
	
	public void ServerRun() {
		ServerSocket server = null;
		int port = 4000;
		Socket socket = null;
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		
		try {
			server = new ServerSocket(port);
			while(true) {
				System.out.println("----접속 대기----");
				socket = server.accept();	//클라이언트가 접속하면 통신할 수 있는 소켓 반환
				System.out.println(socket.getInetAddress() + "로 부터 연결요청");
				
				is = socket.getInputStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				//클라이언트로부터 데이터를 받기 위한 InputStream 선언
				
				String data = null;
				data = br.readLine();
				System.out.println("클라이언트로 부터 받은 데이터:" + data);
				
				receiveData(data, socket); 	//받은 데이터를 그래도 다시 보내기
				System.out.println("----전송 완료----");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
				server.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
	public void receiveData(String data, Socket socket) {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			//클라이언트로부터 데이터를 보내기 위해 OutputStream 선언
			
			bw.write("이거");		//클라이언트로 데이터 전송
			bw.flush();
			
		}catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
			
		}finally {
			try {
				bw.close();
				osw.close();
				os.close();
				socket.close();
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}
	}
	
}
```

### client

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Client cl = new Client();
		Scanner sc = new Scanner(System.in);
		System.out.print("메시지 입력 :");
		
		
		String message = sc.nextLine(); 
		cl.ClientRun(message);
	}
	
	public void ClientRun(String data) {
		Socket socket = null;
        OutputStream os = null;
        OutputStreamWriter osw =null;
        BufferedWriter bw = null;
        
        InputStream is =null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        
        try{
            socket = new Socket("localhost", 4000);
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);            //서버로 전송을 위한 OutputStream
        
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);        // 서버로부터 Data를 받음
            
            bw.write(data);
            bw.newLine();
            bw.flush();
            
            String receiveData = "";
            receiveData = br.readLine();        // 서버로부터 데이터 한줄 읽음
            System.out.println("서버로부터 받은 데이터 : " + receiveData);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                bw.close();
                osw.close();
                os.close();
                br.close();
                isr.close();
                is.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
	}

}
```

## send image through socket

### server

```java
package socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server_image {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Server_image sv = new Server_image();
		sv.ServerRun();
	}
	
	public void ServerRun() throws IOException {
		ServerSocket server = new ServerSocket(8000);
		int port = 8000;
		Socket socket = null;
		
		byte buffer[] = new byte[2048];
		File imgfile = new File("search.png");
		String flen = String.valueOf(imgfile.length());
		//change "1234" to "0000001234", to make sure 10 size.
		
		String header = "0000000000".substring(0, 10-flen.length()) + flen;
		
		while((socket = server.accept())!= null) {
			FileInputStream fis = new FileInputStream(imgfile);
			OutputStream os = socket.getOutputStream();
			
			//send header
			os.write(header.getBytes());
			
			//send body
			while(fis.available() > 0) {
				int readsz = fis.read(buffer);
				os.write(buffer, 0, readsz);
			}
			
			os.close();
			fis.close();
		}
	}
}
```

### client

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_image {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket sock = new Socket("localhost", 8000);
		
		FileOutputStream fos = new FileOutputStream("test3.png");
		InputStream is = sock.getInputStream();
		byte buffer[] = new byte[2048];
		
		//read header(10 bytes)
		is.read(buffer,0,10);
		
		String header = new String(buffer,0,10);
		int bodysize = Integer.parseInt(header);
		int readsize = 0;
		
		//read body
		while(readsize < bodysize) {
			int rsize = is.read(buffer);
			fos.write(buffer, 0, rsize);
			readsize += rsize;
		}
		
		is.close();
		fos.close();
	}
}
```

