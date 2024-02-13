package com.ekstedt;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class SensorHub implements PropertyChangeListener {
    private List<Sensor> sensors = new ArrayList<>();

    public void addSensor(Sensor sensor) {
        sensor.addPropertyChangeListener(this);
        sensors.add(sensor);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("SensorHub detected change in " + evt.getPropertyName() +
                " from sensor " + findSensorId((Sensor) evt.getSource()) +
                ": " + evt.getNewValue());
    }

    private String findSensorId(Sensor sensor) {
        for (Sensor s : sensors) {
            if (s.equals(sensor)) {
                return s.getSensorId();
            }
        }
        return "Unknown";
    }
}
