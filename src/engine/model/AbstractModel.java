package engine.model;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class AbstractModel<M extends AbstractModel> {
	
	Set<ModelLogic<AbstractModel<M>>> logics;
	Set<ModelChangedListener<AbstractModel<M>>> listeners;
	
	public AbstractModel() {
		logics = new LinkedHashSet<ModelLogic<AbstractModel<M>>>();
		listeners = new LinkedHashSet<ModelChangedListener<AbstractModel<M>>>();
	}
	
	public final void tick(float time) {
		for (ModelLogic<AbstractModel<M>> logic : logics) {
			logic.execute(this);
		}
	}
	
	public final void addLogic(ModelLogic<AbstractModel<M>> logic) {
		logics.add(logic);
	}
	
	public final boolean addListener(ModelChangedListener<AbstractModel<M>> listener) {
		return listeners.add(listener);
	}
	
	public final boolean removeListener(ModelChangedListener<AbstractModel<M>> listener) {
		return listeners.remove(listener);
	}
	
	protected void fireModelChangedListeners() {
		for (ModelChangedListener<AbstractModel<M>> listener : listeners) {
			listener.modelChanged(this);
		}
	}
}
