package kaczmarm;

import org.apache.commons.lang3.text.WordUtils;

import java.io.Serializable;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Person implements Serializable {

    private String name;
    private String surname;
    private char sex;
    private int unitNumber;
    private float salary;
    private int age;
    private int kidsNumber;
    private boolean maritalStatus;

    public Person(String name, String surname, char sex, int unitNumber, float salary, int age, int kidsNumber, boolean maritalStatus) {
        this.name = convertToCamelCase(name);
        this.surname = convertToCamelCase(surname);
        this.sex = Character.toUpperCase(sex);
        this.unitNumber = unitNumber;
        this.salary = salary;
        this.age = age;
        this.kidsNumber = kidsNumber;
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", unitNumber=" + unitNumber +
                ", salary=" + salary +
                ", age=" + age +
                ", kidsNumber=" + kidsNumber +
                ", maritalStatus=" + maritalStatus +
                '}';
    }

    public String printAllData(){
        return "Imie: " + name + " Nazwisko:  " + surname + " " + " Wiek: " + age + " Płeć: " + sex + "\n" + "Numer dzialu: " + unitNumber + " Pensja " + salary + "\n" + "Liczba dzieci: " + kidsNumber + " Stan Cywilny " + maritalStatus;
    }

    public String printShortData(){
        return "Imie: " + name + " Nazwisko:  " + surname + " Pensja " + salary;
    }

    public String specialPrintData(){
        return "Imie: " + name.toUpperCase() + " Nazwisko:  " + surname.toUpperCase();
    }

    public boolean isSalaryHigherThan(float valueToCompare){
        return salary > valueToCompare;
    }

    public float countSalaryBonus(float percentValue){
        float kidsNumberBonus = 2 * kidsNumber / 100F;
        float maritalStatusBous = 0;
        if(maritalStatus){
            maritalStatusBous = 0.03F;
        }
        float newSalary = salary + (salary * kidsNumberBonus) + (salary * maritalStatusBous) + (salary * percentValue);
        return newSalary;
    }

    private String convertToCamelCase(String string){
        StringBuilder stringBuilder = new StringBuilder();
        if(string != null  && !string.isEmpty()){
            char[] stringCharArray = string.toCharArray();
            for (int i = 0; i < stringCharArray.length; i++) {
                if(i == 0){
                    stringCharArray[i] = Character.toTitleCase(stringCharArray[i]);
                }else {
                    stringCharArray[i] = Character.toLowerCase(stringCharArray[i]);
                }
                stringBuilder.append(stringCharArray[i]);
            }
        }
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public char getSex() {
        return sex;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getKidsNumber() {
        return kidsNumber;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setKidsNumber(int kidsNumber) {
        this.kidsNumber = kidsNumber;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
