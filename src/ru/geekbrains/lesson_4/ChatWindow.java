package ru.geekbrains.lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {

    public ChatWindow(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200, 500,500);
        setTitle("Chat");
        setLayout(new BorderLayout());

//        создали первую панель, добавили ее по центру
        JPanel jp1 = new JPanel();
        jp1.setLayout(new BorderLayout());
        add(jp1, BorderLayout.CENTER);

//        создали поле для текста и добавили в первую панель
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        jp1.add(ta);

//      создали вторую панель, добавили ее снизу. Изменили размер в общем BorderLayout
        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        jp2.setPreferredSize(new Dimension(500,80));
        add(jp2, BorderLayout.SOUTH);

//        создали поле воода сообщения, изменили цвет фона, цвет текста и цвет каретки. Добавили обработку событий
        TextField tf = new TextField();
        tf.setBackground(new Color(43,43, 43));
        tf.setForeground(new Color(169,183,198));
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                ta.setText(text);
                tf.setText(null);
            }
        });



//        создали кнопку отправки сообщения и изменили ее размер. Добавили обработку событий.
        JButton jb = new JButton("SEND");
        jb.setPreferredSize(new Dimension(120, 80));
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                ta.setText(text);
                tf.setText(null);
            }
        });

//        добавили поле воода текста и кнопку во вторую панель
        jp2.add(tf, BorderLayout.CENTER);
        jp2.add(jb, BorderLayout.EAST);

//        установили видимость
        setVisible(true);
    }
}
