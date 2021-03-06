package diar.neo.simplemvp.feature.home;

import java.util.List;

import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.base.BaseView;
import diar.neo.simplemvp.data.model.Banner;
import diar.neo.simplemvp.data.model.News;

public interface HomeContract {

    interface View extends BaseView {
        void showNews(List<News> news);

        void showBanners(List<Banner> banners);

        void showError(String s);
    }

    interface Presenter extends BasePresenter<View> {
        void getNewsList();

        void getBanners();
    }

}
