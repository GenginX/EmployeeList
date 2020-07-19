package kaczmarm;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeesList {

    private String listName;
    private List<Person> employeesList;

    public EmployeesList(String listName) {
        this.listName = listName;
        this.employeesList = new ArrayList<>();
    }

    public void printAllEmployees(){
        int listCounter = 1;
        for (Person person: employeesList) {
            System.out.println(listCounter + ". " + person.printShortData());
            listCounter++;
        }
    }

    public boolean addEmployee(Person person){
        if(person != null){
            employeesList.add(person);
            return true;
        }
        return false;
    }

    public boolean saveListToAFile(String fileName){
        String fullNameOfFile = fileName + ".txt";
        Iterator employeesIterator = employeesList.iterator();
        try {
            FileOutputStream file = new FileOutputStream(new File(fullNameOfFile));
            ObjectOutputStream object = new ObjectOutputStream(file);
            for (Person person: employeesList) {
                employeesIterator.next();
                object.writeObject(person);
                if(employeesIterator.hasNext()){
                    object.writeObject("\n");
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean removeEmployee(int employeeNumber){
        if(employeeNumber > 0 && employeeNumber <= employeesList.size()){
            employeesList.remove(employeeNumber);
            return true;
        }else {
            return false;
        }
    }



    public String getListName() {
        return listName;
    }

    public List<Person> getEmployeesList() {
        return employeesList;
    }
}
