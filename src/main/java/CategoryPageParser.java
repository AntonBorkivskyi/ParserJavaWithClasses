import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CategoryPageParser {
    String url;

    CategoryPageParser(String url){
        this.url = url;
    }

    public void parse_category_page() throws IOException {
        Elements tiles = new GetHTML(this.url, "g-i-tile-i-title", "div").parsing();
        for(Element tile : tiles){
            Element link = tile.select("a").first();
            new ReviewParser(link.attr("href") + "comments/").parse_reviews();
        }
    }

}
