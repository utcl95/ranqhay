package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * (c) utcl95 - 04/05/11
 */
public class uMenuBar extends JMenuBar {

    String[] fileItems = new String[] { "Nuevo", "Abrir", "Guardar", "Salir" };
    String[] editItems = new String[] { "Undo", "Cut", "Copy", "Paste" };
    char[] fileShortcuts = { 'N','O','S','X' };
    char[] editShortcuts = { 'Z','X','C','V' };

    public uMenuBar() {

        JMenu fileMenu = new JMenu("Archivo");
        JMenu editMenu = new JMenu("Editar");
        JMenu otherMenu = new JMenu("Ayuda");

        // Assemble the File menus with mnemonics.
        ActionListener printListener = new ActionListener( ) {
                public void actionPerformed(ActionEvent event) {
                    System.out.println("Menu item [" + event.getActionCommand( ) +
                                       "] was pressed.");
                }
            };
        for (int i=0; i < fileItems.length; i++) {
            JMenuItem item = new JMenuItem(fileItems[i], fileShortcuts[i]);
            item.addActionListener(printListener);
            fileMenu.add(item);
        }

        // Assemble the File menus with keyboard accelerators.
        for (int i=0; i < editItems.length; i++) {
            JMenuItem item = new JMenuItem(editItems[i]);
            item.setAccelerator(KeyStroke.getKeyStroke(editShortcuts[i],
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask( ), false));
            item.addActionListener(printListener);
            editMenu.add(item);
        }

        // Insert a separator in the Edit menu in Position 1 after "Undo".
        editMenu.insertSeparator(1);

        // Assemble the submenus of the Other menu.
        JMenuItem item;


        // Assemble the Other menu itself.
        otherMenu.add(item = new JMenuItem("Acerca de",
                             new ImageIcon("image.gif")));
        item.addActionListener(printListener);

        add(fileMenu);
        add(editMenu);
        add(otherMenu);
    }
}
