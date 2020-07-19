package ru.ayupov.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class House {
    public String name;
    public String region;
    public String coatOfArms;
    public String words;

    @Override
    public String toString() {
        return String.format("%-30s|%-15s|%-25s|%-125s",
                name,
                region,
                (!words.equals("")) ? words : "-",
                (!coatOfArms.equals("")) ? coatOfArms : "-");
    }
}
