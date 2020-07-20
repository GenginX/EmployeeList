package kaczmarm;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        EmployeesList employeesList = new EmployeesList("Friends");
        menu(employeesList);

    }

    private static void menu(EmployeesList employeesList){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. Print list of all employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Export");
            System.out.println("4. Remove employee");
            System.out.println("5. Edit data");
            System.out.println("6. Additional functions");

            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1:
                    employeesList.printAllEmployees();
                    break;
                case 2:
                    System.out.println("Please enter a Person details in following format: name surname sex unitNumber salary age kidsNumber maritalStatus");
                    String providedPerson = scanner.nextLine();
                    String[] splittedPerson = providedPerson.split(" ");
                    employeesList.addEmployee(new Person(splittedPerson[0], splittedPerson[1], Character.toUpperCase(splittedPerson[2].charAt(0)), Integer.parseInt(splittedPerson[3]), Float.parseFloat(splittedPerson[4]), Integer.parseInt(splittedPerson[5]), Integer.parseInt(splittedPerson[6]), Boolean.parseBoolean(splittedPerson[7])));
                    break;
                case 3:
                    System.out.println("Please enter a file name: ");
                    String providedFilename = scanner.nextLine();
                    employeesList.saveListToAFile(providedFilename);
                    break;
                case 4:
                    employeesList.printAllEmployees();
                    System.out.println("Select employee to remove");
                    int newInput = scanner.nextInt();
                    employeesList.removeEmployee(newInput);
                    break;
                case 5:
                    employeesList.printAllEmployees();
                    System.out.println("Select employee to edit");
                    int personNumber = scanner.nextInt();
                    Person person = employeesList.getPersonbyIndex(personNumber);
                    employeesList.editPerson(person);
                    break;
            }
        }
    }

}
