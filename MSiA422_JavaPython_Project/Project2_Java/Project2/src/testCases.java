import java.io.IOException;

public class testCases {

	public static void main(String[] args) throws IOException {
		myPandas pd = new myPandas();

		// 1. MyDataFrame readCSV(String path)
		String path = "namesbystate/IL.txt";
		String path2 = "namesbystate/TX.txt";
		myDataFrame df = myPandas.readCSV(path);

		// 2. void writeCSV(MyDataFrame data, String path)
		pd.writeCSV(df, "test/writeCSV.txt");

		// 3. MyDataFrame concat(MyDataFrame df1, MyDataFrame df2)
		myDataFrame df1 = myPandas.readCSV(path);
		myDataFrame df2 = myPandas.readCSV(path2);
		df1 = df1.head(10);
		df2 = df2.head(10);
		myDataFrame concat = pd.concat(df1, df2);
		pd.writeCSV(concat, "test/concat.txt");

		// 4. Head and Tail.
		myDataFrame head_df = df.head(10);
		pd.writeCSV(head_df, "test/head10.txt");
		myDataFrame tail_df = df.head(10);
		pd.writeCSV(tail_df, "test/tail10.txt");

		// 5. dType
		int index_dType = 4;
		String dType1 = df.dType(index_dType);
		System.out.println("The data type of column " + index_dType + " is " + dType1 + '.');

		String name_dType = "Gender";
		String dType2 = df.dType(name_dType);
		System.out.println("The data type of column " + name_dType + " is " + dType2 + '.');

		// 6. Slicing
		int index_slice = 3;
		myDataFrame slice_df_index = df.slice(index_slice);
		pd.writeCSV(slice_df_index, "test/slice_index.txt");

		String name_slice = "Count";
		myDataFrame slice_df_name = df.slice(name_slice);
		pd.writeCSV(slice_df_name, "test/slice_name.txt");

		int[] indexArr_slice = new int[3];
		indexArr_slice[0] = 0;
		indexArr_slice[1] = 2;
		indexArr_slice[2] = 4;
		myDataFrame slice_df_indexArr = df.slice(indexArr_slice);
		pd.writeCSV(slice_df_indexArr, "test/slice_indexArr.txt");

		String[] nameArr_slice = new String[2];
		nameArr_slice[0] = "Name";
		nameArr_slice[1] = "Count";
		myDataFrame slice_df_nameArr = df.slice(nameArr_slice);
		pd.writeCSV(slice_df_nameArr, "test/slice_nameArr.txt");

		// 7. Filter
		String col_filter = "Count";
		String op_filter = "==";
		Object o_filter = 100;

		myDataFrame filter_df = df.filter(col_filter, op_filter, o_filter);
		pd.writeCSV(filter_df, "test/filter_df.txt");

		String col_filter2 = "Name";
		String op_filter2 = "==";
		Object o_filter2 = "Alice";

		myDataFrame filter_df2 = df.filter(col_filter2, op_filter2, o_filter2);
		pd.writeCSV(filter_df2, "test/filter_df2.txt");

		// 8. Indexing
		int index_indexing = 3;
		myDataFrame index_byindex = df.loc(index_indexing);
		pd.writeCSV(index_byindex, "test/indexing_byIndex.txt");

		int from = 1;
		int to = 4;
		myDataFrame index_byrange = df.loc(from, to);
		pd.writeCSV(index_byrange, "test/indexing_byRange.txt");

		// 9. Sorting
		int index_sort = 4;
		myDataFrame sorted_byIndex = df.sort(index_sort);
		pd.writeCSV(sorted_byIndex, "test/sort_byIndex.txt");

		String name_sort = "Name";
		myDataFrame sorted_byName = df.sort(name_sort);
		pd.writeCSV(sorted_byName, "test/sort_byName.txt");

		// 10. Aggregation
		int index_getMax = 2;
		Object max_byIndex = df.getMax(index_getMax);
		System.out.println("The maximum of column " + index_getMax + " is " + max_byIndex + '.');

		String name_getMax = "Year";
		Object max_byName = df.getMax(name_getMax);
		System.out.println("The maximum of column " + name_getMax + " is " + max_byName + '.');

		int index_getMin = 4;
		Object min_byIndex = df.getMin(index_getMin);
		System.out.println("The minumum of column " + index_getMin + " is " + min_byIndex + '.');

		String name_getMin = "Count";
		Object min_byName = df.getMin(name_getMin);
		System.out.println("The minimum of column " + name_getMin + " is " + min_byName + '.');

	}
}
