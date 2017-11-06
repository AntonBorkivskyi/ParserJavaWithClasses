import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Filer {

    public Filer(){

    }

    public void creating_file(String dir){
        new File(dir).mkdirs();
    }

    public void writing_data(String filename, List<String> obj) throws IOException {
        PrintWriter fl = new PrintWriter(filename);
        for(String subobj : obj){
            fl.println(subobj);
        }
    }

}
