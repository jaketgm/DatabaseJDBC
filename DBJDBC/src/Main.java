import java.sql.*;

public class Main
{
    public static void main(String[] args)
    {
        Connection connection = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/UNBDB.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Departments");
            while (resultSet.next())
            {
                System.out.println("Dept_id: " + resultSet.getString("dept_id")
                        + ", dept_name: " + resultSet.getString("dept_name"));
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if (connection != null)
                    {
                        connection.close();
                    }
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}