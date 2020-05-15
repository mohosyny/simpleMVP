package diar.neo.simplemvp.feature.saved;

import android.content.Context;

import java.util.List;

import diar.neo.simplemvp.data.local.NewsDataBase;
import diar.neo.simplemvp.data.model.News;
import diar.neo.simplemvp.feature.saved.SavedContract.View;

public class SavedPresenter implements SavedContract.Presenter {
    private SavedContract.View view;
   // private List<News> newsList;
  //  private NewsDataSource mNewsDataSource;


//    public SavedPresenter(NewsDataSource newsDataSource) {
//        mNewsDataSource = newsDataSource;
//        newsList=new ArrayList<>();
//
//    }

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

        List<News>  news = NewsDataBase.getInstance(context).getNewsDAO().getAllNews();
            view.showSavedNews(news);
        }

    }

