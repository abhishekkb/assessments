package com.abhishek.challenges.anagrams;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FindCharactersToMakeTwoStringsAnagrams {
	
	
	/**
	 * @Question
	 * 
	 * Find out the characters needed to be added to the 
	 * two Strings, to make them anagrams of each another
	 * 		example: String A = "ZXZZDD"
	 * 				 String B = "DXZZAA"
	 * 
	 * 		output:
	 * 			to String A add "AA"
	 * 			to String B add "DZ"
	 * 		
	 * 		explanation: 
	 * 			String A and B  can be made anagram  of each other 
	 * 			by adding "AA" to String A and "DZ" to String B
	 * 
	 */
	
	
	
	public static void main(String[] args){
		
		String str_a = "ZXZZDD";
		String str_b = "DXZZAA";
		
		System.out.println(findExtraCharactersToMakeTwoStringsAnagrams(str_a, str_b));
		System.out.println(findExtraCharactersToMakeTwoStringsAnagrams_2(str_a, str_b));
		
	}
	
	public static HashMap<String, Integer> getMapWithDuplicateCharCount(String str){
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<str.length(); i++){
			String key = str.charAt(i)+"";
			if(map.containsKey(key)){
				Integer count = map.get(key);
				map.put(key, ++count);
			}else{
				map.put(key, 1);
			}
		}
		return map;
	}
	
	public static String findExtraCharactersToMakeTwoStringsAnagrams(String str_a, String str_b){
		Map<String, Integer> map_a = getMapWithDuplicateCharCount(str_a);
		Map<String, Integer> map_b = getMapWithDuplicateCharCount(str_b);
		
		String extra = "To String B - ";
		
		Iterator<Entry<String, Integer>> it_a = map_a.entrySet().iterator();
		while(it_a.hasNext()){
			Entry<String, Integer> entry = (Entry<String, Integer>) it_a.next();
			String key = entry.getKey();
			int count_a = entry.getValue();
//			System.out.println(key + " , "+count_a);
			if(map_b.containsKey(key)){
				int count_b = map_b.get(key);
				int c = Math.abs(count_b-count_a);
				for(int i=0;i<c;i++){
					extra += key;
				}
				map_b.remove(key);
			}else{
				int c = map_a.get(key);
				for(int i=0;i<c;i++){
					extra += key;
				}
			}
		}
		
		extra += " ;; To String A - ";
		
		Iterator<Entry<String, Integer>> it_b = map_b.entrySet().iterator();
		while(it_b.hasNext()){
			Entry<String, Integer> entry = (Entry<String, Integer>) it_b.next();
			String key = entry.getKey();
			int count_b = entry.getValue();
//			System.out.println(key + " , "+count_b);
			if(map_a.containsKey(key)){
				int count_a = map_a.get(key);
				int c = Math.abs(count_b-count_a);
				for(int i=0;i<c;i++){
					extra += key;
				}
			}else{
				int c = map_b.get(key);
				for(int i=0;i<c;i++){
					extra += key;
				}
			}
		}
		
		return extra;
	}
	
	public static String findExtraCharactersToMakeTwoStringsAnagrams_2(String str_a, String str_b){
		
		int a = str_a.length();
		int b = str_b.length();
		
		Map<String, CharacterCounterForTwoStrings> map = new HashMap<>();
		
		CharacterCounterForTwoStrings cc = null;
		for(int i=0; i<a || i<b; i++){
			if(i<a){
				String c = str_a.charAt(i)+"";
				cc = map.get(c);
				if(cc != null){
					cc = map.get(c);
					cc.setA(cc.getA()+1);
				}else{
					map.put(c, new CharacterCounterForTwoStrings(1, 0));
				}
			}
			if(i<b){
				String c = str_b.charAt(i)+"";
				cc = map.get(c);
				if(cc != null){
					cc = map.get(c);
					cc.setB(cc.getB()+1);
				}else{
					map.put(c, new CharacterCounterForTwoStrings(0, 1));
				}
			}
		}
		
		// find the extra characters
		String extra="";
		//method 1
//			Iterator<Entry<String, CharacterCounterForTwoStrings>> it = map.entrySet().iterator();
//			while(it.hasNext()){
//				Entry<String, CharacterCounterForTwoStrings> entry =  it.next();
//				String key = entry.getKey();
//				cc = entry.getValue();
//				
//				int c = Math.abs(cc.getA()-cc.getB());
//				for(int i=0;i<c;i++){
//					extra += key;
//				}
//			}		
		//method 2
			String extra_a="";
			String extra_b="";
			
			Iterator<Entry<String, CharacterCounterForTwoStrings>> it = map.entrySet().iterator();
			while(it.hasNext()){
				Entry<String, CharacterCounterForTwoStrings> entry =  it.next();
				String key = entry.getKey();
				cc = entry.getValue();
				int aa = cc.getA();
				int bb = cc.getB();
				
				int c = Math.abs(cc.getA()-cc.getB());
				if(aa<bb){
					for(int i=0;i<c;i++){
						extra_a += key;
					}
				}else{
					for(int i=0;i<c;i++){
						extra_b += key;
					}
				}
			}
			
			extra = "To String A - " + extra_a + " ;; To String B - " + extra_b;
		
		return extra;
	}
	
	
}
