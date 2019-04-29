package ru.geekbrains.lesson_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static ru.geekbrains.lesson_7.MessagePatterns.*;

public class ClientHandler {
    private final String login;
    private final Socket socket;
    private final DataInputStream inp;
    private final DataOutputStream out;
    private final Thread handleThread;
    private ChatServer chatServer;

    //обрабатывает и хранит в себе авторизованных пользователей
    public ClientHandler(String login, Socket socket, ChatServer chatServer) throws IOException {
        this.login = login;
        this.socket = socket;
        this.inp = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.chatServer = chatServer;

        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String text = inp.readUTF();
                        System.out.printf("Message from user %s: %s%n", login, text);

                        System.out.println("New message " + text);
                        TextMessage msg = parseTextMessageRegx(text, login);
                        if (msg != null) {
                            chatServer.sendMessage (msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
        this.chatServer = chatServer;
        this.handleThread.start();
    }

    public String getLogin() {
        return login;
    }

    public void sendMessage(String userFrom, String msg) throws IOException {
        out.writeUTF(String.format(MESSAGE_SEND_PATTERN, userFrom, msg));
    }
}
