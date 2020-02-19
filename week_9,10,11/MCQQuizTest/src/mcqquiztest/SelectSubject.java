
package mcqquiztest;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;



public class SelectSubject implements ActionListener{
    JFrame frame;
    JComboBox combobox;
    String subjectcombo[]={"java","python","C#","HTML"};
    JButton showQuestion;
    public static void main(String[] args){
        new SelectSubject();
    }
    public SelectSubject() {
        frame= new JFrame();
        combobox=new JComboBox(subjectcombo);
        combobox.setBounds(50, 60, 150, 30);
        combobox.setBackground(Color.decode("#763626"));
        frame.add(combobox);
        frame.setTitle("select subjects");
        frame.setLocation(250, 110);

        showQuestion= new JButton("Show Question");
        showQuestion.setBounds(250, 60, 150, 30);
        showQuestion.setForeground(Color.decode("#99b433"));
        showQuestion.setBackground(Color.decode("#375E97"));
        showQuestion.addActionListener(this);
        frame.add(showQuestion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setSize(600,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Show Question")){
            String subjectcombo=combobox.getItemAt(combobox.getSelectedIndex()).toString();
            System.out.println(subjectcombo);
            new QuestionList(subjectcombo);
            frame.dispose();
        }
    }

}
