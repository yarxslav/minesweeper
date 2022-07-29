package sweeper;

public class Flag {
    private Matrix flagMap;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        countOfClosedBoxes = Ranges.getSize().x * Ranges.getSize().y;
    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        countOfClosedBoxes--;
    }

    void toggleFlaggedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGED:
                setClosedToBox(coord);
                break;
            case CLOSED:
                setFlagedToBox(coord);
                break;
        }
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
    }

    private void setFlagedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGED);
    }

    int getCountOfClosedBoxes() {
        return countOfClosedBoxes;
    }

    public void setShowedBombsToBox(Coord coord) {
        flagMap.set(coord, Box.BOMBED);
    }

    void setOpenedToClosedBombBox(Coord coord) {
        if (flagMap.get(coord) == Box.CLOSED) flagMap.set(coord, Box.OPENED);
    }

    void setNoBombToFlaggedSafeBox(Coord coord) {
        if (flagMap.get(coord) == Box.FLAGED) flagMap.set(coord, Box.NOBOMB);
    }


    int getCountOfFlaggedBoxesAround(Coord coord) {
        int count = 0;
        for (Coord around : Ranges.getCoordinatesAround(coord))
            if (flagMap.get(around) == Box.FLAGED) count++;
        return count;
    }
}

