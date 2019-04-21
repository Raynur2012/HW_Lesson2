package ru.geekbrains.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(1025)){
            while (true) {
                System.out.println("Сервер запущен, ожидает подключения");
                Socket socket = serverSocket.accept();
                System.out.println("Новое подключение > " + socket.getInetAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                while(true){

                    try {
                        System.out.println("Введите сообщение от сервера");
                        System.out.println("Новое сообщение >  " + in.readUTF());
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Введите сообщение от сервера");
                        String line = scanner.nextLine();

                        try {
                            out.writeUTF(line);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException ex){
                        ex.printStackTrace();
                        break;
                    }
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
