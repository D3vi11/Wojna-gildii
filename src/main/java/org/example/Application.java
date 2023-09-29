package org.example;

import org.example.frame.Frame;

import java.awt.*;

public class Application {
    public static org.example.frame.Frame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> frame = new Frame());
    }
}
