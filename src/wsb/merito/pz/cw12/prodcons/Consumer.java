package wsb.merito.pz.cw12.prodcons;

/**
 * Interfejs wszelkich konsumentów w problemie <i>producent-konsument</i>.
 * 
 * @author kmi
 */
public interface Consumer extends Runnable {
	
	/**
	 * Metoda wołana w celu skonsumowania <i>produktu</i> przez tego konsumenta.
	 */
	public void consume();
}
