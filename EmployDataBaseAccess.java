package maktab58.practice_1.dataBaseAccess;

import maktab58.practice_1.model.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployDataBaseAccess {
    private Connection connection = null;

    public EmployDataBaseAccess() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktab58", "root", "SAMAseven@7");
    }

    public void save(Employee employee) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select max(id_personnel) as max from employee");
            while (resultSet.next()) {
                int max = resultSet.getInt("max");
                employee.setIdPersonnel(max + 1);
            }
            String sqlQuery = String.format("insert into employee(name_employ,family_employ,id_personnel,date_birth,work_unit) " +
                            "values ('%s','%s','%d','%s','%s')", employee.getNameEmploy(),
                    employee.getFamilyEmploy(), employee.getIdPersonnel(), employee.getDateBirth(),
                    employee.getWorkUnit().getIdUnit());
            statement.executeUpdate(sqlQuery);
            System.out.println("Add employee successful");
        } else
            System.out.println("----connection is empty----");
    }

    public void update(int idPerson, String newName, String newFamily) throws SQLException {
        if (connection != null) {

            String sqlQuery = String.format("update employee set name_employ = ? , family_employ = ? where id_personnel = ?");
            PreparedStatement updateName = connection.prepareStatement(sqlQuery);
            updateName.setString(1, newName);
            updateName.setString(2, newFamily);
            updateName.setInt(3, idPerson);
            updateName.executeUpdate();
            System.out.println("Update successful");
        } else
            System.out.println("----connection is empty----");
    }

    public void show(int id) throws SQLException {

        if (connection != null) {
            String sqlQuery = String.format("select * from employee where work_unit=?");
            PreparedStatement search = connection.prepareStatement(sqlQuery);
            search.setInt(1, id);
            ResultSet resultSet = search.executeQuery();
            ArrayList<Employee> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4),
                        resultSet.getDate(5));

                arrayList.add(employee);
            }
            for (Employee employ : arrayList) {
                System.out.print("ID: " + employ.getId() + ", ");
                System.out.print("NAME : " + employ.getNameEmploy() + ", ");
                System.out.print("FAMILY : " + employ.getFamilyEmploy() + ", ");
                System.out.print("DATE BIRTHDAY : " + employ.getDateBirth() + ", ");
                System.out.print("ID_PERSONNEL : " + employ.getIdPersonnel() + ", ");
                System.out.println();
            }
        } else
            System.out.println("----connection is empty----");
    }
}

