package com.apurv.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionUtils {

	public static void printCollection(Collection coll) {
		for (Object obj : coll) {
			System.out.println("|" + obj + "|");
		}
	}

	public static void printMap(Map map) {
		Set<Entry> entries = map.entrySet();
		for (Entry ent : entries) {
			System.out.print("key:" + ent.getKey() + "| value:"
					+ ent.getValue());
		}

	}

}
