
package mcqquiztest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;


public class RegisterStudent extends JFrame implements ActionListener {


    JLabel lbl_signup, fname_lbl, lname_lbl, collegename_lbl, countryname_lbl, email_lbl, phone_lbl;
    JTextField fnametxt, lnametxt, collegenametxt, countrytxt, emailtxt, phonetxt;
    JButton Btn_submit, Btn_clear;
    String query;
    JCheckBox terms;

    DatabaseConnect dbc = new DatabaseConnect();

    RegisterStudent() {

        setVisible(true);
        setSize(800,
                600);
        setLayout(null);
        setLocation(250, 110);

       setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Registration Form ");
        lbl_signup = new JLabel("Signup here:");
        lbl_signup.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_signup.setForeground(Color.decode("#99b433"));

        fname_lbl = new JLabel("First Name:");
        fname_lbl.setForeground(Color.decode("#2c3e50"));

        lname_lbl = new JLabel("Last Name:");
        lname_lbl.setForeground(Color.decode("#2c3e50"));

        collegename_lbl = new JLabel("Collage Name:");
        collegename_lbl.setForeground(Color.decode("#2c3e50"));

        countryname_lbl = new JLabel("Country:");
        countryname_lbl.setForeground(Color.decode("#2c3e50"));

        email_lbl = new JLabel("Email:");
        email_lbl.setForeground(Color.decode("#2c3e50"));

        phone_lbl = new JLabel("Phone No:");
        phone_lbl.setForeground(Color.decode("#2c3e50"));

        terms = new JCheckBox("Accept Terms And Conditions.");

        fnametxt = new JTextField();
        fnametxt.setBorder(BorderFactory.createLineBorder(Color.decode("#763626"), 2));

        lnametxt = new JTextField();
        lnametxt.setBorder(BorderFactory.createLineBorder(Color.decode("#763626"), 2));

        collegenametxt = new JTextField();
        collegenametxt.setBorder(BorderFactory.createLineBorder(Color.decode("#763626"), 2));

        countrytxt = new JTextField();
        countrytxt.setBorder(BorderFactory.createLineBorder(Color.decode("#763626"), 2));

        emailtxt = new JTextField();
        emailtxt.setBorder(BorderFactory.createLineBorder(Color.decode("#763626"), 2));

        phonetxt = new JTextField();
        phonetxt.setBorder(BorderFactory.createLineBorder(Color.decode("#763626"), 2));

        Btn_submit = new JButton("Submit");
        Btn_clear = new JButton("Clear");

        Btn_submit.addActionListener(this);
        Btn_clear.addActionListener(this);

        Btn_submit.setBackground(Color.decode("#FB6542"));
        Btn_clear.setBackground(Color.decode("#375E97"));

        lbl_signup.setBounds(100, 30, 400, 30);

        fname_lbl.setBounds(80, 70, 200, 30);

        lname_lbl.setBounds(80, 110, 200, 30);

        collegename_lbl.setBounds(80, 150, 200, 30);

        countryname_lbl.setBounds(80, 190, 200, 30);

        email_lbl.setBounds(80, 230, 200, 30);

        phone_lbl.setBounds(80, 270, 200, 30);

        terms.setBounds(80, 300, 200, 30);


        fnametxt.setBounds(300, 70, 200, 30);

        lnametxt.setBounds(300, 110, 200, 30);

        collegenametxt.setBounds(300, 150, 200, 30);

        countrytxt.setBounds(300, 190, 200, 30);

        emailtxt.setBounds(300, 230, 200, 30);

        phonetxt.setBounds(300, 270, 200, 30);

        Btn_submit.setBounds(50, 350, 100, 30);

        Btn_clear.setBounds(170, 350, 100, 30);

        add(lbl_signup);

        add(fname_lbl);

        add(fnametxt);

        add(lname_lbl);

        add(lnametxt);

        add(collegename_lbl);

        add(collegenametxt);

        add(countryname_lbl);

        add(email_lbl);

        add(countrytxt);

        add(phone_lbl);

        add(emailtxt);
        add(phonetxt);
        add(terms);
        add(Btn_submit);
        add(Btn_clear);
        repaint();
        setResizable(false);
        getContentPane().setBackground(Color.decode("#e3e0cf"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public static void main(String[] args) {
        new RegisterStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            if (fnametxt.getText().isEmpty() || lnametxt.getText().isEmpty() || collegenametxt.getText().isEmpty() || countrytxt.getText().isEmpty() || emailtxt.getText().isEmpty() || phonetxt.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please field all fields");
            } else if (terms.isSelected()) {
                String firstname = fnametxt.getText();

                String lastname = lnametxt.getText();

                String collage = collegenametxt.getText();

                String country = countrytxt.getText();

                String email = emailtxt.getText();

                String phone = emailtxt.getText();


                Random rand = new Random();
                int num = rand.nextInt(10000);
                String username = firstname + num;

                int num1 = rand.nextInt(20000);
                String password = lastname + num1;

                try {
                    query = "insert into registration VALUES(null,'" + firstname + "','" + lastname + "','" + collage + "','" + country + "','" + email + "','" + phone + "','" + username + "','" + password + "')";
                    dbc.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "username: " + username + "password: " + password);
                    remove();
                    new LoginPage();
                    dispose();

                } catch (SQLException ex) {
                    System.out.println("Database Error");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Accept Terms and Conditions.");
            }

        } else if (e.getSource() == Btn_clear) {
            String def = "";
            fnametxt.setText(def);
            lnametxt.setText(def);
            collegenametxt.setText(def);
            countrytxt.setText(def);
            emailtxt.setText(def);
            phonetxt.setText(def);
            terms.setSelected(false);


        }
    }

    void remove() {
        fnametxt.setText("");
        lnametxt.setText("");
        collegenametxt.setText("");
        countrytxt.setText("");
        emailtxt.setText("");
        phonetxt.setText("");
    }
}


