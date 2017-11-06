import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReviewOperator {
    String url;

    public ReviewOperator(String url){
        this.url = url;

    }

    public List<String> parse_reviews_page() throws IOException, NullPointerException {
        Elements reviews = new GetHTML(this.url, "pp-review-i", "article").parsing();

        List<String> sentiments = new ArrayList<String>();

        for(Element review : reviews){
            Element star = new Star(review).getting_element().first();
            Element text = new Text(review, "pp-review-text", "div").getting_element().first();
            if(star != null){
                Elements texts = new Text(text, "pp-review-text-i", "div").getting_element();
                sentiments.add(star.attr("content") + "," + texts.first().text());
            }
        }
        return sentiments;
    }

}
