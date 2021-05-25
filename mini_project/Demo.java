import animation.*;
import animation.SceneObject;
import imt2018025.Actor;
import imt2018025.Derived_Scene;

import java.util.ArrayList;

import animation.Point;

// Driver class to set up and exercise the animation
public class Demo {

	public static void main(String[] args) {
		Scene scene = new Derived_Scene(); // replace with appropriate derived class

		// scene.setView(new TextView()); // can be replaced with other Views that will
		// be provided

		// populate the scene with objects implemented by the team
		for (int i = 0; i < 6; i++) {
			SceneObject s = new Actor();
			s.setPosition(i * 50, i * 50);
			scene.addObstacle(s); // using appropriate derived classes
		}

		for (int i = 0; i < 6; i++) {
			SceneObject s = new Actor();
			s.setPosition(500 - i * 50, 300 + i * 50); // these will be changed for the demo
			s.setDestPosition(0, 0);
			scene.addActor(s); // using appropriate derived classes
		}
		View view = new DemoSwingView();

		scene.setView(view);

		view.init();
		// scene.animate();
	}
}