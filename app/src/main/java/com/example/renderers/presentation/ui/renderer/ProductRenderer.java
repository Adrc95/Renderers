package com.example.renderers.presentation.ui.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.renderers.R;
import com.example.renderers.domain.model.Product;
import com.pedrogomez.renderers.Renderer;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public abstract class ProductRenderer extends Renderer<Product> {

    @BindView(R.id.ivPhoto)
    ImageView thumbnail;
    @BindView(R.id.tvTitle)
    TextView title;
    @BindView(R.id.tvPrice)
    TextView price;
    @BindView(R.id.ivLike)
    ImageView like;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.product_renderer, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @OnClick(R.id.cvProduct)
    void onProductClicked() {
        Product product = getContent();
        Toast.makeText(getContext(), "Product clicked. Title = " + product.getTitle(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void render() {
        Product product = getContent();
        renderThumbnail(product);
        renderTitle(product);
        renderPrice(product);
        renderLike(product);
    }

    private void renderThumbnail(Product product) {
        Picasso.get().cancelRequest(thumbnail);
        Picasso.get()
                .load(product.getPhoto())
                .placeholder(R.drawable.placeholder)
                .into(thumbnail);
    }

    private void renderTitle(Product product) {
        title.setText(product.getTitle());
    }

    private void renderPrice(Product product) {
        price.setText(product.getPrice());
    }

    protected ImageView getLike() {
        return like;
    }

    protected abstract void renderLike(Product product);


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
