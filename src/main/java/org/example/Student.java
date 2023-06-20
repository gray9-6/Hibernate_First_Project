package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


/*
In Hibernate, the @Entity annotation is used to mark a Java class as an entity,
indicating that it should be mapped to a database table.In Hibernate,
the @Entity annotation is used to mark a Java class as an entity,
 indicating that it should be mapped to a database table.
 */
@Entity
public class Student {

    /*
    The @Id annotation is used in Hibernate/JPA to specify the primary key of an entity.
    It is applied to a field or getter method within an entity class to indicate that
     the corresponding attribute represents the primary key of the table
     */
    @Id
    private int id;
    private String name;
    private String city;



    public Student() {
        super();
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }


    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString(){
        return  "Name " + this.name + ", " + "ID " + this.id + ", " + "City " + this.city;
    }

}
