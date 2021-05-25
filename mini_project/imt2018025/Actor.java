package imt2018025;

import java.util.*;
import animation.*;

public class Actor extends SceneObject {
    private Point desti, curr_pos;
    private int hei = 10, wid = 10, sp = 20, mv = 1;

    public Actor() {
        super();
    }

    @Override
    protected ArrayList<Point> getOutline() {
        ArrayList<Point> coor = new ArrayList<Point>();
        coor.add(this.getBBox().getMinPt());
        coor.add(new Point(this.getBBox().getMinPt().getX() + this.wid, this.getBBox().getMinPt().getY()));
        coor.add(new Point(this.getBBox().getMinPt().getX(), this.getBBox().getMinPt().getY() + this.hei));
        coor.add(this.getBBox().getMaxPt());
        return coor;
    }

    public void setDestPosition(int x, int y) {
        this.desti = new Point(x, y);
    }

    @Override
    public Point getPosition() {
        return this.curr_pos;
    }

    @Override
    public String getObjName() {
        return "object";
    }

    @Override
    public void setPosition(int x, int y) {
        this.curr_pos = new Point(x, y);
    }

    @Override
    public BBox getBBox() {
        Point max_Pt = new Point(this.curr_pos.getX() + wid, this.curr_pos.getY() + hei);
        Point min_Pt = new Point(this.curr_pos.getX(), this.curr_pos.getY());
        return new Dim(min_Pt, max_Pt);
    }

    @Override
    protected void updatePos(int deltaT) {
        ArrayList<SceneObject> obstacle = Scene.getScene().getObstacles();
        ArrayList<SceneObject> actor = Scene.getScene().getActors();
        int x1 = this.curr_pos.getX(), y1 = this.curr_pos.getY();
        float delta = (float) deltaT;
        delta /= 1000;
        if (!(this.getBBox().getMaxPt().getY() >= this.desti.getY())) {
            this.curr_pos.setPos(x1, (int) (y1 + sp * delta));
            if (intersection(obstacle, actor)) {
                return;
            }
            this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() - sp * delta));
            if (!(this.getBBox().getMaxPt().getX() >= this.desti.getX())) {
                this.curr_pos.setPos((int) (x1 + delta * sp), y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (this.curr_pos.getX() - delta * sp), y1);
                float tempo, difference;
                if (!(x1 - delta * sp >= 0)) {
                    difference = x1;
                    tempo = 0;
                } else {
                    difference = sp * delta;
                    tempo = -(sp * delta) + x1;
                }
                this.curr_pos.setPos((int) tempo, y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (difference + this.curr_pos.getX()), y1);
                if (!(y1 - sp * delta >= 0)) {
                    difference = y1;
                    tempo = 0;
                } else {
                    difference = sp * delta;
                    tempo = y1 - delta * sp;
                }
                this.curr_pos.setPos(x1, (int) tempo);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() + difference));
            } else if (!(this.getBBox().getMinPt().getX() <= this.desti.getX())) {
                float tempo, difference;
                if (!(x1 - delta * sp >= 0)) {
                    difference = x1;
                    tempo = 0;
                } else {
                    difference = sp * delta;
                    tempo = -(sp * delta) + x1;
                }
                this.curr_pos.setPos((int) tempo, y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (difference + this.curr_pos.getX()), y1);
                this.curr_pos.setPos((int) (x1 + delta * sp), y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (this.curr_pos.getX() - delta * sp), y1);
                if (!(y1 - sp * delta >= 0)) {
                    difference = y1;
                    tempo = 0;
                } else {
                    difference = sp * delta;
                    tempo = y1 - delta * sp;
                }
                this.curr_pos.setPos(x1, (int) tempo);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() + difference));
            }
        } else if (!(this.getBBox().getMinPt().getY() <= this.desti.getY())) {
            float tempo, difference;
            if (!(y1 - sp * delta >= 0)) {
                difference = y1;
                tempo = 0;
            } else {
                difference = sp * delta;
                tempo = y1 - delta * sp;
            }
            this.curr_pos.setPos(x1, (int) tempo);
            if (intersection(obstacle, actor)) {
                return;
            }
            this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() + difference));
            if (!(this.getBBox().getMaxPt().getX() >= this.desti.getX())) {
                this.curr_pos.setPos((int) (x1 + delta * sp), y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (this.curr_pos.getX() - delta * sp), y1);
                if (!(x1 - delta * sp >= 0)) {
                    difference = x1;
                    tempo = 0;
                } else {
                    difference = sp * delta;
                    tempo = -(sp * delta) + x1;
                }
                this.curr_pos.setPos((int) tempo, y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (difference + this.curr_pos.getX()), y1);
                this.curr_pos.setPos(x1, (int) (y1 + sp * delta));
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() - sp * delta));
            } else if (!(this.getBBox().getMinPt().getX() <= this.desti.getX())) {

                if (!(x1 - delta * sp >= 0)) {
                    difference = x1;
                    tempo = 0;
                } else {
                    difference = sp * delta;
                    tempo = -(sp * delta) + x1;
                }
                this.curr_pos.setPos((int) tempo, y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (difference + this.curr_pos.getX()), y1);
                this.curr_pos.setPos((int) (x1 + delta * sp), y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (this.curr_pos.getX() - delta * sp), y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() - sp * delta));
            }
        } else {
            if (!(this.getBBox().getMaxPt().getX() >= this.desti.getX())) {
                float tempo, difference;
                if (!(x1 - delta * sp >= 0)) {
                    difference = x1;
                    tempo = 0;
                } else {
                    difference = sp * delta;
                    tempo = -(sp * delta) + x1;
                }
                this.curr_pos.setPos((int) tempo, y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (difference + this.curr_pos.getX()), y1);
                this.curr_pos.setPos((int) (x1 + delta * sp), y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (this.curr_pos.getX() - delta * sp), y1);
                if (2 * mv == 2) {
                    this.curr_pos.setPos(x1, (int) (y1 + sp * delta));
                    if (intersection(obstacle, actor)) {
                        return;
                    }
                    this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() - sp * delta));
                    if (!(y1 - sp * delta >= 0)) {
                        difference = y1;
                        tempo = 0;
                    } else {
                        difference = sp * delta;
                        tempo = y1 - delta * sp;
                    }
                    this.curr_pos.setPos(x1, (int) tempo);
                    if (intersection(obstacle, actor)) {
                        return;
                    }
                    this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() + difference));
                }
                if (-2 * mv == -2) {
                    if (!(y1 - sp * delta >= 0)) {
                        difference = y1;
                        tempo = 0;
                    } else {
                        difference = sp * delta;
                        tempo = y1 - delta * sp;
                    }
                    this.curr_pos.setPos(x1, (int) tempo);
                    if (intersection(obstacle, actor)) {
                        return;
                    }
                    this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() + difference));
                    this.curr_pos.setPos(x1, (int) (y1 + sp * delta));
                    if (intersection(obstacle, actor)) {
                        return;
                    }
                    this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() - sp * delta));
                }
                mv *= -1;
            } else if (!(this.getBBox().getMinPt().getX() <= this.desti.getX())) {
                float tempo, difference;
                if (!(x1 - delta * sp >= 0)) {
                    difference = x1;
                    tempo = 0;
                } else {
                    difference = sp * delta;
                    tempo = -(sp * delta) + x1;
                }
                this.curr_pos.setPos((int) tempo, y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (difference + this.curr_pos.getX()), y1);
                this.curr_pos.setPos((int) (x1 + delta * sp), y1);
                if (intersection(obstacle, actor)) {
                    return;
                }
                this.curr_pos.setPos((int) (this.curr_pos.getX() - delta * sp), y1);
                if (2 * mv == 2) {
                    this.curr_pos.setPos(x1, (int) (y1 + sp * delta));
                    if (intersection(obstacle, actor)) {
                        return;
                    }
                    this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() - sp * delta));
                    if (!(y1 - sp * delta >= 0)) {
                        difference = y1;
                        tempo = 0;
                    } else {
                        difference = sp * delta;
                        tempo = y1 - delta * sp;
                    }
                    this.curr_pos.setPos(x1, (int) tempo);
                    if (intersection(obstacle, actor)) {
                        return;
                    }
                    this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() + difference));
                }
                if (-2 * mv == -2) {
                    if (!(y1 - sp * delta >= 0)) {
                        difference = y1;
                        tempo = 0;
                    } else {
                        difference = sp * delta;
                        tempo = y1 - delta * sp;
                    }
                    this.curr_pos.setPos(x1, (int) tempo);
                    if (intersection(obstacle, actor)) {
                        return;
                    }
                    this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() + difference));
                    this.curr_pos.setPos(x1, (int) (y1 + sp * delta));
                    if (intersection(obstacle, actor)) {
                        return;
                    }
                    this.curr_pos.setPos(x1, (int) (this.curr_pos.getY() - sp * delta));
                }
                mv *= -1;
            }
        }
    }

    public boolean intersection(ArrayList<SceneObject> obstacle, ArrayList<SceneObject> actor) {
        for (int l = 0; l < actor.size(); ++l) {
            for (int k = 0; k < actor.size(); ++k) {
                if (l != k) {
                    if (actor.get(l).getBBox().intersects(actor.get(k).getBBox())) {
                        return false;
                    }
                }
            }
        }
        for (int l = 0; l < actor.size(); ++l) {
            for (int k = 0; k < obstacle.size(); ++k) {
                if (actor.get(l).getBBox().intersects((obstacle.get(k).getBBox()))) {
                    return false;
                }
            }
        }
        return true;
    }
}