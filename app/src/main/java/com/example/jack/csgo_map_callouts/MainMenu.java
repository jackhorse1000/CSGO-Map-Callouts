package com.example.jack.csgo_map_callouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        mymenu.add(new menu("Dust II", R.drawable.dust_two_background));
        mymenu.add(new menu("Mirage", R.drawable.mirage_background));
        mymenu.add(new menu("Nuke", R.drawable.nuke_background));
        mymenu.add(new menu("Train", R.drawable.train_background));
        mymenu.add(new menu("Overpass", R.drawable.overpass_background));
        mymenu.add(new menu("Cobblestone", R.drawable.cobblestone_background));
        mymenu.add(new menu("Cache", R.drawable.cache_background));

    }

    private void populateListView(){
        ArrayAdapter<menu> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.mainMenuListView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        Intent newActivity = new Intent(MainMenu.this, DustTwoActivity.class);
                        startActivity(newActivity);
                        break;


                }

            }
        });}

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

//        public void onItemClick(AdapterView parent, View v, int position, long id) {
//            String value = mymenu.get(position).toString();
//            switch(value){
//                case "value1":
//                    Intent intent = new Intent(this, DustTwoActivity.class); startActivity(intent);
//                    break;
//
////                case "value2":
////                    Intent intent = new Intent(this, activity2.class); startActivity(intent);
////                    break;
////
////                case "value3":
////                    Intent intent = new Intent(this, activity3.class); startActivity(intent);
////                    break;
//            }
//        }





    }
}
