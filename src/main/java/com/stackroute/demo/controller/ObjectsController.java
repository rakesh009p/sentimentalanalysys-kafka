package com.stackroute.demo.controller;

//import com.stackroute.demo.service.DataService;
import com.stackroute.demo.domain.Activities;
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
        import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;

@RestController
public class ObjectsController {

//    @Autowired
//    KafkaTemplate<Object, Activities> kafkaTemplate;


    public void saveTrack() throws IOException {


//
//        File myFile = new File("/home/cgi/Videos/myfile.txt");
//        Writer writer=new FileWriter(myFile);
//        BufferedWriter bufferedWriter=new BufferedWriter(writer);
//        bufferedWriter.write(string);
//            String string=listen("hello");
//
//        PTBTokenizer ptbTokenizer = new PTBTokenizer<>(new StringReader(string), new CoreLabelTokenFactory(), "");
//        while (ptbTokenizer.hasNext()) {
//            CoreLabel coreLabel = (CoreLabel) ptbTokenizer.next();
//            System.out.println(coreLabel);
//        }
//        ObjectsController objectsController= new ObjectsController();
//        System.out.println(objectsController.findSentiment(string));
//
//
//        kafkaTemplate.send("userTopic5", String.valueOf(objectsController.findSentiment(string))+" - "+string);
////        PtbTokenizer ptbTokenizer1=new PtbTokenizer();
////        System.out.println(ptbTokenizer1.findSentiment(myFile));
//    }
//
//    public double findSentiment(String line) throws NullPointerException{
//
//        Properties props = new Properties();
//        props.setProperty("annotators", "tokenize, ssplit,pos, parse, sentiment, lemma");
//        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//        double mainSentiment = 0;
//        double sentimentalScore=0;
//        if (line != null && line.length() > 0) {
//            double longest = 0;
//            Annotation annotation = pipeline.process(String.valueOf(line));
//            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
//                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
//                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
//                String partText = sentence.toString();
//                if (partText.length() > longest) {
//                    mainSentiment = sentiment;
//                    longest = partText.length();
//                }
//
//            }
//            sentimentalScore = Math.ceil(mainSentiment);
//            System.out.println("finalscore="+sentimentalScore);
//
//
//            return sentimentalScore;
//        }else
//            return sentimentalScore;
//
//    }
//
//    @KafkaListener(topics = "userTopic5")
//    public String listen(String line){
//        return line;
//    }
    }
}