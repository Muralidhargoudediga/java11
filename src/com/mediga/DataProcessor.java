package com.mediga;

public class DataProcessor {
    public boolean parse(String line) {
        if(line.length()%2 == 0) {
            return true;
        }
        return false;
    }
}
