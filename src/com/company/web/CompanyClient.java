package com.company.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class CompanyClient {
    final static int PORT =30001;
     static Scanner sc = new Scanner(System.in);
    static InputStreamReader s = new InputStreamReader(System.in);
    public static void main(String[] args) {
        CompanyClient client = new CompanyClient();
        try {
            Socket socket = new Socket("192.168.0.124",PORT);
            new CompanyClient().new ReceiveThread(socket).start();
            client.writeToServlet(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToServlet(Socket socket){
        try {
           PrintWriter pw = new PrintWriter(socket.getOutputStream());
            while(sc.hasNext()){
                String sendMessage = sc.nextLine();
                pw.println(sendMessage);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ReceiveThread extends Thread{
        private Socket socket;
        private BufferedReader br;

        public ReceiveThread(Socket socket){
            this.socket = socket;
            try {
                this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String receiveMessage = null;

            try {
                while((receiveMessage=br.readLine())!=null){
                    System.out.println(receiveMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}