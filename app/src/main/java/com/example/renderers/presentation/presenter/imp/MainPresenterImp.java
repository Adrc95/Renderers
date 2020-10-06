package com.example.renderers.presentation.presenter.imp;

import com.example.renderers.domain.executor.Executor;
import com.example.renderers.domain.model.Ad;
import com.example.renderers.domain.model.Product;
import com.example.renderers.domain.model.Publication;
import com.example.renderers.domain.model.RandomPublicationCollectionGenerator;
import com.example.renderers.domain.threading.MainThread;
import com.example.renderers.presentation.presenter.MainPresenter;
import com.example.renderers.presentation.presenter.base.AbstractPresenter;
import com.pedrogomez.renderers.AdapteeCollection;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImp extends AbstractPresenter implements MainPresenter {

    private View view;
    private List<Publication> publications;

    public MainPresenterImp(Executor executor, MainThread mainThread, View view) {
        super(executor, mainThread);
        this.view = view;
        generate();
    }

    @Override
    public void create() {

    }

    @Override
    public void resume() {
        RandomPublicationCollectionGenerator randomPublicationCollectionGenerator = new RandomPublicationCollectionGenerator();
        List<Publication> publications = randomPublicationCollectionGenerator.generateListPublication(120);
        view.showPublications(publications);
    }

    @Override
    public void pause() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    private void generate(){
        publications = new ArrayList<>();
        publications.add(new Product(0, "http://thetvdb.com/banners/_cache/posters/79349-24.jpg", "Producto 1","120€", true, false));
        publications.add(new Product(1, "http://thetvdb.com/banners/_cache/posters/269578-5.jpg", "Producto 2","50€", false, true));
        publications.add(new Ad(0, "http://thetvdb.com/banners/_cache/posters/73739-2.jpg", "Anuncio", "Empresa Anuncio", true));
        publications.add(new Ad(1, "http://thetvdb.com/banners/_cache/posters/257655-15.jpg", "Anuncio", "", false));

    }
}
