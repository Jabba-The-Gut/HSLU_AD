package ch.hslu.ad.sw01.E0;

public interface Memory {
	
	public Allocation malloc (final int size);
	
	public void free (Allocation alloc);
}
