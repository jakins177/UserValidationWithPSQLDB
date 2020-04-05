import java.sql.*;

public class DBManager {
    public void connectSample() {
        String url = "jdbc:postgresql://localhost:5432/myDB";
        String user = "user";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();;

            String sql = "SELECT id, email, name, password FROM my_users";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println(rs);

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String mame = rs.getString("name");
                String passwordField = rs.getString("password");



                System.out.println("User ID: " + id + " User email: " + email + "user name: " + mame + " user password: " + passwordField);

            }
        }
        catch(SQLException e){
            e.printStackTrace();

        }

    }

   public boolean validateUser(String userPassword, String userName, String userEmail)
   {

       String url = "jdbc:postgresql://localhost:5432/myDB";
       String user = "student";
       String password = "    ";

       try {
           Connection conn = DriverManager.getConnection(url,user,password);
           Statement stmt = conn.createStatement();

           //String sql = "SELECT id, email, name, password FROM my_users";
           String sql = "SELECT * FROM my_users where email LIKE '" + userEmail + "'" ;
           ResultSet rs = stmt.executeQuery(sql);


           if (rs.next()) {
               String sql2 = "SELECT * FROM my_users where password LIKE '" + userPassword + "'" ;

             //  System.out.println(sql2);
               ResultSet rs2 = stmt.executeQuery(sql2);

               if(rs2.next())
               {
                   return true;
               }
               else
               {
                   System.out.println("password does not match");
                   return false;
               }
           }
           else
           {
               System.out.println("unable to find email address");
               return false;
           }

       }
       catch(SQLException e){

           e.printStackTrace();
           return false;

       }


   }

    public boolean updateUser(String userPassword, String userName, String userEmail)
    {


        String url = "jdbc:postgresql://localhost:5432/myDB";
        String user = "student";
        String password = "    ";

        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();


            String sql = "SELECT * FROM my_users where email LIKE '" + userEmail + "'" ;
            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {
                String sql2 = "UPDATE my_users SET name = '" + userName + "', password= '" + userPassword + "' WHERE email = '" + userEmail + "'" ;

                //  System.out.println(sql2);
                int rs2 = stmt.executeUpdate(sql2);

                if(rs2 > 0)
                {
                  //  System.out.println("record has been updated");
                    return true;
                }
                else
                {
                    //System.out.println("did not update");
                    return false;
                }
            }
            else
            {
                System.out.println("unable to find email address");
                return false;
            }

        }
        catch(SQLException e){

            e.printStackTrace();
            return false;

        }
    }


}
