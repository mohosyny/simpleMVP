package diar.neo.simplemvp.data;

import java.util.List;

import diar.neo.simplemvp.data.model.Banner;
import diar.neo.simplemvp.data.model.Category;
import diar.neo.simplemvp.data.model.News;
import io.reactivex.Single;

public class LocalDataSource implements NewsDataSource {
    @Override
    public Single<List<News>> getNews() {
        return null;
    }

    @Override
    public Single<List<Banner>> getBanners() {
        return null;
    }

    @Override
    public Single<List<Category>> getCats() {
        return null;
    }

    @Override
    public Single<List<News>> getSearchedNews(CharSequence charSequence) {
        return null;
    }

}
