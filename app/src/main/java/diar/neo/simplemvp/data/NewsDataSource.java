package diar.neo.simplemvp.data;

import java.util.List;

import diar.neo.simplemvp.data.model.Banner;
import diar.neo.simplemvp.data.model.Category;
import diar.neo.simplemvp.data.model.News;
import io.reactivex.Single;

public interface NewsDataSource  {

    Single<List<News>> getNews();
    Single<List<Banner>> getBanners();
    Single<List<Category>>  getCats();
}
