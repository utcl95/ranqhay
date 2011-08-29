package ui;

/**
 * (c) utcl95 - 21/08/11
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class uLeftMenu extends JPanel {
    String label[] = { "Productos","Proveedores","Clientes","Compras","Ventas" };
    JList<String> list;

    public uLeftMenu() {
        this.setLayout(new BorderLayout( ));
        list = new JList<String>(label);
        JScrollPane pane = new JScrollPane(list);
        JButton button = new JButton("Print");
        button.addActionListener(new PrintListener( ));

        add(pane, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }


    // An inner class to respond to clicks of the Print button
    class PrintListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selected[] = list.getSelectedIndices( );
            System.out.println("Selected Elements:  ");

            for (int aSelected : selected) {
                String element =
                        list.getModel().getElementAt(aSelected);
                System.out.println("  " + element);
            }
        }
    }
}