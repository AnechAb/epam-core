package com.epam.se03;

import com.epam.se02.annotations.Test;

import java.util.Locale;

public class LocalesTest {
    @Test
    void name() {
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale.getLanguage());
        System.out.println(defaultLocale.getDisplayLanguage());
        System.out.println(defaultLocale.getDisplayLanguage(Locale.CHINESE));

        for (Locale locale : Locale.getAvailableLocales()) {
//            System.out.println(locale);
        }
    }
}
