
package mcqquiztest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Result extends JFrame implements ActionListener {
    String query;
    JButton back;
    DatabaseConnect dbc = new DatabaseConnect();
    JFrame frame;
    public static JTable table;
    int i = 0;

    Result() {
        frame = new JFrame();
        frame.setTitle("Results");
        back = new JButton("Back");
        back.setBounds(280,310 , 150, 30);
        back.setForeground(Color.decode("#99b433"));
        back.addActionListener(this);
        frame.add(back);
        back.setForeground(Color.decode("#FF420E"));
        try {
            int student_id = LoginPage.id;
            query = "Select * from result  where student_id ='" + student_id + "'";
            dbc.rs = dbc.st.executeQuery(query);
            table = new JTable();
            DefaultTableModel model = new DefaultTableModel();
            Object[] columnsName = new Object[3];
            columnsName[0] = "Id";
            columnsName[1] = "CorrectAnswer";
            columnsName[2] = "Subject";


            model.setColumnIdentifiers(columnsName);
            Object[] rowData = new Object[3];

            while (dbc.rs.next()) {


                rowData[0] = dbc.rs.getString("id");
                rowData[1] = dbc.rs.getString(2);
                rowData[2] = dbc.rs.getString(4);


                model.addRow(rowData);
            }

            table.setModel(model);


            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(10, 10, 500, 300);
            frame.setLocation(250, 110);
            frame.add(pane);
            frame.getContentPane().setBackground(Color.decode("#e3e0cf"));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Result");


            frame.setSize(700, 700);
            frame.setLayout(null);
            frame.setVisible(true);
        } catch (Exception ex) {

        }


    }

    public static void main(String[] args) {
        new Result();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("Back")) {
                new StudentPage();
                frame.dispose();

            }
        } catch (Exception el) {

        }

    }
}

