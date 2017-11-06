import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;


public class GetHTML {
    private String url;
    private String className;
    private String tag;

    public GetHTML(String url, String className, String tag){
        this.url = url;
        this.className = className;
        this.tag = tag;
    }

    Elements parsing() throws IOException{
        Document html_doc = Jsoup.connect(this.url).get();
        Elements elements = html_doc.getElementsByClass(this.className).select(this.tag);
        return elements;
    }
}
