package testdatapart13.complex;

import java.util.List;

public class Example {

    private String id;

    private String type;
    private String name;
    private float ppu;
    private Batters batters;
    private List<Topping> toppings;

    public Example(String id, String type, String name, float ppu, Batters batters, List<Topping> toppings) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.ppu = ppu;
        this.batters = batters;
        this.toppings = toppings;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPpu() {
        return ppu;
    }

    public void setPpu(float ppu) {
        this.ppu = ppu;
    }

    public Batters getBatters() {
        return batters;
    }

    public void setBatters(Batters batters) {
        this.batters = batters;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }







}
