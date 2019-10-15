package diar.neo.simplemvp.feature.saved;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import diar.neo.simplemvp.data.MyDatabase;
import diar.neo.simplemvp.data.NewsDataSource;
import diar.neo.simplemvp.data.model.News;
import diar.neo.simplemvp.feature.saved.SavedContract.View;

public class SavedPresenter implements SavedContract.Presenter {
    private SavedContract.View view;
    private List<News> newsList;
    private NewsDataSource mNewsDataSource;


    public SavedPresenter(NewsDataSource newsDataSource) {
        mNewsDataSource = newsDataSource;
        newsList=new ArrayList<>();

    }

    @Override
    public void attachView(View view) {

        this.view = view;
        getSavedNews(view.getViewContext());
    }

    @Override
    public void detachView() {
        this.view = null;
    }


    @Override
    public void getSavedNews(Context context) {
        MyDatabase database = new MyDatabase(context);
        Cursor cursor = database.getInfos();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String description = cursor.getString(2);
            String img = cursor.getString(3);
            String date = cursor.getString(4);

            News news = new News();
            news.setTitle(title);
            news.setDate(date);
            news.setImage_url(img);
            news.setDescription(description);

            newsList.add(news);
            view.showSavedNews(newsList);

        }

    }
}
