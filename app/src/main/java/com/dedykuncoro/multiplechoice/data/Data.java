package com.dedykuncoro.multiplechoice.data;

/**
 * Created by Kuncoro on 20/03/2016.
 */
public class Data {
    private String menu;
    private boolean check;

    public Data() {}

    public Data(String menu, boolean check) {
        this.menu = menu;
        this.check = check;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public boolean isCheckbox() {
        return check;
    }

    public void setCheckbox(boolean check) {
        this.check = check;
    }
}
