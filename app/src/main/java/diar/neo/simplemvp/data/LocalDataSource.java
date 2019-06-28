package diar.neo.simplemvp.data;

import java.util.List;

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

}
