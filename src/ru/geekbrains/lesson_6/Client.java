package ru.geekbrains.lesson_6;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localHost", 1025)) {
            ClientHendler clientHendler = new ClientHendler(socket);
            clientHendler.start();
            clientHendler.join();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
