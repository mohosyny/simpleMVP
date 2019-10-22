package diar.neo.simplemvp.data.local;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import diar.neo.simplemvp.data.model.News;

@Database(entities = {News.class}, version = 1, exportSchema = false)
public abstract class NewsDataBase extends RoomDatabase {

    private static NewsDataBase instance;
    private static final String DB_NAME = "mohosyny.db";

    public synchronized static NewsDataBase getInstance(Context context) {

        if (instance == null) {

            instance = create(context);
        }

        return instance;
    }

    private static NewsDataBase create(Context context) {

        return Room.databaseBuilder(context,
                NewsDataBase.class,
                DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public abstract NewsDAO getNewsDAO();

}
