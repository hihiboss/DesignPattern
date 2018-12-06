package View;

import java.util.ArrayList;

public class CompositeGUI implements UpdateObserver {
    private String title;
    private ArrayList<UpdateObserver> panels = new ArrayList<>();

    public CompositeGUI(String title){
        this.title = title;
    }

    public ArrayList<UpdateObserver> getPanels(){
        return this.panels;
    }

    public void add(UpdateObserver updateObserver){
        this.panels.add(updateObserver);
    }

    @Override
    public void update(Object o){

    }
}
