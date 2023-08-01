package Udemy;
//Note --> throws InputMismatchException exception at the time of input from the server

//   IMP - Start the client first and after of that start server

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeServer {
    public static void main(String[] args) throws Exception{

        //Actual server - it'll provide the date and time to the client
        DatagramSocket ds = new DatagramSocket(2001);
        LocalDateTime ldt = LocalDateTime.now();

        //Date is formatted in the appropriate format using DTF
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SS");
        String msg = dtf.format(ldt);

        //This confirm string will be returned from the Client
        String confirm = " ";

        //If reply from the server will be the no then this return text provided to Client
        String decline ="Access Denied to Server";

        //user input(Access point)

        Scanner sc = new Scanner(System.in);
        System.out.println("Client is asking for Time and date info,Choose(Yes or No) :");
        String permission = sc.nextLine();
        System.out.println("Server Started");

        DatagramPacket dp;
        if (permission.equalsIgnoreCase("Yes")) {
            dp = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), 2000);
            ds.send(dp);
        }
        else {
            dp = new DatagramPacket(decline.getBytes(), decline.length(), InetAddress.getLocalHost(), 2000);
            System.out.println("No data is provided from server to client");
            ds.send(dp);
        }


        //Here the return data from the Client received
         byte[] b = new byte[1024];
         dp = new DatagramPacket(b,1024);
         ds.receive(dp);
         confirm = new String(dp.getData()).trim();
        System.out.println("From Client: "+confirm);

         ds.close();

    }
}

class TimeClient {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket(2000);

        System.out.println("Client Started");

        //Return text to server when Client will receive the Data
        String confirm = "Received date and time info";

        // To receive the data from the server
        byte [] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b,1024);
        ds.receive(dp);
        String msg = new String(dp.getData()).trim();
        System.out.println("From server: "+msg);

        //In the case of Access denied from server this block will work
        if (!msg.equalsIgnoreCase("Access Denied to Server")) {
            dp = new DatagramPacket(confirm.getBytes(), confirm.length(), InetAddress.getLocalHost(), 2001);
            ds.send(dp);
        }
    }
}

