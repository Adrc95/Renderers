package com.example.renderers.presentation.ui.renderer;

import com.example.renderers.R;
import com.example.renderers.domain.model.Product;

import butterknife.OnClick;

public class ActionProductRenderer extends ProductRenderer {

    private Listener likeItemListener;

    public interface Listener {

        void onLikeProductCLicked(Product product);
    }

    public ActionProductRenderer(Listener likeItemListener) {
        this.likeItemListener = likeItemListener;
    }

    @OnClick(R.id.ivLike)
    void clickOnLike() {
        //getContent().setLike(!getContent().isLike());
        //renderMarker(getContent());
        likeItemListener.onLikeProductCLicked((Product) getContent());
    }
}
