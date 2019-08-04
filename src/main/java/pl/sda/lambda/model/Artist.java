package pl.sda.lambda.model;

import lombok.Data;
import java.util.List;

@Data
public class Artist {
    private String name;
    private List<Artist> members;
    private String nationality;

    public Artist(String name, String nationality){
        this.name = name;
        this.nationality = nationality;
    }

    public Artist(String name, List<Artist> members, String nationality){
        this.name = name;
        this.members = members;
        this.nationality = nationality;
    }
}
