package org.example;

import java.awt.*;

public class Application {
    public static MyFrame frame;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> frame = new MyFrame());
    }
}
