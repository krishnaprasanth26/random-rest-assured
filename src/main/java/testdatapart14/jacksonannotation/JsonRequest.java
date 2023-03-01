package testdatapart14.jacksonannotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JsonRequest {

    private String id;
    private String type;
    private String name;
    private String ppu;
    private Batters batters;
    private List<Topping> topping;


}
