package ca.mcmaster.se2aa4.island.team037.drone;

import java.util.ArrayList;
import java.util.List;

public class MapInfo {
    private int width;
    private int height;
    private List<POI> creeks;
    private POI site;

    public MapInfo() {
        this.width = -1;
        this.height = -1;
        this.creeks = new ArrayList<>();
        this.site = null;
    }

    public boolean hasWidth() {
        return width != -1;
    }

    public boolean hasHeight() {
        return height != -1;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDimensions(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public List<POI> getCreeks() {
        return creeks;
    }

    private void addCreek(POI creek) {
        creeks.add(creek);
    }

    public POI getEmergencySite() {
        return site;
    }

    private void addSite(POI site) {
        this.site = site;
    }

    public void addPOI(POI poi) {
        if (poi.type().equals(POIType.CREEK)) {
            addCreek(poi);
        } else if (poi.type().equals(POIType.SITE)) {
            addSite(poi);
        }
    }

    public boolean hasCreeks() {
        return !creeks.isEmpty();
    }

    public boolean hasSite() {
        return site != null;
    }

    public POI getNearestCreek() {
        if (!hasSite()) {
            return null;
        }

        POI nearestCreek = null;
        double minDistance = Double.MAX_VALUE;

        for (POI creek : creeks) {
            double distance = creek.position().distanceTo(site.position());
            if (distance < minDistance) {
                minDistance = distance;
                nearestCreek = creek;
            }
        }
        return nearestCreek;
    }

}
