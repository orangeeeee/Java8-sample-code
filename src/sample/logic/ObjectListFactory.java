package sample.logic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObjectListFactory {

	private List<Object> list;

	public void add(Object obj) {
		if (obj == null) {
			this.list.add("nullです。");
		} else if (obj instanceof String) {
			// TODO 何かロジックがあるなら入れる。
			this.list.add(obj);
		} else if (obj instanceof LocalDateTime) {
			this.list.add(obj);
		}
	}

	public List<Object> get() {
		return this.list;
	}

	ObjectListFactory() {
		list = new ArrayList<>();
	}
}
