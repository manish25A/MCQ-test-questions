
package mcqquiztest;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AdminPage implements ActionListener {

    JButton Add, Reset, showQuestion, Logout;
    JTextField txt_question, txt_correct, txt_wrong1, txt_wrong2, txt_wrong3;
    JLabel question, ans_right, ans_wrong1, ans_wrong2, ans_wrong3, titlelbl,title;
    JFrame frame;
    String subject[] = {"java", "python", "C#", "HTML"};
    JComboBox combo;
    String query;
    DatabaseConnect dbc = new DatabaseConnect();


    AdminPage() {

        frame = new JFrame();
        combo = new JComboBox(subject);
        combo.setBounds(170, 60, 150, 30);
        titlelbl=new JLabel("Add question to:");
        titlelbl.setBounds(10, 60, 150, 30);
        frame.add(titlelbl);
        frame.add(combo);
        frame.setTitle("Add Questions");
        frame.setTitle("Admin Page");
        frame.setLocation(250, 110);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.dispose();

        question = new JLabel("Question Here");
        question.setBounds(10, 150, 100, 30);
        question.setFont(new Font("Serif", Font.BOLD, 15));
        question.setForeground(Color.decode("#99b433"));
        frame.add(question);

        txt_question = new JTextField();
        txt_question.setBounds(130, 150, 540, 30);
        txt_question.setFont(new Font("Serif", Font.BOLD, 15));
        txt_question.setBorder(BorderFactory.createLineBorder(Color.decode("#0084ff"), 2));
        frame.add(txt_question);

        ans_right = new JLabel("Right Answer");
        ans_right.setBounds(10, 200, 100, 30);
        ans_right.setFont(new Font("Serif", Font.BOLD, 15));
        ans_right.setForeground(Color.decode("#99b433"));
        frame.add(ans_right);


        txt_correct = new JTextField();
        txt_correct.setBounds(130, 200, 200, 30);
        txt_correct.setFont(new Font("Serif", Font.BOLD, 15));
        txt_correct.setBorder(BorderFactory.createLineBorder(Color.decode("#0084ff"), 2));

        frame.add(txt_correct);

        ans_wrong1 = new JLabel("Wrong Answer");
        ans_wrong1.setBounds(350, 200, 200, 30);
        ans_wrong1.setFont(new Font("Serif", Font.BOLD, 15));
        ans_wrong1.setForeground(Color.decode("#99b433"));

        frame.add(ans_wrong1);


        txt_wrong1 = new JTextField();
        txt_wrong1.setBounds(470, 200, 200, 30);
        txt_wrong1.setFont(new Font("Serif", Font.BOLD, 15));
        txt_wrong1.setBorder(BorderFactory.createLineBorder(Color.decode("#0084ff"), 2));

        frame.add(txt_wrong1);

        ans_wrong2 = new JLabel("Wrong Answer");
        ans_wrong2.setBounds(10, 250, 100, 30);
        ans_wrong2.setFont(new Font("Serif", Font.BOLD, 15));
        ans_wrong2.setForeground(Color.decode("#99b433"));

        frame.add(ans_wrong2);


        txt_wrong2 = new JTextField();
        txt_wrong2.setBounds(130, 250, 200, 30);
        txt_wrong2.setFont(new Font("Serif", Font.BOLD, 15));
        txt_wrong2.setBorder(BorderFactory.createLineBorder(Color.decode("#0084ff"), 2));
        frame.add(txt_wrong2);

        ans_wrong3 = new JLabel("Wrong Answer");
        ans_wrong3.setBounds(350, 250, 200, 30);
        ans_wrong3.setFont(new Font("Serif", Font.BOLD, 15));
        ans_wrong3.setForeground(Color.decode("#99b433"));

        frame.add(ans_wrong3);


        txt_wrong3 = new JTextField();
        txt_wrong3.setBounds(470, 250, 200, 30);
        txt_wrong3.setFont(new Font("Serif", Font.BOLD, 15));
        txt_wrong3.setBorder(BorderFactory.createLineBorder(Color.decode("#0084ff"), 2));
        frame.add(txt_wrong3);

        Add = new JButton("Add");
        Add.setFont(new Font("Serif", Font.BOLD, 20));
        Add.setBackground(Color.decode("#006266"));

        Add.setBounds(130, 350, 200, 40);
        Add.addActionListener(this);
        frame.add(Add);

        Reset = new JButton("Reset");
        Reset.setFont(new Font("Serif", Font.BOLD, 20));
        Reset.setBackground(Color.decode("#009432"));

        Reset.setBounds(470, 350, 200, 40);
        frame.add(Reset);

        title = new JLabel("View Modules Questions");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setForeground(Color.decode("#99b433"));
        title.setBounds(200, 400, 400, 100);
        frame.add(title);

        showQuestion = new JButton("Show Question");
        showQuestion.setBounds(110, 500, 150, 30);
        showQuestion.setForeground(Color.decode("#99b433"));

        showQuestion.addActionListener(this);
        frame.add(showQuestion);
        showQuestion.setForeground(Color.decode("#FF420E"));

        Logout = new JButton("Logout");
        Logout.setBounds(280, 500, 150, 30);
        Logout.setForeground(Color.decode("#99b433"));
        Logout.addActionListener(this);
        frame.add(Logout);
        Logout.setForeground(Color.decode("#FF420E"));


        frame.setSize(700, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#e3e0cf"));
        frame.setResizable(false);

    }

    public static void main(String[] args) {
        new AdminPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            try {
                String question = txt_question.getText();
                String ans_right = txt_correct.getText();
                String ans_wrong1 = txt_wrong1.getText();
                String ans_wrong2 = txt_wrong2.getText();
                String ans_wrong3 = txt_wrong3.getText();
                String subject = combo.getItemAt(combo.getSelectedIndex()).toString();
                query = "insert into question VALUES(null,'" + question + "','" + ans_right + "','" + ans_wrong1 + "','" + ans_wrong2 + "','" + ans_wrong3 + "','" + subject + "')";
                int row = dbc.st.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Successful");
            txt_question.setText("");
            txt_correct.setText("");
            txt_wrong1.setText("");
            txt_wrong2.setText("");
            txt_wrong3.setText("");

        } else if (e.getActionCommand().equals("Show Question")) {
            new SelectSubject();

        } else if (e.getActionCommand().equals("Logout")) {
            new LoginPage();
            frame.dispose();
        }

    }
}
