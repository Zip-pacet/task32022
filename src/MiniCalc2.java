import ourqueue.SimpleLinkedListQueue;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class MiniCalc2 extends JFrame implements ActionListener {
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JButton button;

    JTextArea textArea;
    JTextArea textArea2;
    JPanel panel;
    JLabel label1;
    JLabel label3;
    JMenu fileMenu;
    JMenuBar menuBar;
    JLabel result;
    JLabel label2;
    JLabel label4;
    JButton clearButton;


    SimpleLinkedListQueue x = null;

    SimpleLinkedListQueue y = null;

    public MiniCalc2() {
        setTitle("Pipisya");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(270, 280);
        setLocationRelativeTo(null);

        panel = new JPanel(new FlowLayout());
        textArea = new JTextArea(10, 10);
        textArea2 = new JTextArea(10, 10);
        textArea.setLineWrap(true);
        textArea2.setLineWrap(true);
        label1 = new JLabel("Ввидите числа через пробел:        ");
        label2 = new JLabel("X");
        label3 = new JLabel("Y");
        label4 = new JLabel("Ответ: ");
        result = new JLabel("        ");

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");


        fileMenu.add(openItem);
//        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        clearButton = new JButton("Clear");
        button = new JButton("Calc");

        clearButton.addActionListener(this);
        button.addActionListener(this);


        panel.add(menuBar);
        panel.add(label1);
        panel.add(label2);
        panel.add(textArea);
        panel.add(label3);
        panel.add(textArea2);
        panel.add(label4);
        panel.add(result);
        panel.add(button);
        panel.add(clearButton);
        add(panel);

        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cou = 0;
            if(e.getSource()==openItem) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
                fileChooser.setFileFilter(filter);

                int response = fileChooser.showOpenDialog(null);

                if (response == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    Scanner fileIn = null;
                    try {

                        fileIn = new Scanner(file);

                        if (file.isFile()) {

                            while (fileIn.hasNext()) {

                                if (cou == 0) {
                                    String line = fileIn.nextLine() + " ";
                                    textArea.append(line);
                                    cou += 1;
                                }
                                if (cou == 1){
                                    String line = fileIn.nextLine() + " ";
                                    textArea2.append(line);
                                    cou+=1;
                                }

                            }

                        }

                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } finally {
                        fileIn.close();
                    }
                }
            }

//
//            if (e.getSource() == saveItem) {
//                JFileChooser fileChooser = new JFileChooser();
//                fileChooser.setCurrentDirectory(new File("."));
//
//                int response = fileChooser.showSaveDialog(null);
//                if(response == JFileChooser.APPROVE_OPTION){
//                    File file;
//                    PrintWriter fileOut = null;
//
//                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
//
//                    try {
//                        fileOut = new PrintWriter(file);
//                        fileOut.println(Mamapopa.stepToEmpty(x, y));
//
//                    } catch (FileNotFoundException fileNotFoundException) {
//                        fileNotFoundException.printStackTrace();
//                    } finally {
//                        fileOut.close();
//                    }
//                }
//  }

            if (e.getSource() == exitItem) {
                System.exit(0);
            }

        if (e.getSource() == button) {
            try {
                x = new SimpleLinkedListQueue();
                y = new SimpleLinkedListQueue();

                String[] string1 = textArea.getText().split(" ");
                String[] string2 = textArea2.getText().split(" ");
                for (int i = 0; i < string1.length; i++) {
                    x.add(Integer.parseInt(string1[i]));
                }
                for (int i = 0; i < string2.length; i++) {
                    y.add(Integer.parseInt(string2[i]));
                }


                result.setText(String.valueOf(Mamapopa.stepToEmpty(x, y)));

            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(panel, "Некорректный ввод!");
            }
        }
        if(e.getSource() == clearButton){
            result.setText(null);
            textArea.setText(null);
            textArea2.setText(null);
        }
    }

}
