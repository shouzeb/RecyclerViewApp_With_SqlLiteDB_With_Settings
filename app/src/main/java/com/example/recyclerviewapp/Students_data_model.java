package com.example.recyclerviewapp;

public class Students_data_model {
    private String id,name,class_;
    private int age;

 /*   public Students_data_model(String id, String name, String age, String class_) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.class_ = class_;
    }
*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }
}
