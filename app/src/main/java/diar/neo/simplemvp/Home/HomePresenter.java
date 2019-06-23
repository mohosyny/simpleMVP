package diar.neo.simplemvp.Home;

import java.util.List;

import diar.neo.simplemvp.data.News;
import diar.neo.simplemvp.data.NewsDataSource;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private NewsDataSource mNewsDataSource;
    private CompositeDisposable mCompositeDisposable =new CompositeDisposable();

    public HomePresenter(NewsDataSource newsDataSource) {
        mNewsDataSource = newsDataSource;

    }

    @Override
    public void getNews() {

        mNewsDataSource.getNews().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<News>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<News> news) {
                        view.showNews(news);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.toString());
                    }
                });

    }

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
        if (mCompositeDisposable != null && mCompositeDisposable.size() > 0) {
            mCompositeDisposable.clear();
        }
    }
}
