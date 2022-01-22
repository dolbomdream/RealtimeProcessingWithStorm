package com.dolbomdream.twitter.obj;

import java.util.ArrayList;
import java.util.List;

import com.dolbomdream.config.TwitterConfiguration;
// import com.dolbomdream.twitter.obj.TweetPost;

import twitter4j.*;

public class TwitterLoader {

    private TwitterConfiguration twitterConfiguration;
    private Twitter twitter;

    public TwitterLoader() {
        twitterConfiguration = new TwitterConfiguration();
        twitter = twitterConfiguration.getInstance();
    }

    public List<Status> getTweetList(Query query, int totalCount) throws Exception{
        List<Status> tweetList = null;
          System.out.println("Twitter Loader, getTweetList");

        if(totalCount < 100){
            query.setCount(totalCount);
            tweetList = this.getTweetBlock(query);
        }else{
            tweetList = this.getTweetBulk(query, totalCount);
        }
        return tweetList;
    }

    private List<Status> getTweetBlock(Query query){
        if(query.getMaxId() != 0){
            query.setMaxId(query.getMaxId());
        }
        List<Status> result = null;
        QueryResult queryResult = null;
        try{
            queryResult = twitter.search(query);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(queryResult != null){
            result = new ArrayList<>();
            for (Status status : queryResult.getTweets()) {
                result.add(status);
            }
        }
        return result;
    }

    private List<Status> getTweetBulk(Query query, int totalCount) throws Exception{
        List<Status> result = null;
        query.setCount(100);    //트위터 API 에서 한번에 가져올 수 있는 양이 100개
        boolean finished = false;
        int processCount = 0;
        while (!finished) {
            if(result == null){
                result = new ArrayList<>();
            }
            List<Status> statuses = this.getTweetBlock(query);
            long lowestStatusId = Long.MAX_VALUE;
            for (Status status : statuses) {
                lowestStatusId = Math.min(status.getId(), lowestStatusId);
                result.add(status);
            }
            query.setMaxId(lowestStatusId - 1);
            processCount = processCount+statuses.size();

            if((totalCount-processCount) < 100){
                query.setCount(totalCount-processCount);
            }

            if(statuses == null || (totalCount-processCount) <= 0){
                finished = true;
            }
        }
        return result;
    }

}