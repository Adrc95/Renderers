package com.example.renderers.presentation.ui.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.renderers.R;
import com.example.renderers.domain.model.Ad;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderAdsRenderer extends AdsRenderer {

    @BindView(R.id.tvHeader)
    TextView tvHeader;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.header_ad_renderer, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @Override
    public void render() {
        super.render();
        renderHeader();
    }

    @Override
    protected void setUpView(View rootView) {
        /*
         * Empty implementation substituted with the usage of ButterKnife library by Jake Wharton.
         */
    }


    private void renderHeader() {
        Ad ad = (Ad) getContent();
        tvHeader.setText(ad.getTitleHeader());
    }
}
