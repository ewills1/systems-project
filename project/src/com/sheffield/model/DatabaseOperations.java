package com.sheffield.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class DatabaseOperations {

    // Get All books over the due date
    public ResultSet getBooksOverDueDate(Connection connection) throws SQLException {
        ResultSet resultSet = null;

        try {

            String sqlQuery = "SELECT b.memberID, b.forename, b.surname, t.title, t.isbn, c.copyID, m.dueDate" +
                "FROM Borrower b, BookTitle t, BookCopy c, Loan m" +
                "WHERE m.duedate < CURRENT_DATE" +
                "AND m.copyID = c.copyID" +
                "AND m.memberID = b.memberID";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery(sqlQuery);
        
        } catch (Exception e){
            e.printStackTrace();
        }

        return resultSet;
    }
}
