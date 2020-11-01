package com.example.renderers.presentation.ui.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.renderers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProminentProductRenderer extends ProductRenderer {

    @BindView(R.id.ivProminet)
    ImageView ivProminet;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.product_renderer_prominent, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @Override
    public void render() {
        super.render();
        renderProminent();
    }

    @Override
    protected void setUpView(View rootView) {
        /*
         * Empty implementation substituted with the usage of ButterKnife library by Jake Wharton.
         */
    }

    private void renderProminent() {
        ivProminet.setImageResource(R.drawable.fav_active);
    }
}
