package diar.neo.simplemvp.data;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("  ")
    Single<List<News>>  getNews();

}
