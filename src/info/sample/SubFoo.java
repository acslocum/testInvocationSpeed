package info.sample;

public class SubFoo extends Foo {

	@Override
	public boolean doX(boolean bool) {
		return !super.doX(bool);
	}

}
