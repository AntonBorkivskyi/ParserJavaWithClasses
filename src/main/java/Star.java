import org.jsoup.nodes.Element;

public class Star extends ReviewObject{


    public Star(Element review){
        super(review, "g-rating-stars-i", "span");
    }

}
