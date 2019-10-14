package diar.neo.simplemvp.data;

import java.util.List;

import diar.neo.simplemvp.Constants;
import diar.neo.simplemvp.data.model.Banner;
import diar.neo.simplemvp.data.model.Category;
import diar.neo.simplemvp.data.model.News;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerDataSource implements NewsDataSource {


    private ApiService mApiService;

    public ServerDataSource (){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

               mApiService=retrofit.create(ApiService.class);

    }

    @Override
    public Single<List<News>> getNews() {
        return mApiService.getNews();
    }

    @Override
    public Single<List<Banner>> getBanners() {
        return mApiService.getBanners();
    }

    @Override
    public Single<List<Category>> getCats() {
        return mApiService.getCategory();
    }

    @Override
    public Single<List<News>> getSearchedNews(CharSequence charSequence) {
        return mApiService.getSearchedNews(charSequence.toString());
    }



}
