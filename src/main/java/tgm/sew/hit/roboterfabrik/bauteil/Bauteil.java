package tgm.sew.hit.roboterfabrik.bauteil;


public abstract class Bauteil {

	private int[] data;

	public Bauteil(int[] data) {
		this.data = data;
	}
	
	public void setData(int[] data) {
		this.data = data;
	}
	
	public int[] getData() {
		return this.data;
	}

	public String toString() {
		String out = getClass().getName() + ",";
		
		for (int i : data) {
			out += i + ",";
		}
		
		out = out.substring(0, out.lastIndexOf(','));
		
		return out;
	}
}
