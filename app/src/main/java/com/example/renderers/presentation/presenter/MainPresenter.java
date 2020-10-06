package com.example.renderers.presentation.presenter;


import com.example.renderers.domain.model.Publication;
import com.example.renderers.presentation.presenter.base.BasePresenter;
import com.example.renderers.presentation.ui.BaseView;

import java.util.List;

public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        void showPublications(List<Publication> publicationList);
    }
}
