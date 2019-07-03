package diar.neo.simplemvp.feature.saved;

import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.base.BaseView;

public interface SavedContract {


     interface View extends BaseView{}

     interface Presenter extends BasePresenter<View>{}

}
