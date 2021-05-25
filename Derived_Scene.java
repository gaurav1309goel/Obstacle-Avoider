package imt2018025;

import java.util.*;
import animation.*;

public class Derived_Scene extends Scene {
    public void checkScene() {
        ArrayList<SceneObject> actor = getActors();
        ArrayList<SceneObject> obstacle = getObstacles();
        for (int l = 0; l < actor.size(); ++l) {
            for (int k = 0; k < actor.size(); ++k) {
                if (k != l) {
                    if (actor.get(l).getBBox().intersects(actor.get(k).getBBox())) {
                        actor.remove(actor.get(k));
                        break;
                    }
                }
            }
        }
        for (int l = 0; l < obstacle.size(); ++l) {
            for (int k = 0; k < actor.size(); ++k) {
                if (actor.get(k).getBBox().intersects(obstacle.get(l).getBBox())) {
                    actor.remove(actor.get(k));
                    k--;
                }
            }
        }
    }
}