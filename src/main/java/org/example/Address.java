package org.example;


import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "student_address")
public class Address {

    @Id  // is to make primary key
    // generated value is for autoincrement and that have a parameter strategy ,, and we have to tell that
    // valu auto increment hogi wo kis tarah se hogi,, sequence mein hogi ya indentity mein hogi
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private int adressId;

    @Column(length = 50,name = "STREET")
    private String street;

    @Column(length = 100)
    private String city;

    @Column(name = "is_Open")
    private boolean isOpen;

    @Transient
    private double x;

    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)  // isse bs date aayegi ,, time nahi
    private Date addedDate;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    public Address() {
    }

    public Address(int adressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
        this.adressId = adressId;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    public int getAdressId() {
        return adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
