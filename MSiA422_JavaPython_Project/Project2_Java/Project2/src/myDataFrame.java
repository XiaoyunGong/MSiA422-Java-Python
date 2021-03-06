import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class myDataFrame {

	public ArrayList<ArrayList<Object>> data;
	public int length;
	public ArrayList<String> header;

	// constructor
	public myDataFrame(ArrayList<ArrayList<Object>> data) {

		// create an array list to store header
		ArrayList<String> header = new ArrayList<String>();

		// add column name to header
		header.add("State");
		header.add("Gender");
		header.add("Year");
		header.add("Name");
		header.add("Count");

		this.header = header;
		this.length = data.size();
		this.data = data;
	}

	public myDataFrame head(int n) {
		// create a new array list to store the result.
		ArrayList<ArrayList<Object>> head = new ArrayList<>();
		// get the first n item in data and add to head
		for (int i = 0; i < n; i++) {
			head.add(data.get(i));
		}
		myDataFrame head_df = new myDataFrame(head);
		return head_df;
	}

	public myDataFrame tail(int n) {
		// create a new array list to store the result.
		ArrayList<ArrayList<Object>> tail = new ArrayList<>();
		// get the first n item in data and add to head
		for (int i = length - n; i < length; i++) {
			tail.add(data.get(i));
		}
		myDataFrame tail_df = new myDataFrame(tail);
		return tail_df;
	}

	public String dType(int index) {
		// create a new string: type and set the default to String;
		String type = "String";

		// get the type of the first row entry of column index.
		String type_first = "";

		if (data.get(0).get(index) instanceof Integer) {
			type_first = "Integer";
		} else {
			type_first = "String";
		}

		type = type_first;

		// loop through all entries to check if the data types are the same.
		if (type_first == "Integer") {
			for (int i = 0; i < length; i++) {
				if (data.get(i).get(index) instanceof String) {
					type = "String";
					break;
				}
			}
		}
		return type;
	}

	public String dType(String name) {
		int index = header.indexOf(name);
		String type = dType(index);
		return type;
	}

	public myDataFrame slice(int index) {
		ArrayList<ArrayList<Object>> slice = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			ArrayList<Object> temp = new ArrayList<>();
			temp.add(data.get(i).get(index));
			slice.add(temp);
		}

		myDataFrame slice_df = new myDataFrame(slice);
		return slice_df;
	}

	public myDataFrame slice(String name) {
		int index = header.indexOf(name);
		myDataFrame slice_df = slice(index);
		return slice_df;
	}

	public myDataFrame slice(int[] indexArr) {
		ArrayList<ArrayList<Object>> slice = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			ArrayList<Object> temp = new ArrayList<>();
			for (int j = 0; j < indexArr.length; j++) {
				temp.add(data.get(i).get(indexArr[j]));
			}
			slice.add(temp);
		}
		myDataFrame slice_df = new myDataFrame(slice);
		return slice_df;
	}

	public myDataFrame slice(String[] nameArr) {
		int[] index = new int[nameArr.length];

		for (int i = 0; i < nameArr.length; i++) {
			index[i] = header.indexOf(nameArr[i]);
		}
		myDataFrame slice_df = slice(index);

		return slice_df;
	}

	public myDataFrame filter(String col, String op, Object o) {

		ArrayList<ArrayList<Object>> filter = new ArrayList<>();
		int col_index = header.indexOf(col);

		// if dType is integer then implement "==", ">", "<", "<=", ">=", !="

		if (dType(col).equals("Integer")) {
			int o_value = (int) o;

			for (int i = 0; i < length; i++) {
				int data_value = (int) data.get(i).get(col_index);

				if ((op.equals("==")) && (o_value == data_value)) {
					filter.add(data.get(i));
				} else if ((op.equals(">=")) && (data_value >= o_value)) {
					filter.add(data.get(i));
				} else if ((op.equals("<=")) && (data_value <= o_value)) {
					filter.add(data.get(i));
				} else if ((op.equals(">")) && (data_value > o_value)) {
					filter.add(data.get(i));
				} else if ((op.equals("<")) && (data_value < o_value)) {
					filter.add(data.get(i));
				} else if ((op.equals("!=")) && (data_value != o_value)) {
					filter.add(data.get(i));
				} 
			}
		} else {
			// if dType is string, implement "!=", "=="
			for (int i = 0; i < length; i++) {
				if ((op.equals("==")) && (data.get(i).get(col_index).equals(o))) {
					filter.add(data.get(i));
				} else if ((op.equals("!=")) && (!(data.get(i).get(col_index).equals(o)))) {
					filter.add(data.get(i));
				} 
			}

		}

		myDataFrame filter_df = new myDataFrame(filter);
		return filter_df;
	}

	public myDataFrame loc(int index) {
		ArrayList<ArrayList<Object>> loc = new ArrayList<>();

		for (int i = index; i < length; i++) {
			loc.add(data.get(i));
		}

		myDataFrame loc_df = new myDataFrame(loc);
		return loc_df;
	}

	public myDataFrame loc(int from, int to) {
		ArrayList<ArrayList<Object>> loc = new ArrayList<>();

		for (int i = from; i < to; i++) {
			loc.add(data.get(i));
		}

		myDataFrame loc_df = new myDataFrame(loc);
		return loc_df;
	}

	public myDataFrame sort(int index) {

		if (dType(index).equals("Integer")) {
			Collections.sort(data, new Comparator<ArrayList<Object>>() {
				@Override
				public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
					if ((int) o1.get(index) > (int) o2.get(index)) {
						return 1;
					} else if ((int) o1.get(index) < (int) o2.get(index)) {
						return -1;
					}
					return 0;
				}
			});
		} else {
			Collections.sort(data, new Comparator<ArrayList<Object>>() {

				@Override
				public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
					return ((String) o1.get(index)).compareTo((String) o2.get(index));
				}
			});
		}

		myDataFrame sorted_df = new myDataFrame(data);
		return sorted_df;

	}

	public myDataFrame sort(String name) {
		int index = header.indexOf(name);
		myDataFrame sorted_df = sort(index);
		return sorted_df;
	}

	public Object getMax(int index) {
		myDataFrame sorted_df = sort(index);
		return sorted_df.data.get(length - 1).get(index);
	}

	public Object getMax(String name) {
		int index = header.indexOf(name);
		myDataFrame sorted_df = sort(index);
		return sorted_df.data.get(length - 1).get(index);
	}

	public Object getMin(int index) {
		myDataFrame sorted_df = sort(index);
		return sorted_df.data.get(0).get(index);
	}

	public Object getMin(String name) {
		int index = header.indexOf(name);
		myDataFrame sorted_df = sort(index);
		return sorted_df.data.get(0).get(index);
	}

}
