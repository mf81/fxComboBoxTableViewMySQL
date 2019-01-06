package sample;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDAO {

    private static MySqlConn mySqlConn = MySqlConn.getInstance();

    private static ResultSet resultSet;

    public static List<Model> getList () throws SQLException {
        List<Model> list = new ArrayList();
        try {
            resultSet = mySqlConn.getStatment("select * from tabela");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (resultSet.next()){
            Model model = new Model();
            model.setId(resultSet.getInt(1));
            model.setName(resultSet.getString(2));
            model.setNumber(resultSet.getString(3));
            list.add(model);
        }
        return list;
    }

    public static List<String> getStringList () throws SQLException {
        List<String> list = new ArrayList();
        try {
            resultSet = mySqlConn.getStatment("select * from tabela");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (resultSet.next()){
            list.add(resultSet.getString(2));
        }
        return list;
    }

    public static List<Model> getSingel (String name) throws SQLException {
        List<Model> list = new ArrayList();
        try {
            PreparedStatement preparedStatement = mySqlConn.prepSt("select * from tabela where name = ?");
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (resultSet.next()){
            Model model = new Model();
            model.setId(resultSet.getInt(1));
            model.setName(resultSet.getString(2));
            model.setNumber(resultSet.getString(3));
            list.add(model);
        }
        return list;
    }

}
