package maktab58.practice_1.dataBaseAccess;

import maktab58.practice_1.model.Employee;
import maktab58.practice_1.model.WorkUnit;

import java.sql.*;
import java.util.ArrayList;

public class UnitDataBaseAccess {
    Connection connection = null;

    public UnitDataBaseAccess() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktab58", "root", "SAMAseven@7");
    }
    public void save(WorkUnit workUnit) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("insert into workunit(name_unit,phone_unit) values ('%s','%s')", workUnit.getNameUnit(), workUnit.getPhoneNumber());
            statement.executeUpdate(sqlQuery);
            System.out.println("Add Work Unit Successful");
        } else
            System.out.println("----Connection Is Empty----");
    }
    public void findWorkUnit(String unitName, String name, String family, Date date) throws SQLException, ClassNotFoundException {

        if (connection != null) {

            String sqlQuery = String.format("select * from  workunit  where name_unit = ?");
            PreparedStatement findUnit = connection.prepareStatement(sqlQuery);
            findUnit.setString(1, unitName);
            ResultSet resultSet = findUnit.executeQuery();

            while (resultSet.next()) {
                EmployDataBaseAccess employDataBaseAccess = new EmployDataBaseAccess();
                WorkUnit workUnit = new WorkUnit(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                Employee employee = new Employee(name, family, date, workUnit);
                employDataBaseAccess.save(employee);
            }
        }

    }
    public void updateName(String oldName, String newName) throws SQLException {
        if (connection != null) {
            String sqlQuery = String.format("update workunit set name_unit = ? where name_unit = ?");
            PreparedStatement updateName = connection.prepareStatement(sqlQuery);
            updateName.setString(1, newName);
            updateName.setString(2, oldName);
            updateName.executeUpdate();
            System.out.println("Update Successful");
        } else
            System.out.println("----Connection Is Empty----");
    }
    public int findIdUnit(String name) throws SQLException {
        int idUnit = 0;
        String sqlQuery = String.format("select id_unit from  workunit  where name_unit = ?");
        PreparedStatement findId = connection.prepareStatement(sqlQuery);
        findId.setString(1, name);
        ResultSet resultSet = findId.executeQuery();

        while (resultSet.next()) {
            idUnit = resultSet.getInt(1);
        }
        return idUnit;
    }
    public void showUnit() throws SQLException {
        if (connection != null) {
            String sqlQuery = String.format("select * from workunit ");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ArrayList<WorkUnit> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                WorkUnit workUnit = new WorkUnit(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3));

                arrayList.add(workUnit);
            }
            for (WorkUnit unit : arrayList) {
                System.out.print("ID: " + unit.getIdUnit() + ", ");
                System.out.print("NAME : " + unit.getNameUnit() + ", ");
                System.out.print("PHONE_NUMBER : " + unit.getPhoneNumber() + ", ");
                System.out.println();
            }
        } else
            System.out.println("----Connection Is Empty----");
    }
}
