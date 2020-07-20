package kaczmarm;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeesList {

    private String listName;
    private List<Person> employeesList;

    public EmployeesList(String listName) {
        this.listName = listName;
        this.employeesList = new ArrayList<>();
    }

    public void printAllEmployees() {
        int listCounter = 1;
        for (Person person : employeesList) {
            System.out.println(listCounter + ". " + person.printShortData());
            listCounter++;
        }
    }

    public boolean addEmployee(Person person) {
        if (person != null) {
            employeesList.add(person);
            return true;
        }
        return false;
    }

    public boolean saveListToAFile(String fileName) {
        String fullNameOfFile = fileName + ".txt";
        Iterator employeesIterator = employeesList.iterator();
        try {
            FileWriter file = new FileWriter(fullNameOfFile);
            file.write("Surname Name Age MartialStatus KidsNumber\n");
            for (Person person : employeesList) {
                employeesIterator.next();
                file.write(person.formatPersonToOutput());
                if (employeesIterator.hasNext()) {
                    file.write("\n");
                }
            }
            file.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean removeEmployee(int employeeNumber) {
        if (employeeNumber > 0 && employeeNumber <= employeesList.size()) {
            employeesList.remove(employeeNumber - 1);
            return true;
        } else {
            return false;
        }
    }

    public Person getPersonbyIndex(int i) {
        return employeesList.get(i - 1);
    }

    public void editPerson(Person person) {
        person.printShortData();
        Scanner scanner = new Scanner(System.in);
        editOptions();
        int editOptionNumber = scanner.nextInt();
        switch (editOptionNumber) {
            case 1:
                if (person.getSex() == 'K') {
                    System.out.println("Please set a surname");
                    String newSurname = scanner.nextLine();
                    person.setSurname(newSurname);
                }
                break;
            case 2:
                System.out.println("Please set an unit number");
                int newUnitNumber = scanner.nextInt();
                person.setUnitNumber(newUnitNumber);
                break;
            case 3:
                System.out.println("Please set a salary");
                float newSalary = scanner.nextFloat();
                person.setSalary(newSalary);
                break;
            case 4:
                System.out.println("Please set an age");
                int newAge = scanner.nextInt();
                person.setAge(newAge);
                break;
            case 5:
                System.out.println("Please set a number of kids");
                int newKidsNumber = scanner.nextInt();
                person.setKidsNumber(newKidsNumber);
                break;
            case 6:
                System.out.println("Please set a martial status");
                boolean newMartialStatus = scanner.nextBoolean();
                person.setMaritalStatus(newMartialStatus);
                break;
            default:
                System.out.println("Incorrect selection!");
                break;
        }
    }


    private void editOptions(){
        System.out.println("Please select field to edit:");
        System.out.println("1. Surname - only for woman");
        System.out.println("2. Unit Number");
        System.out.println("3. Salary");
        System.out.println("4. Age");
        System.out.println("5. Kids Number");
        System.out.println("6. Martial Status");
    }





    public String getListName() {
        return listName;
    }

    public List<Person> getEmployeesList() {
        return employeesList;
    }
}
