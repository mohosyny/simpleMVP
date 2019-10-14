package diar.neo.simplemvp.feature.category;

import java.util.List;

import diar.neo.simplemvp.data.model.Category;
import diar.neo.simplemvp.data.NewsDataSource;
import diar.neo.simplemvp.feature.category.CategoryContract.View;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CategoryPresenter implements CategoryContract.Presenter {

    private CategoryContract.View mView;
    private NewsDataSource mNewsDataSource;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    CategoryPresenter(NewsDataSource newsDataSource) {
        mNewsDataSource = newsDataSource;
    }

    @Override
    public void attachView(View view) {
        mView = view;
        getCategory();
    }

    @Override
    public void detachView() {
        mView = null;
        if (mCompositeDisposable != null && mCompositeDisposable.size() > 0) {
            mCompositeDisposable.clear();
        }
    }

    @Override
    public void getCategory() {

        mNewsDataSource.getCats().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Category>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<Category> categories) {
                        mView.showCategory(categories);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.toString());
                    }
                });


    }
}
