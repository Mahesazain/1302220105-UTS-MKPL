/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

import java.time.LocalDate;

/**
 *
 * @author Mahesa
 */
public class EmploymentInfo {
    private LocalDate joinDate;
    private boolean isForeigner;

    public EmploymentInfo(LocalDate joinDate, boolean isForeigner) {
        this.joinDate = joinDate;
        this.isForeigner = isForeigner;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public boolean isIsForeigner() {
        return isForeigner;
    }
    
    
}
