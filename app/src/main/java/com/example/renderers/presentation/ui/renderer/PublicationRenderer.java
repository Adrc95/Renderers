package com.example.renderers.presentation.ui.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.renderers.R;
import com.example.renderers.domain.model.Publication;
import com.pedrogomez.renderers.Renderer;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class PublicationRenderer extends Renderer<Publication> {

    @BindView(R.id.ivPhoto)
    ImageView thumbnail;
    @BindView(R.id.tvTitle)
    TextView title;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.product_renderer, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @Override
    public void render() {
        Publication publication = getContent();
        renderThumbnail(publication);
        renderTitle(publication);
    }

    private void renderThumbnail(Publication publication) {
        Picasso.get().cancelRequest(thumbnail);
        Picasso.get()
                .load(publication.getPhoto())
                .placeholder(R.drawable.placeholder)
                .into(thumbnail);
    }

    private void renderTitle(Publication publication) {
        title.setText(publication.getTitle());
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
