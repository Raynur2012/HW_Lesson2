package ru.geekbrains.lesson_4;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {

    private final JPanel jp1;
    private final TextMassageCellRenderer massageCellRenderer;
    private final JPanel jp2;
    private final JList<TextMassage> tList;// ответстыеннен исключительно за прорисовку элементов
    private final DefaultListModel<TextMassage> massageListModel; //хранение и добавление новых элементов, удаление старых
    private final TextField tf;
    private final JButton jb;
    private final JScrollPane scroll;

    public ChatWindow(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200, 500,500);
        setTitle("Chat");
        setLayout(new BorderLayout());

//        создали первую панель, добавили ее по центру
        jp1 = new JPanel();
        jp1.setLayout(new BorderLayout());
        add(jp1, BorderLayout.CENTER);

//        создали поле для текста и добавили в первую панель
        tList = new JList<>();
        massageListModel = new DefaultListModel<>();
        tList.setModel(massageListModel);
        massageCellRenderer = new TextMassageCellRenderer();
        tList.setCellRenderer(massageCellRenderer);
//        tList.setLineWrap(true);
//        tList.setWrapStyleWord(true);
//        tList.setEditable(false);
        jp1.add(tList);

        scroll = new JScrollPane(tList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jp1.add(scroll);

//      создали вторую панель, добавили ее снизу. Изменили размер в общем BorderLayout
        jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        jp2.setPreferredSize(new Dimension(500,80));
        add(jp2, BorderLayout.SOUTH);

//        создали поле воода сообщения, изменили цвет фона, цвет текста и цвет каретки. Добавили обработку событий
        tf = new TextField();
        tf.setBackground(new Color(43,43, 43));
        tf.setForeground(new Color(169,183,198));
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                if (text!=null && !text.isEmpty()){
                    TextMassage msg = new TextMassage("Вы:", text);
                    massageListModel.add(massageListModel.getSize(),msg);
                }
                tf.setText(null);
            }
        });



//        создали кнопку отправки сообщения и изменили ее размер. Добавили обработку событий.
        jb = new JButton("SEND");
        jb.setPreferredSize(new Dimension(120, 80));
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                if (text!=null && !text.trim().isEmpty()){
                    TextMassage msg = new TextMassage("Вы :", text);
                    massageListModel.add(massageListModel.getSize(),msg);
                }
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
