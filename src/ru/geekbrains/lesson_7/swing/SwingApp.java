package ru.geekbrains.lesson_7.swing;

import javax.swing.*;

public class SwingApp {
    private static MainWindow mainWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainWindow = new MainWindow();
            }
        });
    }
}

