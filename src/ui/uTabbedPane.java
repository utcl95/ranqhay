package ui;

/**
 * (c) utcl95 - 21/08/11
 */
import javax.swing.*;
import java.awt.*;

public class uTabbedPane extends JPanel {

  JTabbedPane jtp;

  public uTabbedPane() {
    this.setLayout(new BorderLayout( ));
    setSize(200, 200);
    jtp = new JTabbedPane( );
    jtp.addTab("Productos", new JLabel("This is Tab One"));
    jtp.addTab("Compras", new JButton("This is Tab Two"));
    jtp.addTab("Ventas", new JCheckBox("This is Tab Three"));
      add(jtp, BorderLayout.CENTER);

  }
}