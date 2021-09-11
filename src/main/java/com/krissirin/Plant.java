package com.krissirin;

public class Plant {
    String name;
    int size;
    boolean isDead;
    boolean leafIsGreen;

    public Plant(String name, int size, boolean isDead,boolean leafIsGreen) {
        this.name = name;
        this.size = size;
        this.isDead = isDead;
        this.leafIsGreen = leafIsGreen;
    }

    public void toWater() {
        this.size +=1;
    }

    public void cutLeaf() {
        this.size -=1;
    }

    public void care(){
        if (this.isDead == false){
            toWater();
        }
        else if (this.leafIsGreen == false) {
            cutLeaf();
        }
        System.out.println(this.name +" "+ this.size);
    }
}
