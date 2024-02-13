package com.ekstedt;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Sensor {
    private String sensorId;
    private double temp = 0;

    private PropertyChangeSupport propertyChangeSupport;

    public Sensor() {
        // Initiera propertyChangeSupport om det är null
        if (propertyChangeSupport == null) {
            propertyChangeSupport = new PropertyChangeSupport(this);
        }
    }

    public Sensor(String sensorId) {
        this.sensorId = sensorId;
    }
    public String getSensorId() {
        return sensorId;
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // Kontrollera igen om propertyChangeSupport är null och initiera det
        if (propertyChangeSupport == null) {
            propertyChangeSupport = new PropertyChangeSupport(this);
        }
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        double oldTemp = this.temp;
        this.temp = temp;

        // Kontrollera om propertyChangeSupport är null och initiera det
        if (propertyChangeSupport == null) {
            propertyChangeSupport = new PropertyChangeSupport(this);
        }

        this.propertyChangeSupport.firePropertyChange("temp", oldTemp, this.temp);
    }
}

