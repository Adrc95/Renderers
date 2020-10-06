package com.example.renderers.presentation.presenter.base;

public interface BasePresenter {

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or FragmentUtils) onCreate() method.
     */
    void create();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or FragmentUtils) onResume() method.
     */
    void resume();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (Activity or FragmentUtils) onPause() method.
     */
    void pause();


    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (Activity or FragmentUtils) onStart() method.
     */
    void start();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (Activity or FragmentUtils) onStop() method.
     */
    void stop();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or FragmentUtils) onDestroy() method.
     */
    void destroy();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or FragmentUtils) onBackPressed() method.
     */
    //void onBackPressed();


}
