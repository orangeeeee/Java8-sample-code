package sample.logic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public void addList(List<String> list) {
		String item = list.stream().collect(Collectors.joining(System.lineSeparator()));
		this.list.add(item);
	}

	public void addOpt(String opt, Object obj) {
		this.list.add(opt + ":" + obj);
	}

	public List<Object> get() {
		return this.list;
	}

	ObjectListFactory() {
		list = new ArrayList<>();
	}
}
