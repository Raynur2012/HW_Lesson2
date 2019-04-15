package ru.geekbrains.lesson_4;

import javax.swing.*;
import java.awt.*;

public class TextMassageCellRenderer extends JPanel implements ListCellRenderer<TextMassage> {
    private final JLabel userName;
    private final JLabel created;
    private final JTextArea massageText;
    public TextMassageCellRenderer(){
        setLayout(new BorderLayout());

        created = new JLabel();
        userName = new JLabel();
        massageText = new JTextArea();

        Font f = userName.getFont();
        userName.setFont(f.deriveFont(f.getStyle()| Font.BOLD));

        Font ft = massageText.getFont();
        massageText.setFont(ft.deriveFont(ft.getStyle()| Font.ITALIC));

        massageText.setLineWrap(true);
        massageText.setWrapStyleWord(true);
        massageText.setEditable(false);

        add(created, BorderLayout.EAST);
        add(userName, BorderLayout.NORTH);
        add(massageText, BorderLayout.WEST);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends TextMassage> list,
                                                  TextMassage value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        setBackground(list.getBackground());
        created.setText(value.getCreated().toString());
        userName.setOpaque(true);
        userName.setText(value.getUserName());
        massageText.setText(value.getText());
        return this;
    }
}
