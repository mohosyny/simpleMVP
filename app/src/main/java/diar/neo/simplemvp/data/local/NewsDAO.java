package diar.neo.simplemvp.data.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import diar.neo.simplemvp.data.model.News;

@Dao
public interface NewsDAO {

    @Query("SELECT * FROM news")
    List<News> getAllNews();


    @Query("SELECT * FROM news WHERE id=(:id)")
            boolean isBookmarked(int id);

  @Insert
    void insertNews(News news);

}
