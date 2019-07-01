package diar.neo.simplemvp.Feature.search;

import diar.neo.simplemvp.base.BasePresenter;
import diar.neo.simplemvp.base.BaseView;

public interface SearchContract {

    interface View extends BaseView{}

    interface Presenter extends BasePresenter<View>{}


}
