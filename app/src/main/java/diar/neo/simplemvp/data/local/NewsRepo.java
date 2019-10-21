package diar.neo.simplemvp.data.local;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "news")
public class NewsRepo {
    @PrimaryKey(autoGenerate = true)
    private String id;

    private String title;
    private String description;
    private String image_url;
    private String date;



    public NewsRepo(String title, String description, String image_url, String date){

        this.title=title;
        this.description=description;
        this.image_url=image_url;
        this.date=date;
    }

}
