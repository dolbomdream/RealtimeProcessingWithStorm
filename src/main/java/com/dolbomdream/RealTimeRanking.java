package com.dolbomdream;
// import com.dolbomdream.storm.RankingTopology;
import com.dolbomdream.twitter.TwitterPublisher;
import twitter4j.*;

public class RealTimeRanking {


  public static void main(String[] args) {
    System.out.println("Start");

    Query query = new Query();
    query.setLang("ko");
    query.setQuery("미세먼지");
    query.setSince("2021-12-25");

    TwitterPublisher publisher = new TwitterPublisher();
    publisher.set_filter(query);
    publisher.publish();
    // RankingTopology ranker = RankingTopology();
    // ranker.run();
  }
}