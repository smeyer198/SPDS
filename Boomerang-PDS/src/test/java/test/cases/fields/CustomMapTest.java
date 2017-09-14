package test.cases.fields;

import org.junit.Test;

import test.core.selfrunning.AbstractBoomerangTest;

public class CustomMapTest extends AbstractBoomerangTest {
	@Test
	public void storeAndLoad(){
		Alloc alloc = new Alloc();
		Map map = new Map();
		map.add(alloc);
		Object alias = map.get();
		queryFor(alias);
	}
	@Test
	public void storeAndLoadSimple(){
		Alloc alloc = new Alloc();
		Map map = new Map();
		map.add(alloc);
		Object alias = map.m.content;
		queryFor(alias);
	}
	public static class Map{
		InnerMap m = new InnerMap();
		public void add(Object o){
			InnerMap map = this.m;
			map.innerAdd(o);
			InnerMap alias = this.m;
			Object retrieved = alias.content;
		}
		public Object get(){
			InnerMap map = this.m;
			return map.get();
		}
	}
	public static class InnerMap{
		private Object content= null;
		public void innerAdd(Object o) {
			content = o;
		}
		
		public Object get(){
			return content;
		}
	}
}
