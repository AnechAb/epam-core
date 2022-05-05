package com.epam.se02.object;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Pen {

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

        if (price != pen.price) return false;
        return manufacturerName != null ? manufacturerName.equals(pen.manufacturerName) : pen.manufacturerName == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, manufacturerName);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Pen pen = (Pen) o;
//        return price == pen.price &&
//                Objects.equals(manufacturerName, pen.manufacturerName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(price, manufacturerName);
//    }


    //    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        if (obj == null) return false;
////        if (getClass() != obj.getClass())  return false;
//        if (!(obj instanceof Pen)) return false;
//
//        Pen pen = (Pen) obj;
//
//        return price == pen.price
//                && Objects.equals(manufacturerName, pen.manufacturerName);
//
////        if (manufacturerName == null) {
////            return pen.manufacturerName == null;
////        } else {
////            return manufacturerName.equals(pen.manufacturerName);
////        }
////        return manufacturerName != null ? manufacturerName.equals(pen.manufacturerName) : pen.manufacturerName == null;
//
//    }

}

class Launcher {

    public static void main(String[] args) {
        Pen erichKrause = new Pen(10, "ErichKrause");
        Pen kores = new Pen(1000020, "Kores");
        Pen kores2 = new Pen(1000020, "Kores");

        System.out.println(erichKrause.equals(kores)); // false
        System.out.println(kores.equals(kores2)); // true

        System.out.println(kores.hashCode());
        System.out.println(kores2.hashCode());
        System.out.println(kores.hashCode() == kores2.hashCode()); // скорее всего разные

        Map<Pen, String> map = new HashMap<>();
        map.put(kores, "123");
        System.out.println(map.get(kores));
        System.out.println(map.get(kores2));

    }
}
