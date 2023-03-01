package testdatapart13.pojo;

public class PhoneNumber {
    private String type;
    private String number;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumber(String type, String number) {
        this.type = type;
        this.number = number;
    }



}
