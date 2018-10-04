package com.sam;

import lombok.Getter;
import lombok.Setter;

public class Employee {
    @Getter@Setter
    private Integer id;
    @Getter@Setter
    private String firstName;
    @Getter@Setter
    private String lastName;
    @Getter@Setter
    private Integer experience;

    private int hashCode = 0;
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Employee)) {
            return false;
        }

        Employee a = (Employee) o;
        return a.toString().equals(this.toString());
   }


    /**
     * The following overridden has method follows the lazy execution as it calcuates the hashcode only once
     */
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            //conventionally and by following the best practice initialize the result to 17
            result = 17;

            //note the use of 31 as it's the odd prime - it's a best practice and traditional
            result = 31 * result + getId().hashCode();
            result = 31 * result + getFirstName().hashCode();
            result = 31 * result + getLastName().hashCode();
            result = 31 * result + getExperience().hashCode();
            hashCode = result;
        }
        return result;
    }

    @Override
    public String toString() {
        return getId() + getFirstName() + getLastName() + getExperience();
    }
}
