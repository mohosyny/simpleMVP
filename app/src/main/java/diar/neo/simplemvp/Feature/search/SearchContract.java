package diar.neo.simplemvp.feature.search;

import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.base.BaseView;

public interface SearchContract {

    interface View extends BaseView{}

    interface Presenter extends BasePresenter<View>{}


}
