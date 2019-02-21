package com.company.web;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

class ServerSendMessage implements Runnable{
    private BufferedReader bReader;
    private  Socket socket;
    private ArrayList<Socket> socketList;
    private Scanner in=new Scanner(System.in);

    public ServerSendMessage(Socket socket,ArrayList<Socket> socketList){
        this.socket = socket;
        this.socketList = socketList;
        try {
            bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        PrintStream ps;
        while (true) {
            try {
                ps = new PrintStream(socket.getOutputStream(),true);
                System.setOut(ps);
                System.setIn(socket.getInputStream());
                new CompanyController().mainMenu();
                while (in.hasNext()) {
                    ps.print(in.nextLine());
                    ps.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}

public class CompanyServer {
    public static final int PORT = 30001;
    //一个集合，为每个客户端添加sock
    public static ArrayList<Socket> socketList = new ArrayList<>();
    public static void main(String[] args) {
        //服务端
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("等待客户端连接。。。");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                socket = serverSocket.accept();
                socketList.add(socket);
                System.out.println("客户端："+socket.getInetAddress().getHostName()+"连接成功！");
                new Thread(new ServerSendMessage(socket,socketList)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
