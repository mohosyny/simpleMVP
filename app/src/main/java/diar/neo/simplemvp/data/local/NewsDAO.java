package diar.neo.simplemvp.data.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NewsDAO {

    @Query("SELECT * FROM NewsRepo")
    List<NewsRepo> getAllNews();


    @Insert
    void insertAll(NewsRepo... user);

}
