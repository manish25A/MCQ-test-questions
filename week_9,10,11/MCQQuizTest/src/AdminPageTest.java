import mcqquiztest.DatabaseConnect;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AdminPageTest {
    @Test
    public void AdminPageTest () {
        DatabaseConnect dbc = new DatabaseConnect();
        int expected_result =1;
        int actual_result;

        int ResultSet = 0;
        try {
//           String qurey= "insert into question (`q_id`, `question`, `rightans`, `wrong1`, `wrong2`, `wrong3`, `subject`)";
             String query = "insert into question VALUES (null,'" + "question " + "','" + "rightans " + "','" + "wrong1" + "','" + "wrong2" + "','" + "wrong3" + "','" + "subject" + "')";
            ResultSet = dbc.st.executeUpdate(query);
//            int row = dbc.st.executeUpdate(query);


        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        actual_result = ResultSet;
        assertEquals(expected_result, actual_result);

    }
}