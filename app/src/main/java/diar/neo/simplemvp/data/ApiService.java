package diar.neo.simplemvp.data;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("news.php")
    Single<List<News>>  getNews();

    @GET("banner.php")
    Single<List<Banner>> getBanners();

    @GET("cat.php")
    Single<List<Category>> getCategory();
}
