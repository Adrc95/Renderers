
package com.example.renderers.presentation.ui.renderer;


import com.example.renderers.R;
import com.example.renderers.domain.model.Product;

public class LikeProductRenderer extends ProductRenderer {

  @Override
  protected void renderLike(Product product) {
    int resource = product.isLike() ? R.drawable.like_active : R.drawable.like_unactive;
    getLike().setImageResource(resource);
  }

}
