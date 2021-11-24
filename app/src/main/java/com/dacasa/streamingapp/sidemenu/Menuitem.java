package com.dacasa.streamingapp.sidemenu;


public class Menuitem {

    private int icon,code;
    private boolean isSelected;

    public Menuitem(int icon, int code) {
        this.icon = icon;
        this.code = code;
    }

    public Menuitem(int icon, int code, boolean isSelected) {
        this.icon = icon;
        this.code = code;
        this.isSelected = isSelected;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
