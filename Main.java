package maktab58.practice_1;

import maktab58.practice_1.dataBaseAccess.EmployDataBaseAccess;
import maktab58.practice_1.dataBaseAccess.UnitDataBaseAccess;
import maktab58.practice_1.model.WorkUnit;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        EmployDataBaseAccess employDataBaseAccess = new EmployDataBaseAccess();
        UnitDataBaseAccess unitDataBaseAccess = new UnitDataBaseAccess();
        Scanner scanner = new Scanner(System.in);
        System.out.println("select action  \n 1.Add New Employee     2.Add New Work Unit     3.update     " +
                " 4.show list of employ     5.show list Of work_Unit: ");
        String input = scanner.next();
        int choice;
        if (isNumeric(input)) {
            choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    addEmploy();
                    break;
                case 2:
                    addWorkUnit();
                    break;
                case 3:
                    System.out.println("Select Item       1.Update Name & Family Of Employee      " +
                            "2.Update Name Of Work Unit");
                    input = scanner.next();
                    if (isNumeric(input))
                        update(Integer.parseInt(input));
                    else
                        System.out.println("entered is not digit");
                    break;
                case 4:
                    System.out.println("Enter name of work unit");
                    int id = unitDataBaseAccess.findIdUnit(scanner.next());
                    employDataBaseAccess.show(id);
                    break;
                case 5:
                    unitDataBaseAccess.showUnit();
                    break;
            }
        }


    }

    public static boolean isNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void addEmploy() throws SQLException, ClassNotFoundException {
        EmployDataBaseAccess employDataBaseAccess = new EmployDataBaseAccess();
        UnitDataBaseAccess unitDataBaseAccess = new UnitDataBaseAccess();
        WorkUnit workUnit = new WorkUnit();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter name & family & work unit");
        String name = scanner.next();
        String family = scanner.next();
        String unit = scanner.next();
        System.out.println("enter date birthday(yyyy-mm-dd) ");
        Date date = Date.valueOf(scanner.next());
        unitDataBaseAccess.findWorkUnit(unit, name, family, date);

    }

    public static void addWorkUnit() throws SQLException, ClassNotFoundException {
        UnitDataBaseAccess unitDataBaseAccess = new UnitDataBaseAccess();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter name & phoneNumber of work unit  : ");
        WorkUnit workUnit = new WorkUnit(scanner.next(), scanner.next());
        unitDataBaseAccess.save(workUnit);


    }

    public static void update(int choice) throws SQLException, ClassNotFoundException {
        EmployDataBaseAccess employDataBaseAccess = new EmployDataBaseAccess();
        UnitDataBaseAccess unitDataBaseAccess = new UnitDataBaseAccess();
        Scanner scanner = new Scanner(System.in);
        String newName;
        switch (choice) {
            case 1:
                System.out.println("enter id_personnel of employ");
                int id = scanner.nextInt();
                System.out.println("enter newName & newFamily of employ");
                newName = scanner.next();
                String newFamily = scanner.next();
                employDataBaseAccess.update(id, newName, newFamily);
                break;
            case 2:

                System.out.println("enter name of work unit");
                String oldName = scanner.next();
                System.out.println("enter New name of work unit");
                newName = scanner.next();
                unitDataBaseAccess.updateName(oldName, newName);
                break;
        }

    }
}