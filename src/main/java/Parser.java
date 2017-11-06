import org.jsoup.select.Elements;
import java.io.IOException;


public class Parser {

    public Parser(){

    }

    public static void parsing() throws IOException{
        new Filer().creating_file("data");
        String url = "https://hard.rozetka.com.ua/ua/mouses/c80172/";
        Elements nums = new GetHTML(url, "paginator-catalog-l-link", "a").parsing();
        int num = Integer.parseInt(nums.last().text());
        for(int i = 1;i <= num; i++){
            new CategoryPageParser(url + "page=" + i + "/").parse_category_page();
        }

    }
}
