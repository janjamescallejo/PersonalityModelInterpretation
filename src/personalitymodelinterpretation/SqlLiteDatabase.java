/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalitymodelinterpretation;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author LENOVO
 */
public class SqlLiteDatabase {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\SQlLite3\\CMSDatabase.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            if(conn==null)
            {
                System.out.println("Connection is null");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
        public void selectAll(){
        String sql = "select * from result";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("runcode") +  " " + 
                                   rs.getInt("Sample") + " " +
                                   rs.getInt("Question")+" "+rs.getString("J48")+" "+rs.getString("NNtext")+" "+rs.getString("SVM")+" "+rs.getString("NB"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
