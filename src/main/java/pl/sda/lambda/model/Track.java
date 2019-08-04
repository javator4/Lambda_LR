package pl.sda.lambda.model;

import lombok.Data;

@Data
public class Track {
    private final String name;
    private final int length;

    public Track(String resolution, int i){
        this.name = resolution;
        this.length = i;
    }
}
