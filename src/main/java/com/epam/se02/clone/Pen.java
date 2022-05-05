package com.epam.se02.clone;

import java.util.Arrays;
import java.util.Objects;

public class Pen implements Cloneable{

    private int price;
    private String manufacturerName;

    public Pen(int price, String manufacturerName) {
        this.price = price;
        this.manufacturerName = manufacturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return price == pen.price &&
                Objects.equals(manufacturerName, pen.manufacturerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, manufacturerName);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    protected Pen clone() {
        try {
            return (Pen) super.clone();
        } catch (CloneNotSupportedException ignore) {
            throw new RuntimeException(ignore);
        }
    }

    @Override
    public String toString() {
        return "Pen{" +
                "price=" + price +
                ", manufacturerName='" + manufacturerName + '\'' +
                '}';
    }
}

class PencilCase implements Cloneable{

    private Pen[] pens = new Pen[10];
    private int cursor = 0;

    public void add(Pen pen){
        pens[cursor] = pen;
        cursor++;
    }

    public Pen[] getPens() {
        return pens;
    }

    @Override
    protected PencilCase clone(){
        try {
            PencilCase clone = (PencilCase) super.clone();
            Pen[] copyPens = Arrays.copyOf(this.pens, this.pens.length);
            for (int i = 0; i < copyPens.length; i++) {
                if (copyPens[i] != null) {
                    copyPens[i] = copyPens[i].clone();
                }
            }
            clone.pens = copyPens;
            return clone;
        } catch (CloneNotSupportedException ignore) {
            throw new RuntimeException(ignore);
        }
    }
}

class Launcher {

    public static void main(String[] args){
        Pen bic = new Pen(10,"Bic");
        Pen bic2 = new Pen(-10,"Bic2");
        Pen clone1 = bic.clone();

        PencilCase pCase = new PencilCase();

        pCase.add(bic);

        PencilCase clone = pCase.clone();

        System.out.println(pCase.getPens() == clone.getPens());
        clone.getPens()[0].setPrice(11);

        System.out.println(pCase.getPens()[0].getPrice());
//        System.out.println(pCase.getPens()[0]);
//        System.out.println(clone.getPens()[0]);

//        PencilCase clone = pCase.clone();
//        Pen[] pens = clone.getPens();
//        pens[0].setPrice(11);
//
//        System.out.println(bic.getPrice());

//        Pen clone = (Pen) bic.clone();

//        System.out.println(bic instanceof Cloneable);
//
//        System.out.println(bic == clone);
//        System.out.println(bic.equals(clone));
    }
}

