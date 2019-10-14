package diar.neo.simplemvp.data.model;

import com.google.gson.annotations.SerializedName;

public class Category {
    private String id;
    @SerializedName("title")
    private String cat_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
}
