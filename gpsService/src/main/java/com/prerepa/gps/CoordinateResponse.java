package com.prerepa.gps;

import java.util.ArrayList;

class CoordinateResponse {
    ArrayList<Double> latitudes = new ArrayList<>();
    ArrayList<Double> longitudes = new ArrayList<>();
    ArrayList<String> timestamps = new ArrayList<>();
    int pullStatus;
}
