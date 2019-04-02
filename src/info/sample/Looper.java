package info.sample;

import java.util.Random;

public class Looper {
	static long seed;
	
	public Looper(long aSeed) {
		seed = aSeed;
	}
	
	public boolean loopDynamic(int count) {
		Random rand = new Random(seed);
		boolean result = false;
		for(int i=0; i<count; i++){
			if(rand.nextBoolean()) {
				result = new Bar().doY(rand.nextDouble() > 0.5);
			} else {
				result = new Foo().doX(rand.nextDouble() > 0.5);
			}
		}
		return result;
	}
	
	public boolean loopStatic(int count) {
		Random rand = new Random(seed);
		boolean result = false;
		for(int i=0; i<count; i++){
			if(rand.nextBoolean()) {
				result = StaticBar.doY(rand.nextDouble() > 0.5);
			} else {
				result = StaticFoo.doX(rand.nextDouble() > 0.5);
			}
		}
		return result;
	}
	
	public boolean loopSubclass(int count) {
		Random rand = new Random(seed);
		boolean result = false;
		for(int i=0; i<count; i++){
			if(rand.nextBoolean()) {
				result = new SubBar().doY(rand.nextDouble() > 0.5);
			} else {
				result = new SubFoo().doX(rand.nextDouble() > 0.5);
			}
		}
		return result;
	}

}
