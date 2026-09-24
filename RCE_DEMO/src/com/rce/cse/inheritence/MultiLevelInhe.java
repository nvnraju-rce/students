package com.rce.cse.inheritence;

class father {
    void house() {
        System.out.println("Father's house");
    }
}

class mother {
    void car() {
        System.out.println("Mother's car");
    }
}

// ❌ Java does not allow this
class child extends father, mother {
}
