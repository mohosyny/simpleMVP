package diar.neo.simplemvp.Home;

import java.util.List;

import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.base.BaseView;
import diar.neo.simplemvp.data.News;

public interface HomeContract  {

     interface View extends BaseView{

         void showNews(List<News> news);
         void showError(String s);

     }

     interface Presenter extends BasePresenter<View>{

         void getNews();

     }


}
