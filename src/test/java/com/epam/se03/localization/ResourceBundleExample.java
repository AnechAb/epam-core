package com.epam.se03.localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {

    public static void main(String[] args) {
//        Locale locale = new Locale("ru","RU");
        ResourceBundle bundle = ResourceBundle.getBundle("com.epam.se03.localization.strings");

        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(bundle.getString(key));
        }
    }
}
