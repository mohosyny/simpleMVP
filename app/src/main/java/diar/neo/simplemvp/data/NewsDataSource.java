package diar.neo.simplemvp.data;

import java.util.List;

import diar.neo.simplemvp.base.BasePresenter;
import io.reactivex.Single;

public interface NewsDataSource  {

    Single<List<News>> getNews();
}
