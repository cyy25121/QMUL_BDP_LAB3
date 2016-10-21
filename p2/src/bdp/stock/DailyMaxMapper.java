package bdp.stock;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import bdp.stock.DailyStock;

public class DailyMaxMapper extends Mapper<Object, DailyStock, Text, DoubleWritable> {
    private Text name = new Text();
	private DoubleWritable closed = new DoubleWritable(1);
    public void map(Object key, DailyStock value, Context context) throws IOException, InterruptedException {
		name = value.getCompany();
		closed = value.getLow();
		context.write(name, closed);
    }
}
