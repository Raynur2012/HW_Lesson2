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
                ClientHendler clientHendler = new ClientHendler(socket);
                clientHendler.start();

            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
