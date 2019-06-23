package diar.neo.simplemvp.data;

import java.util.List;

import io.reactivex.Single;

public class NewsRepository implements NewsDataSource {

    private LocalDataSource mLocalDataSource = new LocalDataSource();
    private ServerDataSource mServerDataSource=new ServerDataSource();


    @Override
    public Single<List<News>> getNews() {
        return mServerDataSource.getNews();
    }
}