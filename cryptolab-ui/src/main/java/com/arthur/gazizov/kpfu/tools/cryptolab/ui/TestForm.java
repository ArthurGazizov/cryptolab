package com.arthur.gazizov.kpfu.tools.cryptolab.ui;

import javax.swing.*;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class TestForm extends JFrame{
  private JPanel panel1;
  private JButton button1;
  private JTextPane textPane1;

  public TestForm() {
    setContentPane(panel1);
    setVisible(true);
    setSize(400, 400);

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
