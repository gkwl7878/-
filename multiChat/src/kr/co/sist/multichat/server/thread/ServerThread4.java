package kr.co.sist.multichat.server.thread;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.multichat.server.helper.ServerHelper;
import kr.co.sist.multichat.server.view.ServerView;

public class ServerThread4 implements Runnable{

	private ServerView sv;
	private ServerSocket server;
	private List<ServerHelper> listClient;
	private Thread threadServer;
	
	public ServerThread4() {
		if (threadServer == null) {
			threadServer = new Thread(this);
			threadServer.start();
			sv.getJtaChatDisplay1().setText("����������.....");
		} else {
			JOptionPane.showMessageDialog(sv, "ä�ü����� �̹� �������Դϴ�.");
		}
	}
	@Override
	public void run() {
		try {
			server = new ServerSocket(10000);
		
			Socket someClient = null;
			
			ServerHelper sh = null; //��� �����ڿ��� ��Ʈ���� �����ϰ� ��ȭ�� �а� ��ε�ĳ���� ����
		
			while (true) {
				someClient = server.accept();
				sh = new ServerHelper(someClient, listClient, sv, sv.getJtaChatDisplay4(), sv.getJspChatDisplay4());
				listClient.add(sh);
				sh.start();
			} // end while

		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}// run

}