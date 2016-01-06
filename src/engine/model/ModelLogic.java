package engine.model;


/**
 * Game logic to be applied to Models, Containers etc.
 */
public interface ModelLogic<M extends AbstractModel> {

	/**
	 * Execute game logic if applicable.
	 */
	public void execute(M model);
}
