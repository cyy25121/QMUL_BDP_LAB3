package bdp.stock;

import java.io.IOException;
import java.util.Iterator;
import java.lang.Double;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CompanyMinMaxReducer extends Reducer<Text, DoubleWritable, Text, Text> {
	private Text tMsg = new Text();
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
    throws IOException, InterruptedException {

        double tMin = Double.MAX_VALUE;
		double tMax = -1;
        for (DoubleWritable value : values) {
			if(value.get() > tMax){
				tMax = value.get();
			}
			if(value.get() < tMin){
				tMin = value.get();
			}
        }
		String msg = "MIN: " + tMin + ", MAX: " + tMax;
		tMsg.set(msg);
		context.write(key, tMsg);
    }
}
