package com.dev.salwartales.activities.model;

/**
 * Created by amit on 2/10/2018.
 */

public interface OnBackPressedListener {

    /**
     * Callback, which is called if the Back Button is pressed.
     * Fragments that extend MainFragment can/should override this Method.
     *
     * @return true if the App can be closed, false otherwise
     */

    boolean onBackPressed();
}
