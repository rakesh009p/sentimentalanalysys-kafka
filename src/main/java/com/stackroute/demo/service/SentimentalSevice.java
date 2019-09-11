package com.stackroute.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.demo.domain.Activities;
import com.stackroute.demo.domain.SentimentDomain;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

@Service
public class SentimentalSevice  {
    @Autowired
    private KafkaTemplate<String, SentimentDomain> kafkaTemplate;
    ObjectMapper objectMapper= new ObjectMapper();
//    @PostConstruct
    @KafkaListener(topics = "userTopic6", groupId = "json")
    public void sentimentAnalysis(String domain) throws IOException {
//        String strin{"actor":"News-adapter","object":{"objectType":"article","content":"Image copyrightGetty Images\r\nLeo Tolstoy\u0027s War and Peace is in the news in India after a judge asked an activist to explain why he had a book \"about war in another country\". \r\nVernon Gonsalves had appeared in the high court in Mumbai city on Wednesday for a h… [+1702 chars]"},"verb":"fetched"}g=domain.getObject().getContent();
        Activities activities=objectMapper.readValue(domain,Activities.class);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+domain);
String string = activities.getObject().getContent();
//        double sentiment=domain.getObject().getSentiment();
        PTBTokenizer ptbTokenizer = new PTBTokenizer<>(new StringReader(string), new CoreLabelTokenFactory(), "");
        while (ptbTokenizer.hasNext()) {
            CoreLabel coreLabel = (CoreLabel) ptbTokenizer.next();
            System.out.println(coreLabel);
        }
       SentimentalSevice sentimentalSevice= new SentimentalSevice();

        System.out.println(sentimentalSevice.findSentiment(string));

//        domain.getObject().setSentiment(findSentiment(string));
        SentimentDomain sentimentDomain=new SentimentDomain(activities.getActor(),activities.getVerb(),activities.getObject().getObjectType(),activities.getObject().getContent(),findSentiment(string));
        kafkaTemplate.send("userTopic7", sentimentDomain);


//        PTBTokenizer ptbTokenizer1=new PTBTokenizer();
//        System.out.println(ptbTokenizer1.findSentiment(myFile));
    }


    public double findSentiment(String line) {

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit,pos, parse, sentiment, lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        double mainSentiment = 0;
        double sentimentalScore=0;
        if (line != null && line.length() > 0) {
            double longest = 0;
            Annotation annotation = pipeline.process(String.valueOf(line));
            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                String partText = sentence.toString();
                if (partText.length() > longest) {
                    mainSentiment = sentiment;
                    longest = partText.length();
                }

            }

            sentimentalScore = Math.ceil(mainSentiment);

           return sentimentalScore;

        }else
            return 0;

    }




    }


