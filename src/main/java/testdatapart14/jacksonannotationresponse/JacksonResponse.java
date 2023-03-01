package testdatapart14.jacksonannotationresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JacksonResponse {

    private String page;
    private String per_page;
    private String total;
    private String total_pages;
    private List<Data> data;
    private Support support;

}
