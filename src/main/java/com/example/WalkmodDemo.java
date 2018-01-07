package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class WalkmodDemo {

    void someMethod(String xyz) { // Unused method params

        // Violation : Unused variables
        int x = 5;

        // Violation 3 : Use isEmpty instead of size
        List list1 = new ArrayList();
        if (list1.size() > 0) {
            // do something
        }

        // Violation 4 : If loops should not be nested
        String s = "Sample";
        if (null != s) {

            if (!s.isEmpty()) {
                // do something
            }
        }

        if(s.equalsIgnoreCase("Sample")){
            //do something
        }

        // Violation 5 : Use interfaces wherever necessary
        HashSet<String> employees = new HashSet<String>();
        if (!employees.isEmpty()) {
            // do something
        }

    }
}
