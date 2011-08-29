package ui;

/**
 * (c) utcl95 - 04/05/11
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class uToolBar extends JToolBar
                         implements ActionListener {
    static final private String PREVIOUS = "previous";
    static final private String UP = "up";
    static final private String NEXT = "next";

    public uToolBar() {
        addButtons(this);
    }

    protected void addButtons(JToolBar toolBar) {
        JButton button;

        //first button
        button = makeNavigationButton("Back24", PREVIOUS,
                                      "Back to previous something-or-other",
                                      "Previous");
        toolBar.add(button);

        //second button
        button = makeNavigationButton("Up24", UP,
                                      "Up to something-or-other",
                                      "Up");
        toolBar.add(button);

        //third button
        button = makeNavigationButton("Forward24", NEXT,
                                      "Forward to something-or-other",
                                      "Next");
        toolBar.add(button);
    }

    protected JButton makeNavigationButton(String imageName,
                                           String actionCommand,
                                           String toolTipText,
                                           String altText) {
        //Look for the image.
        String imgLocation = "/toolbarButtonGraphics/navigation/"
                             + imageName
                             + ".gif";
        URL imageURL = uToolBar.class.getResource(imgLocation);
        //URL imageURL = uToolBar.class.getResource("Back24");

        //Create and initialize the button.
        JButton button = new JButton();
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(this);

        if (imageURL != null) {                      //image found
            button.setIcon(new ImageIcon(imageURL, altText));
        } else {                                     //no image found
            button.setText(altText);
            System.err.println("Resource not found: "
                               + imgLocation);
        }

        return button;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // Handle each button.
        if (PREVIOUS.equals(cmd)) { //first button clicked
        } else if (UP.equals(cmd)) { // second button clicked
        } else if (NEXT.equals(cmd)) { // third button clicked
        }
    }
}