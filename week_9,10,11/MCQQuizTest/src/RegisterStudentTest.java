import mcqquiztest.DatabaseConnect;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class RegisterStudentTest {
    @Test
    public void RegisterStudentTest () {
        DatabaseConnect dbc = new DatabaseConnect();
        int expected_result =1;
        int actual_result;
        int ResultSet = 0;
        try {
            String query = "insert into registration VALUES(null,'" + "manish" + "','" + "bc" + "','" + "softwarica" + "','" + "nepal" + "','" + "manysh23@gmail.com" + "','" + "9868033278" + "','" + "manish" + "','" + "password" + "')";
            ResultSet = dbc.st.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        actual_result = ResultSet;
        assertEquals(expected_result, actual_result);

    }
}