
package mcqquiztest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentPage implements ActionListener {
    String subjectcombo[] = {"java", "python", "C#", "HTML"};
    JComboBox combobox;
    JFrame frame;
    JButton testbtn, resultbtn;
    public static String sub;

    StudentPage() {
        frame = new JFrame();
        frame.setLocation(250, 110);
        combobox = new JComboBox(subjectcombo);
        combobox.setBounds(150, 200, 150, 30);

        frame.add(combobox);
        combobox.setBackground(Color.decode("#7DA3A1"));
        frame.setTitle("Select subject to give exam.");
        testbtn = new JButton("Take Test");
        testbtn.setBounds(80, 300, 150, 30);
        testbtn.addActionListener(this);
        testbtn.setForeground(Color.decode("#99b433"));
        testbtn.setBackground(Color.decode("#375E97"));
        frame.add(testbtn);

        resultbtn = new JButton("Result");
        resultbtn.setBounds(300, 300, 150, 30);
        resultbtn.addActionListener(this);
        resultbtn.setForeground(Color.decode("#99b433"));
        resultbtn.setBackground(Color.decode("#375E97"));
        frame.add(resultbtn);

        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new StudentPage();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Take Test")) {
            String sub = combobox.getItemAt(combobox.getSelectedIndex()).toString();
            new ExamPage(sub);
            frame.dispose();
        } else if (e.getActionCommand().equals("Result")) {
            new Result();
            frame.dispose();

        }
    }
}

