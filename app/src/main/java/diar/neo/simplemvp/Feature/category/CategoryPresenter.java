package diar.neo.simplemvp.Feature.category;

import diar.neo.simplemvp.Feature.category.CategoryContract.View;

public class CategoryPresenter implements CategoryContract.Presenter {

    private CategoryContract.View mView;

    @Override
    public void attachView(View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
