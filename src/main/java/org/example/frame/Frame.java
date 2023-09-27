package org.example.frame;

import org.example.Application;
import org.example.Guild;
import org.example.Result;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    JLabel label = new JLabel("Wojna-Gildii");
    JPanel panel = new JPanel();
    JButton button = new JButton("Rozpocznij symulacje");
    JTextField[] field = new JTextField[3];
    JLabel[] inscription = new JLabel[3];
    Guild guild;

    public Frame() {
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

        for (int i = 0; i < FrameEnum.getAll().size(); i++) {
            inscription[i] = new JLabel(FrameEnum.getAll().get(i).getValue());
            inscription[i].setBounds(10, 10 + ((i + 1) * 40), 200, 25);
            panel.add(inscription[i]);
        }

        for (int i = 0; i < FrameEnum.getAll().size(); i++) {
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
            if(guild!=null){
                guild.resetStaticData();
            }
            guild = new Guild(Integer.parseInt(field[0].getText()), Integer.parseInt(field[1].getText()), Integer.parseInt(field[2].getText()));
            guild.run();
            JOptionPane.showMessageDialog(Application.frame, Result.inscription, "ZWYCIESTWO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
