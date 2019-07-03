package diar.neo.simplemvp.data;

import java.util.List;
import java.util.SimpleTimeZone;

import io.reactivex.Single;

public interface NewsDataSource  {

    Single<List<News>> getNews();
    Single<List<Banner>> getBanners();
    Single<List<Category>>  getCats();
}
