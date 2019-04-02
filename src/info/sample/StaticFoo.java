package info.sample;

public class StaticFoo {
	public static final boolean doX(boolean bool) {
		return Math.random()>0.5? bool : false;
	}
}
