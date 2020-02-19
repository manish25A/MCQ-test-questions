package mcqquiztest;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class ExamPage implements ActionListener {
    JLabel Question_lbl;
    JRadioButton answer[]=new JRadioButton[5];
    JButton BtnNext, BtnResult;
    ButtonGroup btngroup;
    JFrame frame = new JFrame();

    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    DatabaseConnect dbc = new DatabaseConnect();

    public ArrayList id = new ArrayList();

    public String sub = "", query = "";

    ExamPage(String subject) {
        frame.setTitle("Exam Page");
        sub = subject;
        questions(sub);
        frame.setVisible(true);
        Question_lbl = new JLabel();
        frame.add(Question_lbl);
        btngroup = new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            answer[i]=new JRadioButton();
            btngroup.add(answer[i]);
            frame.add(answer[i]);
        }

        BtnNext = new JButton("Next");
        BtnNext.addActionListener(this);
        BtnNext.setForeground(Color.decode("#99b433"));
        BtnNext.setBackground(Color.decode("#375E97"));
        frame.add(BtnNext);


        question(current);
        Question_lbl.setBounds(40, 40, 500, 25);
        Question_lbl.setFont(new Font("Arial", Font.PLAIN,20));
        answer[0].setBounds(60,100,200,20);
        answer[0].setFont(new Font("Arial", Font.PLAIN,20));

        answer[1].setBounds(60,130,200,20);
        answer[1].setFont(new Font("Arial", Font.PLAIN,20));

        answer[2].setBounds(60,160,200,20);
        answer[2].setFont(new Font("Arial", Font.PLAIN,20));

        answer[3].setBounds(60,190,200,20);
        answer[3].setFont(new Font("Arial", Font.PLAIN,20));

        BtnNext.setBounds(100, 260, 100, 30);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocation(250, 110);
        frame.setSize(700, 500);
        frame.setVisible(true);

    }


    public ArrayList questions(String sub) {

        query = "Select * from question where subject ='" + sub + "'";
        try {
            dbc.rs = dbc.st.executeQuery(query);
            while (dbc.rs.next()) {
                id.add(dbc.rs.getString(1));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }

    public void question(int current) {
        try {
            String sub = "";
            ArrayList id = questions(sub);
            Collections.shuffle(id);
            System.out.println(id);

            query = "Select * from question where q_id ='" + id.get(current) + "'";

            dbc.rs = dbc.st.executeQuery(query);
            dbc.rs.next();
            String question = dbc.rs.getString(2);
            String right = dbc.rs.getString("rightAns");
            String wr1 = dbc.rs.getString(4);
            String wr2 = dbc.rs.getString(5);
            String wr3 = dbc.rs.getString(6);
            System.out.println(wr1);
            Question_lbl.setText(question);
            answer[0].setText(right);
            answer[1].setText(wr1);
            answer[2].setText(wr2);
            answer[3].setText(wr3);
            for(int i=0,j=0;i<=90;i+=30,j++)
                answer[j].setBounds(50,80+i,200,20);

        } catch (Exception e) {

        }


        Question_lbl.setBounds(30, 40, 450, 20);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Next")) {
            if (check())
                count = count + 1;
            current++;
            question(current);


            if (current == 9) {
                BtnNext.setEnabled(false);
                BtnResult = new JButton("Result");
                BtnResult.setForeground(Color.decode("#99b433"));
                BtnResult.setBackground(Color.decode("#375E97"));
                BtnResult.setBounds(220, 260, 100, 30);
                BtnResult.addActionListener(this);
                frame.add(BtnResult);

            }
        }
        if (e.getActionCommand().equals("Result")) {

            if (check())
                count = count + 1;
            current++;
            System.out.println(sub);
            JOptionPane.showMessageDialog(null, "correct ans=" + count);
            int student_id = LoginPage.id;
            query = "insert into result VALUES(null,'" + count + "','" + student_id + "','" + sub + "')";
            try {
                dbc.st.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.exit(0);

        }
    }

    public static void main(String[] args) {

        String sub = "";
        new ExamPage(sub);

    }

    boolean check() {
        if (current == 0)
            return (answer[0].isSelected());
        if (current == 1)
            return (answer[0].isSelected());
        if (current == 2)
            return (answer[0].isSelected());
        if (current == 3)
            return (answer[0].isSelected());
        if (current == 4)
            return (answer[0].isSelected());
        if (current == 5)
            return (answer[0].isSelected());
        if (current == 6)
            return (answer[0].isSelected());
        if (current == 7)
            return (answer[0].isSelected());
        if (current == 8)
            return (answer[0].isSelected());
        if (current == 9)
            return (answer[0].isSelected());
        return false;

    }
}


