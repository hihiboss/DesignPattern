package Model;

public class TheaterListIterator implements Iterator {
    private TheaterList theaterList;
    private int index;

    public TheaterListIterator(TheaterList theaterList) {
        this.theaterList = theaterList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < theaterList.getLength()) {
            return true;
        }

        return false;
    }

    @Override
    public Object next() {
        Theater theater = theaterList.getTheaterAt(index);
        index++;
        return theater;
    }
}
