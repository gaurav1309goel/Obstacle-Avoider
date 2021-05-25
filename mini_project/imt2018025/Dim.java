package imt2018025;

import java.util.*;
import animation.*;

public class Dim implements BBox {
    private Point min_Pt, max_Pt;

    public Dim(Point min_Pt, Point max_Pt) {
        this.max_Pt = new Point(max_Pt);
        this.min_Pt = new Point(min_Pt);
    }

    public Point getMaxPt() {
        return new Point(this.max_Pt);
    }

    public Point getMinPt() {
        return new Point(this.min_Pt);
    }

    public boolean intersects(BBox B) {
        if (B.getMinPt().getX() <= this.getMaxPt().getX() && this.getMinPt().getX() <= B.getMaxPt().getX()) {
            if (B.getMinPt().getY() <= this.getMaxPt().getY() && this.getMinPt().getY() <= B.getMaxPt().getY()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}