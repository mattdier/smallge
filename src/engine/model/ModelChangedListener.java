package engine.model;

public interface ModelChangedListener<M extends AbstractModel> {

	public void modelChanged(M model);
}
