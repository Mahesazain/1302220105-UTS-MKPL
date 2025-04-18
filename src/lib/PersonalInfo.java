/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

/**
 *
 * @author Mahesa
 */
public class PersonalInfo {
 
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
     
    PersonalInfo(String firstName, String lastName, String idNumber, String address, boolean gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getAddress() {
        return address;
    }
    
    
}

