package com.example.renderers.presentation.ui.builder;

import com.example.renderers.domain.model.Ad;
import com.example.renderers.domain.model.Product;
import com.example.renderers.domain.model.Publication;
import com.example.renderers.presentation.ui.renderer.AdRenderer;
import com.example.renderers.presentation.ui.renderer.HeaderAdsRenderer;
import com.example.renderers.presentation.ui.renderer.LikeProductRenderer;
import com.example.renderers.presentation.ui.renderer.ProductRenderer;
import com.example.renderers.presentation.ui.renderer.ProminentProductRenderer;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.LinkedList;
import java.util.List;

public class ProductRendererBuilder extends RendererBuilder<Publication> {

    public ProductRendererBuilder() {
        List<Renderer<Publication>> prototypes = getPublicationsRendererPrototypes();
        setPrototypes(prototypes);
    }


    @Override
    protected Class getPrototypeClass(Publication content) {
        Class prototypeClass;

        if(content instanceof Product) {
            if (((Product) content).isProminent()) {
                prototypeClass = ProminentProductRenderer.class;
            } else {
                prototypeClass = LikeProductRenderer.class;
            }
        }
        else if(content instanceof Ad){
            if (((Ad) content).isHeader()) {
                prototypeClass = HeaderAdsRenderer.class;
            }
            else {
                prototypeClass = AdRenderer.class;
            }
        }
        else {
            prototypeClass = ProductRenderer.class;
        }


        return prototypeClass;
    }


    private List<Renderer<Publication>> getPublicationsRendererPrototypes() {
        List<Renderer<Publication>> prototypes = new LinkedList<>();
       /* LikeProductRenderer likeVideoRenderer = new LikeProductRenderer();
        prototypes.add(likeVideoRenderer);

        FavoriteVideoRenderer favoriteVideoRenderer = new FavoriteVideoRenderer();
        prototypes.add(favoriteVideoRenderer);

        LiveVideoRenderer liveVideoRenderer = new LiveVideoRenderer();
        prototypes.add(liveVideoRenderer);*/

        return prototypes;
    }
}