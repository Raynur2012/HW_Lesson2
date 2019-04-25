package ru.geekbrains.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHendler {
    private Socket socet;
    private Thread sendThr;
    private Thread reciveThr;

    public ClientHendler(Socket socet){
        this.socet = socet;
    }

    public void start(){
        sendThr = new Thread(new Runnable() {
            @Override
            public void run() {
                try (Scanner scanner = new Scanner(System.in);
                     DataOutputStream outputStream = new DataOutputStream(socet.getOutputStream());
                ) {
                    do {
                        System.out.print("Введите сообщение > ");
                        String msg = scanner.nextLine();
                        outputStream.writeUTF(msg);
                    } while (true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        reciveThr = new Thread(new Runnable() {
            @Override
            public void run() {
                try(DataInputStream inputStream = new DataInputStream(socet.getInputStream())) {
                    while (true){
                        System.out.printf("%nНовое сообщение > %s%n", inputStream.readUTF());
                        System.out.print("Введите сообщение > ");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        sendThr.start();
        reciveThr.start();
    }
    public void join(){
        try {
            sendThr.join();
            reciveThr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
