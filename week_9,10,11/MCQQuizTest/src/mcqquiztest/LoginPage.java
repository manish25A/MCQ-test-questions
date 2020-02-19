
package mcqquiztest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {
    JFrame frame;
    JTextField username_txt;
    JLabel username_lbl, password_lbl;
    JPasswordField password_field;
    JButton button_login, button_signup;
    String email, password, query;
  public static int id;

    LoginPage() {
        frame = new JFrame();
        frame.setTitle("Login");
        frame.setLocation(250, 110);
        username_lbl = new JLabel("UserName");
        username_lbl.setFont(new Font("Arial", Font.PLAIN,25));
        username_lbl.setForeground(Color.decode("#000000"));
        username_lbl.setBounds(150, 100, 150, 20);
        username_txt = new JTextField();
        username_txt.setBorder(BorderFactory.createLineBorder(Color.decode("#000075"), 1));
        username_txt.setPreferredSize( new Dimension( 200, 30 ) );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        username_txt.setColumns(18);
        username_txt.setBounds(300, 100, 150, 30);
        frame.add(username_lbl);
        frame.add(username_txt);


        password_lbl = new JLabel("Password");
        password_lbl.setForeground(Color.decode("#000000"));
        password_lbl.setFont(new Font("Arial", Font.PLAIN,25));
        password_lbl.setBounds(150, 150, 150, 30);
        password_field = new JPasswordField();
        password_field.setBorder(BorderFactory.createLineBorder(Color.decode("#000075"), 1));
        password_field.setPreferredSize( new Dimension( 200, 30 ) );
        password_field.setColumns(18);
        password_field.setBounds(300, 150, 150, 30);

        frame.add(password_lbl);
        frame.add(password_field);



        button_login = new JButton("Login");
        button_login.setBounds(120, 250, 200, 35);
        frame.add(button_login);
        button_login.addActionListener(this);
        button_login.setBackground(Color.   decode("#97CAEF"));

        button_signup = new JButton("Register");
        button_signup.setBounds(350, 250, 200, 35);
        frame.add(button_signup);
        button_signup.addActionListener(this);
        button_signup.setBackground(Color.decode("#CAFAFE"));

        frame.setSize(700, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        
        frame.getContentPane().setBackground(Color.decode("#e3e0cf"));
        frame.setResizable(false);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String lg = e.getActionCommand();
        if (lg == "Login") {
            try {
                DatabaseConnect dcon = new DatabaseConnect();
                email = username_txt.getText();
                password = password_field.getText();

                if (email.equals("Manish")) {
                    if (password.equals("BC")) {
                        new AdminPage();

                    } else {
                        JOptionPane.showInputDialog("Password Doesn't match");
                    }
                } else {
                    query = "select * from  registration where username='" + email + "'";
                    dcon.rs = dcon.st.executeQuery(query);
                    dcon.rs.next();
                    String Password = dcon.rs.getString(9);
                   id=dcon.rs.getInt(1);
                    if (password.equals(Password)) {
                        new StudentPage();
                    } else {
                        JOptionPane.showMessageDialog(null, "Password Doesn't match");
                    }
                }
            } catch (Exception ex) {

            }
        } else if (lg == "Register") {
            new RegisterStudent();

        }
        frame.dispose();
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
