package ru.geekbrains.lesson_8;

import ru.geekbrains.lesson_8.auth.AuthService;
import ru.geekbrains.lesson_8.auth.AuthServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static ru.geekbrains.lesson_7.MessagePatterns.*;


public class ChatServer {
    private AuthService authService = new AuthServiceImpl();
    private Map<String, ClientHandler> clientHandlerMap = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start(7777);
    }

    private void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream inp = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("New client connected!");

                User user = null;
                try {
                    String authMessage = inp.readUTF();
                    user = checkAuthentication(authMessage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (AuthException ex) {
                    out.writeUTF("/auth fails");
                    out.flush();
                    socket.close();
                }
                if (user != null && authService.authUser(user)) {
                    System.out.printf("User %s authorized successful!%n", user.getLogin());
                    subscribe(user.getLogin(), socket, user);
                    out.writeUTF(AUTH_SUCCESS_RESPONSE);
                    out.flush();
                } else {
                    if (user != null) {
                        System.out.printf("Wrong authorization for user %s%n", user.getLogin());
                    }
                    out.writeUTF(AUTH_FAIL_RESPONSE);
                    out.flush();
                    socket.close();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private User checkAuthentication(String authMessage) throws AuthException {
        String[] authParts = authMessage.split(" ");
        if (authParts.length != 3 || !authParts[0].equals("/auth")) {
            System.out.printf("Incorrect authorization message %s%n", authMessage);
            throw new AuthException();
        }
        return new User(authParts[1], authParts[2]);
    }

    private void sendUserConnectedMessage(String login) throws IOException {
        for(ClientHandler clientHendler : clientHandlerMap.values()){
            if(!clientHendler.getLogin().equals(login)) {
                System.out.printf("Sending connection notification to %s about %s%n", clientHendler.getLogin(), login);
                clientHendler.sendConnectionMessage(login);
            }
        }
    }

    private void sendUserDisconnectedMessage(String login) throws IOException {
        for(ClientHandler clientHendler : clientHandlerMap.values()){
            clientHendler.sendDisconnectionMessage(login);
        }
    }

    public void sendMessage(TextMessage msg) throws IOException {
        ClientHandler userToClientHandler = clientHandlerMap.get(msg.getUserFrom());
        if( userToClientHandler != null) {
            userToClientHandler.sendMessage(msg.getUserTo(), msg.getText());
        } else {
            System.out.printf("User %s not founded%n", msg.getUserTo());
        }
    }

    public void subscribe(String login, Socket socket, User user) throws IOException {
        if (user != null && authService.authUser(user)) {
            System.out.println(AUTH_FAIL_ALREDYCONNECTED);
        }
            else{
                clientHandlerMap.put(login, new ClientHandler(login, socket, this));
        }
            sendUserConnectedMessage(login);
    }

    public void unsubscribe(String login) throws IOException {
        clientHandlerMap.remove(login);
        sendUserDisconnectedMessage(login);
    }


}
