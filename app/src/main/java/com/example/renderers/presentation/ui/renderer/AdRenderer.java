package com.example.renderers.presentation.ui.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.renderers.R;
import com.example.renderers.domain.model.Ad;
import com.google.android.material.button.MaterialButton;
import com.pedrogomez.renderers.Renderer;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public abstract class AdRenderer extends Renderer<Ad> {

    @BindView(R.id.ivPhoto)
    ImageView thumbnail;
    @BindView(R.id.tvTitle)
    TextView title;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.ad_renderer, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @OnClick(R.id.cvAd)
    void onAdClicked() {
        Ad ad = getContent();
        Toast.makeText(getContext(), "Product clicked. Title = " + ad.getTitle(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void render() {
        Ad ad = getContent();
        renderThumbnail(ad);
        renderTitle(ad);
    }

    private void renderThumbnail(Ad ad) {
        Picasso.get().cancelRequest(thumbnail);
        Picasso.get()
                .load(ad.getPhoto())
                .placeholder(R.drawable.placeholder)
                .into(thumbnail);
    }

    private void renderTitle(Ad ad) {
        title.setText(ad.getTitle());
    }


    @Override
    protected void setUpView(View rootView) {
        /*
         * Implementación vacía sustituida por el uso de la biblioteca ButterKnife de Jake Wharton.
         */
    }

    @Override
    protected void hookListeners(View rootView) {
        /*
         * Implementación vacía sustituida por el uso de la biblioteca ButterKnife de Jake Wharton.
         */
    }
}
