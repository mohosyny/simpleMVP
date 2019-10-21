package diar.neo.simplemvp.data.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM news")
    List<UserRepo> getAllNews();


    @Insert
    void insertAll(UserRepo... user);

}
