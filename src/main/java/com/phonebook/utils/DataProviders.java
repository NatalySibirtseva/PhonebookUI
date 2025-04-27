package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Olivia", "Smidth", "01234567890", "wsmidth@qwe.com", "Germany", "DescOlivki"});
        list.add(new Object[]{"Olivia", "Smidth", "01234567891", "esmidth@qwe.com", "Germany", "DescOlivki"});
        list.add(new Object[]{"Olivia", "Smidth", "0123456789123", "tsmidth@qwe.com", "Germany", "DescOlivki"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contactdata.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setPhone(split[2]).setEmail(split[3]).setAddress(split[4]).setDisctiption(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
