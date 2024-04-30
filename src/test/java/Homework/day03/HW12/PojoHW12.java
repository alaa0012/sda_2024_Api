package Homework.day03.HW12;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class PojoHW12 {
    private Integer id;
    private CategoryPojoHW12 category;
    private String name;
    private List<String> photoUrls;
    private List<TagPojoHW12> tags;
    private String status;

    public PojoHW12() {
    }

    public PojoHW12(Integer id, CategoryPojoHW12 category, String name, List<String> photoUrls, List<TagPojoHW12> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

}