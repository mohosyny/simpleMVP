package diar.neo.simplemvp.feature.category;

import java.util.List;

import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.base.BaseView;
import diar.neo.simplemvp.data.model.Category;

public interface CategoryContract {

    interface View extends BaseView {

        void showCategory(List<Category> categoryList);

        void showError(String s);

    }

    interface Presenter extends BasePresenter<View> {

        void getCategory();
    }

}
