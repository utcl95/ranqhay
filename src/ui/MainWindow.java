package ui;

import javax.swing.*;
import java.awt.*;

/**
 * (c) utcl95 - 04/05/11
 */
public class MainWindow extends JFrame {
    public MainWindow() {
        super("(c) utcl95");
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mw.setExtendedState(mw.getExtendedState()|JFrame.MAXIMIZED_BOTH);

        // set menubar
        mw.setJMenuBar(new uMenuBar());

        // set toolbar
        mw.add(new uToolBar(), BorderLayout.NORTH);

        uLeftMenu jt1 = new uLeftMenu();
        uTabbedPane jt2 = new uTabbedPane();

        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jt1, jt2);


        mw.add(sp, BorderLayout.CENTER);
        mw.setVisible(true);
    }
}
