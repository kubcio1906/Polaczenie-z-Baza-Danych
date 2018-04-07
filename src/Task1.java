import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Task1 {
    public static void main(String[] args) {
         Connection connect = null;
         Statement statement = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;

        // This will load the MySQL driver, each DB has its own driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/sklep?"
                            + "user=root&password=");

            String sqlSelect = "SELECT * FROM tproduct WHERE id =1;";
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(sqlSelect);
            System.out.println(resultSet);

            while(resultSet.next()){
                Product p = new Product();
                p.id = resultSet.getInt("id");
                p.name = resultSet.getString("name");
                p.price = resultSet.getDouble("price");
                p.amount = resultSet.getInt("amount");
                System.out.println(p.toString());
            }
            String sqlInsert = "INSERT INTO tproduct (id,name, price, amount) VALUES (?,?,?,?);";

            preparedStatement= connect.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "Woda");
            preparedStatement.setDouble(3, 1.5);
            preparedStatement.setInt(4, 5);
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();

            String sqlUpdate = "UPDATE tproduct SET name=? WHERE id =4";
            preparedStatement= connect.prepareStatement(sqlUpdate);
            preparedStatement.setString(1,"Piwo");
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();

            String sqlDelete = "DELETE FROM `tproduct` WHERE id=3";
            preparedStatement = connect.prepareStatement(sqlDelete);
            preparedStatement.clearParameters();
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
      /*  while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);

        }
        */

    }



}
