package cn.sj1.tinyasm.core;

public interface UsingModifier {
	AfterModifier public_();

	AfterModifier protected_();

	AfterModifier private_();
	
	AfterModifier package_();
}
