import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReviewObject {
    String className;
    String tag;
    Element element;

    public ReviewObject(Element element, String className, String tag){
        this.className = className;
        this.tag = tag;
        this.element = element;
    }

    Elements getting_element(){
        Elements elements = this.element.getElementsByClass(this.className).select(this.tag);
        return elements;
    }
}
