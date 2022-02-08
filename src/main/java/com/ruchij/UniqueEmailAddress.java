package com.ruchij;

import com.sun.jdi.Method;

import java.util.HashSet;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> result = new HashSet<>();

        for (String email: emails) {
            result.add(normalize(email));
        }

        return result.size();
    }

    private String normalize(String email) {
        String[] emailParts = email.split("@");
        String localName =  emailParts[0].replace(".", "").split("\\+")[0];
        String domain = emailParts[1];

        return localName + "@" + domain;
    }
}
