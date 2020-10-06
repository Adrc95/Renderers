package com.example.renderers.presentation.ui.renderer;


import com.example.renderers.R;
import com.example.renderers.domain.model.Ad;

import butterknife.OnClick;

public class ActionAdRenderer extends AdRenderer {

    private Listener showItemListener;

    public interface Listener {

        void onShowMoreButtonClicked(Ad ad);
    }

    public ActionAdRenderer(Listener showItemListener) {
        this.showItemListener = showItemListener;
    }

    @OnClick(R.id.btnShowMore)
    void clickOnDelete() {
        showItemListener.onShowMoreButtonClicked(getContent());
    }

    @OnClick(R.id.cvAd)
    void onAdClicked() {
        showItemListener.onShowMoreButtonClicked(getContent());
    }

}
