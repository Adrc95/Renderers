package com.example.renderers.presentation.ui.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.renderers.R;
import com.example.renderers.domain.model.Ad;
import com.example.renderers.domain.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdsRenderer extends PublicationRenderer {

    @BindView(R.id.btnShowMore)
    Button btnShowMore;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.ad_renderer, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @Override
    public void render() {
        super.render();
        Ad ad = (Ad) getContent();
        renderButton(ad);
    }

    private void renderButton(Ad ad) {
        //btnShowMore.setText("");
    }

    @Override
    protected void setUpView(View rootView) {
        /*
         * Empty implementation substituted with the usage of ButterKnife library by Jake Wharton.
         */
    }




}
