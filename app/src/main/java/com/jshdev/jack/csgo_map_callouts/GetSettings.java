package com.jshdev.jack.csgo_map_callouts;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by jack on 07/05/2017.
 */

class GetSettings {

    public static int getScreenWidth(Activity a) {

        Display display = a.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = a.getResources().getDisplayMetrics().density;
        float dpWidth = outMetrics.widthPixels / density;

        return (int) dpWidth;

    }
}
