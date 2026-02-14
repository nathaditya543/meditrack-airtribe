package entities;

abstract class Person {
    int id;
    String name;

    Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    int getId(){
        return id;
    }

    String getName(){
        return name;
    }

}
