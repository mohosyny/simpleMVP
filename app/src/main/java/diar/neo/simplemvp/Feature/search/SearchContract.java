package diar.neo.simplemvp.feature.search;

import java.util.List;

import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.base.BaseView;
import diar.neo.simplemvp.data.model.News;

public interface SearchContract {

    interface View extends BaseView{
         void showSearchedNews(List<News> news);
         void showError(String error);

    }

    interface Presenter extends BasePresenter<View>{

        void  getSearchedNews(CharSequence charSequence);
    }


}
