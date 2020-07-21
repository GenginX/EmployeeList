package kaczmarm;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        EmployeesList employeesList = new EmployeesList("Friends");
        Person person1 = new Person("Jonathan", "Switch", 'M', 9, 4500, 31, 0, false);
        Person person2 = new Person("Lee", "San", 'M', 3, 1500, 20, 0, false);
        Person person3 = new Person("Rose", "Smith", 'F', 9, 5500, 29, 1, true);
        Person person4 = new Person("Mikasa", "Yoshi", 'F', 9, 5500, 31, 1, false);
        Person person5 = new Person("Steve", "Rodgers", 'M', 3, 2500, 23, 0, true);
        Person person6 = new Person("Bill", "Sanderson", 'M', 3, 4500, 26, 2, true);
        Person person7 = new Person("Rachel", "McCarther", 'F', 9, 3500, 24, 0, true);
        Person person8 = new Person("Pieter", "Brandon", 'M', 9, 6200, 39, 3, true);
        Person person9 = new Person("Morgana", "Kylson", 'F', 3, 6400, 41, 2, true);
        Person person10 = new Person("Taylor", "Smith", 'F', 9, 3400, 35, 0, true);
        employeesList.addEmployee(person1);
        employeesList.addEmployee(person2);
        employeesList.addEmployee(person3);
        employeesList.addEmployee(person4);
        employeesList.addEmployee(person5);
        employeesList.addEmployee(person6);
        employeesList.addEmployee(person7);
        employeesList.addEmployee(person8);
        employeesList.addEmployee(person9);
        employeesList.addEmployee(person10);
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
                case 6:
                    additionalOptions6(employeesList);

            }
        }
    }

    private static void additionalOptions6(EmployeesList employeesList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Additional options:");
        System.out.println("1. Count employees with salary not less than provided");
        System.out.println("2. Count average salary in one unit");
        System.out.println("3. Print the highest salary for women and men");
        System.out.println("4. Print all units and show which sex is dominating");
        System.out.println("5. Print salary ratio between women and men");
        System.out.println("6. Give 10% salary bonus for all employees with standard bonuses for company");
        System.out.println("7. Give salary bonus provided by user");
        System.out.println("8. Sort all employees by surname (in File) - true ascending false descending");
        System.out.println("9. Sort all employees by salary (in File) - true ascending false descending");
        int input2 = scanner.nextInt();
        scanner.nextLine();
        switch (input2){
            case 1:
                System.out.println("Provide salary");
                float providedSalary = scanner.nextFloat();
                int result = employeesList.countEmployeesWithSalaryHigherThan(providedSalary);
                System.out.println("Employees with salary not less than: " + providedSalary + " is " + result);
                break;
            case 2:
                System.out.println("Provide unit");
                int unitNumberProvieded = scanner.nextInt();
                System.out.println("Average salary in unit " + unitNumberProvieded + " is: " + employeesList.countAverageSalaryInUnit(unitNumberProvieded));
                break;
            case 3:
                employeesList.printHighestSalaryPerSex();
                break;
        }

    }

}
