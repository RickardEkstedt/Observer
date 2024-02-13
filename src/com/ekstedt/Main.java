package com.ekstedt;

public class Main {
    public static void main(String[] args) {
        SensorHub sensorHub = new SensorHub();
        Sensor sensor1 = new Sensor("Sensor1");
        Sensor sensor2 = new Sensor("Sensor2");

        sensorHub.addSensor(sensor1);
        sensorHub.addSensor(sensor2);

        sensor1.setTemp(25.0);
        sensor2.setTemp(30.5);
    }
}