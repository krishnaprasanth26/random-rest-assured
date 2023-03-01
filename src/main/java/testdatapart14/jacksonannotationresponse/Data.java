package testdatapart14.jacksonannotationresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

}

