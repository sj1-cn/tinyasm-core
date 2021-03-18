package cn.sj1.tinyasm.core;

public interface AdvClassBuilder extends UsingClassBody, AdvUsingMethod, AdvUsingModifier,AdvUsingAccessMethod ,AdvUsingClazz, AdvUsingSuperClazz{
	AdvUsingToByteArray end();

}
