package wsb.merito.pz.cw13.solid.oc.good;

public class Gem extends Product{

	@Override
	public double calculateTaxIncludedPrice() {
		
		return getBasePrice();
	}

}
