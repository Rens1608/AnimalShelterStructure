package Animals;

import Sell.ISellable;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Animal implements Serializable, ISellable {
    private Gender Gender;
    private String Name;
    private Reservor ReservedBy;
    private double Price;
    private Species Species;

    public Animal(Animals.Gender gender, String name, double price, Species species) {
        Gender = gender;
        Name = name;
        Price = price;
        Species = species;
    }

    public Animals.Gender getGender() {
        return Gender;
    }

    public void setGender(Animals.Gender gender) {
        Gender = gender;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        Name = name;
    }

    @Override
    public double getPrice(){ return Price;}

    @Override
    public void setPrice(double price){Price = price;}

    public Reservor getReservedBy() {
        return ReservedBy;
    }

    public void setReservedBy(Reservor reservedBy) {
        ReservedBy = reservedBy;
    }

    public Animals.Species getSpecies() {
        return Species;
    }

    public void setSpecies(Animals.Species species) {
        Species = species;
    }

    public boolean Reserve(String reservedBy){
        if(ReservedBy == null){
            LocalDateTime date = LocalDateTime.now();
            ReservedBy = new Reservor(reservedBy, date);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = "not reserved";
        if(ReservedBy != null){
            reserved = "reserved by: " + ReservedBy.Name;
        }
        return Name + ',' + Gender + ',' + reserved ;
    }
}
