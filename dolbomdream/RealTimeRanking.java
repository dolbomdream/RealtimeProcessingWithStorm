import com.dolbomdream.storm.RankingTopology;
import com.dolbomdream.twitter.Publisher;

public class Main {


  public static void main(String[] args) {
    Query query = new Query();
    query.setLang("ko");
    query.setQuery("미세먼지");
    query.setSince("2021-12-25");

    TwitterPublisher publisher = TwitterPublisher();
    RankingTopology ranker = RankingTopology();
    publisher.set_filter(query);
    publisher.publish();
    ranker.run();
  }
}