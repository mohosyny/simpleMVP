package diar.neo.simplemvp.data;

import java.util.List;

import diar.neo.simplemvp.data.local.LocalDataSource;
import diar.neo.simplemvp.data.model.Banner;
import diar.neo.simplemvp.data.model.Category;
import diar.neo.simplemvp.data.model.News;
import diar.neo.simplemvp.data.server.ServerDataSource;
import io.reactivex.Single;

public class NewsRepository implements NewsDataSource {

    private LocalDataSource mLocalDataSource = new LocalDataSource();
    private ServerDataSource mServerDataSource=new ServerDataSource();


    @Override
    public Single<List<News>> getNews() {
        return mServerDataSource.getNews();
    }

    @Override
    public Single<List<Banner>> getBanners() {
        return mServerDataSource.getBanners();
    }

    @Override
    public Single<List<Category>> getCats() {
        return mServerDataSource.getCats();
    }

    @Override
    public Single<List<News>> getSearchedNews(CharSequence charSequence) {
        return mServerDataSource.getSearchedNews(charSequence);
    }


}
