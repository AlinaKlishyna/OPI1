package com.company;

public class Main {

    public static void main(String[] args) {
        Station statrad2 = new Radio2();
        Radio radio = new Radio();
        radio.setStation(statrad2);

        for(int i=0; i<10; i++){
            radio.play();
            radio.nextStation();
        }
    }
}

//state
interface Station{
    void play();
}

class Radio1 implements Station{
    public void play() {
        System.out.println("Радио 1...");
    }
}
class Radio2 implements Station{
    public void play() {
        System.out.println("Радио 2...");
    }
}
class Radio3 implements Station{
    public void play() {
        System.out.println("Радио 3...");
    }
}

//context
class Radio{
    Station station;
    void setStation(Station st){
        station = st;
    }
    void nextStation(){
        if(station instanceof Radio1){
            setStation(new Radio2());
        }
        else if(station instanceof Radio2){
            setStation(new Radio3());
        }
        else if(station instanceof Radio3){
            setStation(new Radio1());
        }
    }
    void play(){
        station.play();
    }
}