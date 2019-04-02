package info.sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class LooperTest {
	int count = 100000000; //100,000,000

	
	public long runStaticQuickly() {
		long start = System.currentTimeMillis();
		new Looper(start).loopStatic(count);
		long delta = System.currentTimeMillis() - start;
		printResult("static", count, delta);
		return delta;
	}
	
	public long runDynamicQuickly() {
		long start = System.currentTimeMillis();
		new Looper(start).loopDynamic(count);
		long delta = System.currentTimeMillis() - start;
		printResult("dynamic", count, delta);
		return delta;
	}

	public long runSubclassQuickly() {
		long start = System.currentTimeMillis();
		new Looper(start).loopSubclass(count);
		long delta = System.currentTimeMillis() - start;
		printResult("subclass", count, delta);
		return delta;
	}
	
	@Test
	public void shouldBeAboutTheSameAmountOfTime() {
		long staticLoop = runStaticQuickly();
		long dynamicLoop = runDynamicQuickly();
		long subclassLoop = runSubclassQuickly();
		
		long average = (staticLoop+dynamicLoop+subclassLoop)/3;
		double delta = (double)(Math.abs(average - staticLoop)) / staticLoop;
		System.out.println("average call time: " + (double)average/count + "ms");
		System.out.println("delta: " + delta*100 + "%");
		assertEquals(0.0, delta, 0.1);
	}
	
	public void printResult(String type, int count, long delta) {		
		System.out.println(type +" " + count + ":" + delta + "ms");
	}

}
