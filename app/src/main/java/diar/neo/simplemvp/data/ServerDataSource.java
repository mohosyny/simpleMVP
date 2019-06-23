package diar.neo.simplemvp.data;

import java.util.List;

import diar.neo.simplemvp.base.BaseView;
import io.reactivex.Single;

public class ServerDataSource implements NewsDataSource {
    @Override
    public Single<List<News>> getNews() {
        return null;
    }

}
