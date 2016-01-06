package engine.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class ModelContainer<M extends AbstractModel> {

	private Set<M> models;
	private Set<ModelContainerListener<M>> listeners;
	
	public ModelContainer() {
		models = new LinkedHashSet<M>();
		listeners = new LinkedHashSet<ModelContainerListener<M>>();
	}

	public final void tick(float time) {
		for (M model : models) {
			model.tick(time);
		}
	}
	
	public Set<M> getModels() {
		return models;
	}
	
	public void addModel(M model) {
		models.add(model);
		for (ModelContainerListener<M> listener : listeners) {
			listener.modelAdded(model);
		}
	}
	
	public boolean removeModel(M model) {
		for (ModelContainerListener<M> listener : listeners) {
			listener.modelRemoved(model);
		}
		return models.remove(model);
	}
	

	public void addListener(ModelContainerListener<M> listener) {
		listeners.add(listener);
	}
	

	public boolean removeListener(ModelContainerListener<M> listener) {
		return listeners.remove(listener);
	}
}
