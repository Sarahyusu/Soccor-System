/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccor;

/**
 *
 * @author sara
 */
public abstract class  Person {

    private String name;
    private int id;
    protected int age;

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        setAge(age);

    }

    public String getName() {
        return name;
    }

    public void SetName(String name) {
  
        this.name = name;}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

  public abstract  void setAge(int age);
 
  }
  
  


