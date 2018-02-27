package ch.hslu.ad.sw01.E0;

import org.junit.Test;

import org.junit.*;

public class AllocationTest {

	@Test
	public void testHashCode() {
		Allocation alloc1 = new Allocation(12, 3);
		Allocation alloc2 = new Allocation(12, 4);
		Assert.assertEquals(alloc1.hashCode(), alloc2.hashCode());
	}

	@Test
	public void testEquals(){
		Allocation alloc1 = new Allocation(6, 4);
		Allocation alloc2 = new Allocation(6, 3);
		Assert.assertTrue(alloc1.equals(alloc2));
	}

	@Test
	public void testCompareToEquals(){
		Allocation alloc1 = new Allocation(6, 3);
		Allocation alloc2 = new Allocation(6, 3);
		Assert.assertEquals(0, alloc1.compareTo(alloc2));
	}
	
	@Test
	public void testCompareToBigger(){
		Allocation alloc1 = new Allocation(6, 4);
		Allocation alloc2 = new Allocation(3, 3);
		Assert.assertEquals(1, alloc1.compareTo(alloc2));
	}
	
	@Test
	public void testCompareToSmaller(){
		Allocation alloc1 = new Allocation(2, 2);
		Allocation alloc2 = new Allocation(6, 3);
		Assert.assertEquals(-1, alloc1.compareTo(alloc2));
	}

}
