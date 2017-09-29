package com.jshdev.jack.csgo_map_callouts;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jack on 07/05/2017.
 */

class MenuAdapter extends BaseAdapter implements View.OnClickListener {

    private final ArrayList<menu> menus;
    private final Context c;
    private LayoutInflater inflater = null;
    private Bitmap bmp;

    public MenuAdapter(ArrayList<menu> menus, Context c) {
        this.menus = menus;
        inflater = LayoutInflater.from(c);
        this.c = c;
    }

    @Override
    public int getCount() {
        return menus.size();

    }

    @Override
    public menu getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    /*--- initialize our Weapon Object ---*/
        menu m = menus.get(position);

        MenuHolder menuHolder;
        if (convertView == null) {
        /*--- no View is available. Inflate our list item layout and init the Views we need ---*/
            convertView = inflater.inflate(R.layout.item_view, parent, false);
            menuHolder = new MenuHolder();
            menuHolder.mapText = (TextView) convertView
                    .findViewById(R.id.txtMapName);
            menuHolder.mapBackground = (ImageView) convertView
                    .findViewById(R.id.background);

            convertView.setTag(menuHolder);
        } else {
            menuHolder = (MenuHolder) convertView.getTag();
        /*--- if convertView is not null, cancel the current loading operation to
         * improve performance and decrease RAM usage ---*/
            menuHolder.mImageLoader.cancel();
        }
    /*--- load the image in background ---*/
        menuHolder.mImageLoader = new AsyncImageSetter(c, menuHolder.mapBackground,
                m.getBackground(), bmp, menuHolder.mapText);
        menuHolder.mImageLoader.execute();
        menuHolder.mapText.setText(m.getMapName());
        menuHolder.mapBackground.setOnClickListener(this);
        return convertView;

    }

    @Override
    public void onClick(View v) {

    }

    static class MenuHolder {
        public TextView mapText;
        public ImageView mapBackground;
        public AsyncImageSetter mImageLoader;

    }


}
