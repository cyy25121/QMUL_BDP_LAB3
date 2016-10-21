import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
// TokenizerMapper contains Mapper function
// Mapper<defines input data type, defines output data type>
public class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final IntWritable one = new IntWritable(1);
    private Text cp_name = new Text();
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		String in = value.toString();
		String[] ins = in.split(",");
		if(!ins[1].equals("stock_symbol")){
			cp_name.set(ins[1]);
			context.write(cp_name, one);
        }
    }
}
