package com.jshdev.jack.csgo_map_callouts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jack on 07/05/2017.
 */

public class AsyncImageSetter extends AsyncTask<Void, Void, Bitmap> {

    private final ImageView img;
    private final int image_resId;
    private final Bitmap bmp;
    private final Context c;
    private boolean cancel = false;
    private int sampleSize;
    private final TextView txtMapName;
    private Typeface font;


    public AsyncImageSetter(Context c, ImageView img, int image_ResId,
                            Bitmap bmp, TextView txtMapName) {

        this.img = img;
        this.image_resId = image_ResId;
        this.bmp = bmp;
        this.c = c;
        this.txtMapName = txtMapName;
    }

    public void cancel() {
        cancel = true;
    }

    @Override
    protected void onPreExecute() {
    /*--- we hide the Views from the user until the content is ready. This will prevent
     * the user from seeing an image being "transformed" into the next one (as a result of
     * View recycling) on slow devices.
     */
        img.setVisibility(View.GONE);
        txtMapName.setVisibility(View.GONE);
        font = Typeface.DEFAULT;
        super.onPreExecute();
        //Typeface.createFromAsset(c.getAssets(), "b_reg.otf");
    }

    @Override
    protected Bitmap doInBackground(Void... params) {

        if (!cancel) {
            try {
                return decodeAndScale(bmp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {

        img.setVisibility(View.VISIBLE);
        try {
            img.setImageBitmap(result);
        } catch (Exception e) {
        /*--- show an error icon in case something went wrong ---*/
            img.setImageResource(R.drawable.icon_warn);
        }

        txtMapName.setVisibility(View.VISIBLE);
        txtMapName.setTypeface(font);
        super.onPostExecute(result);
    }

    private Bitmap decodeAndScale(Bitmap bmp) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = setSampleSize();

        return BitmapFactory.decodeResource(c.getResources(), image_resId,
                options);

    }

    private int setSampleSize() {

        // TODO add multiple screens check
/*--- modify this method to match your needs ---*/
        if (GetSettings.getScreenWidth((Activity) c) >= 320) {
        /*--- physical width >= 480px ---*/
            sampleSize = 2;
        }

        return sampleSize;
    }}


