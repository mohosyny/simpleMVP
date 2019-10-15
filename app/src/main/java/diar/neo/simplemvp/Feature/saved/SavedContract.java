package diar.neo.simplemvp.feature.saved;

import android.content.Context;

import java.util.List;

import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.base.BaseView;
import diar.neo.simplemvp.data.model.News;

public interface SavedContract {


     interface View extends BaseView{
          void showSavedNews(List<News> news);
     }

     interface Presenter extends BasePresenter<View>{
          void getSavedNews(Context context);
     }

}
