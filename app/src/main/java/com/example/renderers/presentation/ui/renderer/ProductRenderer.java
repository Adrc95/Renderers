package com.example.renderers.presentation.ui.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.renderers.R;
import com.example.renderers.domain.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductRenderer extends PublicationRenderer {

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

    @Override
    public void render() {
        super.render();
        Product product = (Product) getContent();
        renderPrice(product);
        renderLike(product);
    }

    private void renderLike(Product product) {
        int resource = product.isLike() ? R.drawable.like_active : R.drawable.like_unactive;
        like.setImageResource(resource);
    }

    private void renderPrice(Product product) {
        price.setText(product.getPrice());
    }


    @Override
    protected void setUpView(View rootView) {
        /*
         * Empty implementation substituted with the usage of ButterKnife library by Jake Wharton.
         */
    }

}
