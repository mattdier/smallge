package engine;

import java.util.LinkedHashSet;
import java.util.Set;

import engine.model.ModelContainer;

public class GameEngine {
	
	private Set<ModelContainer<?>> modelContainers;

	public void init() {
		modelContainers = new LinkedHashSet<ModelContainer<?>>();
	}

	public void tick(long time) {
		// update models
		for (ModelContainer<?> amc : modelContainers) {
			amc.tick(time);
		}
	}
	
	public void addContainer(ModelContainer<?> container) {
		modelContainers.add(container);
	}
	
}
