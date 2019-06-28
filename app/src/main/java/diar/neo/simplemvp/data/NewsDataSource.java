package diar.neo.simplemvp.data;

import java.util.List;
import io.reactivex.Single;

public interface NewsDataSource  {

    Single<List<News>> getNews();
    Single<List<Banner>> getBanners();
}
