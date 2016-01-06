package engine.model;

public interface ModelContainerListener<M extends AbstractModel> {
	public void modelAdded(M model);
	public void modelRemoved(M model);
}
