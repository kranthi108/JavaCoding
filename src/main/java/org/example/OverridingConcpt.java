package org.example;

public class OverridingConcpt {

}

class A {
    AA man() {
        System.out.println("kdfd");
        return new AA();
    }
}
class B extends A {
    BB man() {
        return new BB();
    }
}
class AA {

}
class BB extends AA {

}
