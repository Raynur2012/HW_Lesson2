package ru.geekbrains.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket("localHost", 1025)){
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            Thread thr = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Введите сообщение");
                    while(scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        try {
                            System.out.println("Введите сообщение");
                            out.writeUTF(line);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            System.out.println("Сообщение от сервера >  " + in.readUTF());
                        } catch ( IOException ex){
                            ex.printStackTrace();
                        }
                    }
                }
            });
            thr.start();
            thr.join();
        } catch(IOException | InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
