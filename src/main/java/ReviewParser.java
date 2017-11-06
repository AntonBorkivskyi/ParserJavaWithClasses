import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReviewParser {
    String url;
    Filer filer = new Filer();

    public ReviewParser(String url){
        this.url = url;
    }

    public void parse_reviews() throws IOException {
        Elements nums = new GetHTML(this.url, "paginator-catalog-l-link", "a").parsing();
        int num;
        if(nums.size() > 0){
            num = Integer.parseInt(nums.last().text());
        }else{
            num = 0;
        }

        List<String> sentiments = new ArrayList<String>();


        for(int i = 1; i <= num; i++){
            String pg = url + "page=" + i + "/";
            sentiments.addAll(new ReviewOperator(pg).parse_reviews_page());
        }

        String filename = "data/" + url.split("/")[4] + ".csv";
        filer.writing_data(filename, sentiments);
        System.out.println(sentiments.size() + " reviews from " + url);
    }

}
