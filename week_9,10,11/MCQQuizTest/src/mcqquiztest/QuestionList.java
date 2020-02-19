
package mcqquiztest;



import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuestionList implements ActionListener {
    String query;
    DatabaseConnect dbc = new DatabaseConnect();
    JFrame frame;
    public static JTable table;
    int i = 0;


    QuestionList(String Sub) {
        try {
            

            frame= new JFrame();
            frame.setTitle("Questions");
            frame.setSize(700, 700);
            frame.setLocation(250, 110);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            table = new JTable();
            DefaultTableModel model = new DefaultTableModel();
            Object[] columnsName = new Object[6];
            columnsName[0] = "Question Id";
            columnsName[1] = "Question";
            columnsName[2] = "Right Answer";
            columnsName[3] = "Wrong Answer1";
            columnsName[4] = "Wrong Answer2";
            columnsName[5] = "Wrong Answer3";
            model.setColumnIdentifiers(columnsName);
            Object[] rowData = new Object[6];
            String sub = Sub;
            query = "Select * from question  where subject ='" + sub + "'";
            dbc.rs = dbc.st.executeQuery(query);
            while (dbc.rs.next()) {
                String que_id = dbc.rs.getString("q_id");

                 rowData[0] = que_id;
                rowData[1] = dbc.rs.getString("Question");
                rowData[2] = dbc.rs.getString("rightAns");
                rowData[3] = dbc.rs.getString("wrong1");
                rowData[4] = dbc.rs.getString("wrong2");
                rowData[5] = dbc.rs.getString("wrong3");
                model.addRow(rowData);
            }

            table.setModel(model);

            ListSelectionModel select= table.getSelectionModel();
            select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(10, 10, 500, 300);
            frame.add(pane);
            frame.getContentPane().setBackground(Color.decode("#e3e0cf"));

            JButton delete = new JButton("Delete");
            delete.setBounds(20, 550, 100, 30);
            delete.addActionListener(this);
            frame.add(delete);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionList.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void DeleteData(String Subject_id) {
        try {
            String Qno = Subject_id;
            String query = "Delete from question where q_id='" + Qno + "'";
            JOptionPane.showMessageDialog(null, "Delete Data Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sub = "";
        new QuestionList(sub);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Delete") {
            int row= table.getSelectedRow();
            String abc = table.getValueAt(row, 1).toString();
            DatabaseConnect db = new DatabaseConnect();
            String sql = "select q_id from question where question='" + abc + "'";
            try {
                db.rs = db.st.executeQuery(sql);
                db.rs.next();
                int id = db.rs.getInt("q_id");
                db.delete(id);
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


}

