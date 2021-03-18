package cn.sj1.tinyasm.util;

import java.io.Serializable;
import java.util.Map;

public interface SignatureInterfaceSample extends Map<String, Map<String, String[]>>, Serializable {

//public class SignatureSample  extends ArrayList<String[]>{
//
//	Map<String, String[]> mapStrngStringArray;
//	Map<String, String> mapStrngString;
//	HashMap<String, Map<String, String[]>> hashMapStringMapStringStringArray;

//	private static final long serialVersionUID = 4358890067219621012L;

	Map<String, String> mapStrngString(Map<String, String> mapStrngString,Map<String, String> mapStrngString2);
}
