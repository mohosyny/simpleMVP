package diar.neo.simplemvp.data.server;

import java.util.List;

import diar.neo.simplemvp.data.model.Banner;
import diar.neo.simplemvp.data.model.Category;
import diar.neo.simplemvp.data.model.News;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("news.php")
    Single<List<News>>  getNews();

    @GET("banner.php")
    Single<List<Banner>> getBanners();

    @GET("cat.php")
    Single<List<Category>> getCategory();

    @GET("search.php")
    Single<List<News>> getSearchedNews(@Query("search") String string);
}
