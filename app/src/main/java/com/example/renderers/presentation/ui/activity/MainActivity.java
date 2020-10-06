package com.example.renderers.presentation.ui.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.renderers.R;
import com.example.renderers.domain.executor.imp.ThreadExecutor;
import com.example.renderers.domain.model.Ad;
import com.example.renderers.domain.model.Product;
import com.example.renderers.domain.model.Publication;
import com.example.renderers.domain.model.RandomPublicationCollectionGenerator;
import com.example.renderers.domain.threading.imp.MainThreadImp;
import com.example.renderers.presentation.presenter.MainPresenter;
import com.example.renderers.presentation.presenter.imp.MainPresenterImp;
import com.example.renderers.presentation.ui.renderer.HeaderAdsRenderer;
import com.example.renderers.presentation.ui.renderer.LikeProductRenderer;
import com.example.renderers.presentation.ui.renderer.ProminentProductRenderer;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private MainPresenter presenter;
    private RVRendererAdapter<Publication> adapter;

    @BindView(R.id.rvRenderers)
    RecyclerView rvRenderers;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if(presenter == null) {
            presenter = new MainPresenterImp(ThreadExecutor.getInstance(), MainThreadImp.getInstance(), this);
        }
        initAdapter();
        initRecyclerView();
    }


    private void initRecyclerView() {
        rvRenderers.setLayoutManager(new GridLayoutManager(this, 2));
        rvRenderers.setAdapter(adapter);
    }

    private void initAdapter() {
        RendererBuilder<Publication> rendererBuilder = new RendererBuilder<Publication>()
                .bind(Product.class, new ProminentProductRenderer())
                .bind(Product.class, new LikeProductRenderer())
                .bind(Ad.class, new HeaderAdsRenderer());

        adapter = new RVRendererAdapter<>(rendererBuilder, new ListAdapteeCollection<>());
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void onPause(){
        super.onPause();
        presenter.pause();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }

    @Override
    public void showPublications(List<Publication> publicationList) {
        adapter.diffUpdate(publicationList);
    }
}
