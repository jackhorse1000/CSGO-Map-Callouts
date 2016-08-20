package com.example.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {
    private List<menu> mymenu = new ArrayList<menu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        populateMenuList();
        populateListView();


    }

    private void populateMenuList(){
        mymenu.add(new menu("Dust II",R.drawable.cache_background));
        mymenu.add(new menu("Mirage", R.drawable.cache_background));
        mymenu.add(new menu("Nuke", R.drawable.cache_background));
        mymenu.add(new menu("Train", R.drawable.cache_background));
        mymenu.add(new menu("Overpass", R.drawable.cache_background));
        mymenu.add(new menu("Cobblestone", R.drawable.cache_background));
        mymenu.add(new menu("Cache", R.drawable.cache_background));

    }

    private void populateListView(){
        ArrayAdapter<menu> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.mainMenuListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<menu>{
        public MyListAdapter(){
            super(MainMenu.this, R.layout.item_view, mymenu);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //Make sure we have a view to work with may have been given null

            View itemView = convertView;
                    if (itemView==null){
                        itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
                    }
            //find the menu item to work with.
            menu currentMenu = mymenu.get(position);

            //fill the view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.background);
            imageView.setImageResource(currentMenu.getBackground());

            //Make
            TextView textView = (TextView) itemView.findViewById(R.id.txtMapName);
            textView.setText(currentMenu.getMapName());

                return itemView;
//            return super.getView(position, convertView, parent);
        }




    }
}
