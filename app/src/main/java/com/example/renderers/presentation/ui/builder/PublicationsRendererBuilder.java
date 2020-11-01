package com.example.renderers.presentation.ui.builder;

import com.example.renderers.domain.model.Ad;
import com.example.renderers.domain.model.Product;
import com.example.renderers.domain.model.Publication;
import com.example.renderers.presentation.ui.renderer.ActionAdRenderer;
import com.example.renderers.presentation.ui.renderer.ActionProductRenderer;
import com.example.renderers.presentation.ui.renderer.AdsRenderer;
import com.example.renderers.presentation.ui.renderer.HeaderAdsRenderer;
import com.example.renderers.presentation.ui.renderer.ProductRenderer;
import com.example.renderers.presentation.ui.renderer.ProminentProductRenderer;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.LinkedList;
import java.util.List;

public class PublicationsRendererBuilder extends RendererBuilder<Publication> {

    public PublicationsRendererBuilder() {
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
                prototypeClass = ProductRenderer.class;
            }
        }
        else if(content instanceof Ad){
            if (((Ad) content).isHeader()) {
                prototypeClass = HeaderAdsRenderer.class;
            }
            else {
                prototypeClass = AdsRenderer.class;
            }
        }
        else {
            prototypeClass = ProductRenderer.class;
        }

        return prototypeClass;
    }


    private List<Renderer<Publication>> getPublicationsRendererPrototypes() {
        List<Renderer<Publication>> prototypes = new LinkedList<>();
        //Renderer de productos
        ProductRenderer productRenderer = new ProductRenderer();
        prototypes.add(productRenderer);
        //Renderer de noticias
        AdsRenderer adsRenderer = new AdsRenderer();
        prototypes.add(adsRenderer);
        //Renderer de productos destacados
        ProminentProductRenderer prominentProductRenderer = new ProminentProductRenderer();
        prototypes.add(prominentProductRenderer);
        //Renderer de noticias con cabecera
        HeaderAdsRenderer headerAdsRenderer = new HeaderAdsRenderer();
        prototypes.add(headerAdsRenderer);
        //Renderer de noticias con las acciones
        /*ActionAdRenderer actionAdRenderer = new ActionAdRenderer(new ActionAdRenderer.Listener() {
            @Override
            public void onShowMoreButtonClicked(Ad ad) {

            }
        });
        prototypes.add(actionAdRenderer);*/
       /* ActionProductRenderer actionProductRenderer = new ActionProductRenderer(new ActionProductRenderer.Listener() {
            @Override
            public void onLikeProductCLicked(Product product) {

            }
        });
                prototypes.add(actionProductRenderer);*/

        return prototypes;
    }

}