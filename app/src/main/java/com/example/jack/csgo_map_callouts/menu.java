package com.example.jack.csgo_map_callouts;

/**
 * Created by jack on 17/08/2016.
 */
public class menu {
    private String mapName;
    private int background;


    public menu(String mapName, int background){
    super();
        this.background =background;
        this.mapName=mapName;
    }

    public String getMapName(){
        return mapName;
    }

    public int getBackground() {
        return background;
    }
}