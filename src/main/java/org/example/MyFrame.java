package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MyFrame extends JFrame implements ActionListener {

    JLabel label = new JLabel("Wojna-Gildii");
    JPanel panel = new JPanel();
    JButton button = new JButton("Rozpocznij symulacje");
    JTextField[] field = new JTextField[3];
    JLabel[] inscription = new JLabel[3];
    Guild guild;

    public MyFrame() {
        super("Wojna-Gildii");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 700, 400);
        setResizable(false);

        panel.setLayout(null);

        add(panel);

        label.setBounds(10, 10, 200, 25);
        label.setFont(new Font("Courier New", (Font.BOLD | Font.ITALIC), 15));
        label.setForeground(Color.RED.darker());
        panel.add(label);

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                inscription[i] = new JLabel("Liczba Jednostek: ");
            } else if (i == 1) {
                inscription[i] = new JLabel("Liczba iteracji: ");
            } else if (i == 2) {
                inscription[i] = new JLabel("Rozmiar Mapy: ");
            }
            inscription[i].setBounds(10, 10 + ((i + 1) * 40), 200, 25);
            panel.add(inscription[i]);
        }

        for (int i = 0; i < 3; i++) {
            field[i] = new JTextField();
            field[i].setBounds(210, 10 + ((i + 1) * 40), 200, 25);
            panel.add(field[i]);
        }

        button.setBounds(10, 170, 200, 25);
        button.setForeground(Color.RED.darker());
        panel.add(button);
        button.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent ewt) {

        if (ewt.getSource() == button) {

            try {
                new Guild(Integer.valueOf(field[0].getText()), Integer.valueOf(field[1].getText()), Integer.valueOf(field[2].getText()));
            } catch (FileNotFoundException exeption) {
            }
            JOptionPane.showMessageDialog(guild.frame, guild.getInscription().inscription, "ZWYCIESTWO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
