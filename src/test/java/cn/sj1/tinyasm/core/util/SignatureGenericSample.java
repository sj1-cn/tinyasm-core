package cn.sj1.tinyasm.core.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class SignatureGenericSample<S, D> extends HashMap<S, D> implements Serializable {

	//public class SignatureSample  extends ArrayList<String[]>{

	/**
	 * 
	 */
	//	private static final long serialVersionUID = 1L;
	Map<String, String[]> mapStrngStringArray;
	Map<String, String> mapStrngString;
	HashMap<String, Map<String, String[]>> hashMapStringMapStringStringArray;

	//	private static final long serialVersionUID = 4358890067219621012L;

	Map<String, String> mapStrngString(Map<String, String> mapStrngString, Map<String, String> mapStrngString2) {
		return null;
	}
}
