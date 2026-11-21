import java.util.HashMap;

public class CubeWalking {
	public String finalPosition(String movement) {
		State state = CenterState.getInstance();
		for (int i = 0; i < movement.length(); i++) {
			char command = movement.charAt(i);
			if (command == 'L') {
				state = state.left();
			} else if (command == 'R') {
				state = state.right();
			} else if (command == 'W') {
				state = state.forward();
			}
		}
		return state.color;
	}
}

abstract class State {
	String color;
	static HashMap<String, State> registry = new HashMap<String, State>();

	State(String color) {
		this.color = color;
	}

	static State getInstance(String className) {
		if (!registry.containsKey(className)) {
			try {
				registry.put(className,
						(State) (Class.forName(className).newInstance()));
			} catch (Throwable t) {
			}
		}
		return registry.get(className);
	}

	abstract State left();

	abstract State right();

	abstract State forward();
}

class CenterState extends State {
	CenterState() {
		super("GREEN");
	}

	static State getInstance() {
		return getInstance(CenterState.class.getName());
	}

	@Override
	State left() {
		return this;
	}

	@Override
	State right() {
		return this;
	}

	@Override
	State forward() {
		return EdgeFaceOutState.getInstance();
	}
}

class EdgeFaceOutState extends State {
	EdgeFaceOutState() {
		super("BLUE");
	}

	static State getInstance() {
		return getInstance(EdgeFaceOutState.class.getName());
	}

	@Override
	State left() {
		return EdgeRightOutState.getInstance();
	}

	@Override
	State right() {
		return EdgeLeftOutState.getInstance();
	}

	@Override
	State forward() {
		return EdgeFaceInState.getInstance();
	}
}

class EdgeFaceInState extends State {
	EdgeFaceInState() {
		super("BLUE");
	}

	static State getInstance() {
		return getInstance(EdgeFaceInState.class.getName());
	}

	@Override
	State left() {
		return EdgeLeftOutState.getInstance();
	}

	@Override
	State right() {
		return EdgeRightOutState.getInstance();
	}

	@Override
	State forward() {
		return CenterState.getInstance();
	}
}

class EdgeRightOutState extends State {
	EdgeRightOutState() {
		super("BLUE");
	}

	static State getInstance() {
		return getInstance(EdgeRightOutState.class.getName());
	}

	@Override
	State left() {
		return EdgeFaceInState.getInstance();
	}

	@Override
	State right() {
		return EdgeFaceOutState.getInstance();
	}

	@Override
	State forward() {
		return CornerFaceRightOutState.getInstance();
	}
}

class EdgeLeftOutState extends State {
	EdgeLeftOutState() {
		super("BLUE");
	}

	static State getInstance() {
		return getInstance(EdgeLeftOutState.class.getName());
	}

	@Override
	State left() {
		return EdgeFaceOutState.getInstance();
	}

	@Override
	State right() {
		return EdgeFaceInState.getInstance();
	}

	@Override
	State forward() {
		return CornerFaceLeftOutState.getInstance();
	}
}

class CornerFaceLeftOutState extends State {
	CornerFaceLeftOutState() {
		super("RED");
	}

	static State getInstance() {
		return getInstance(CornerFaceLeftOutState.class.getName());
	}

	@Override
	State left() {
		return CornerFaceRightOutState.getInstance();
	}

	@Override
	State right() {
		return CornerFaceRightInState.getInstance();
	}

	@Override
	State forward() {
		return CornerFaceRightInState.getInstance();
	}
}

class CornerFaceRightOutState extends State {
	CornerFaceRightOutState() {
		super("RED");
	}

	static State getInstance() {
		return getInstance(CornerFaceRightOutState.class.getName());
	}

	@Override
	State left() {
		return CornerFaceleftInState.getInstance();
	}

	@Override
	State right() {
		return CornerFaceLeftOutState.getInstance();
	}

	@Override
	State forward() {
		return CornerFaceleftInState.getInstance();
	}
}

class CornerFaceleftInState extends State {
	CornerFaceleftInState() {
		super("RED");
	}

	static State getInstance() {
		return getInstance(CornerFaceleftInState.class.getName());
	}

	@Override
	State left() {
		return CornerFaceRightInState.getInstance();
	}

	@Override
	State right() {
		return CornerFaceRightOutState.getInstance();
	}

	@Override
	State forward() {
		return EdgeRightOutState.getInstance();
	}
}

class CornerFaceRightInState extends State {
	CornerFaceRightInState() {
		super("RED");
	}

	static State getInstance() {
		return getInstance(CornerFaceRightInState.class.getName());
	}

	@Override
	State left() {
		return CornerFaceLeftOutState.getInstance();
	}

	@Override
	State right() {
		return CornerFaceleftInState.getInstance();
	}

	@Override
	State forward() {
		return EdgeLeftOutState.getInstance();
	}
}
