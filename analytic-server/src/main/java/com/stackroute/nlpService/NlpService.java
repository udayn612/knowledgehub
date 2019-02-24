package com.stackroute.nlpService;

import com.aliasi.sentences.IndoEuropeanSentenceModel;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.*;
import com.stackroute.domain.NlpResult;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public interface NlpService {
    public String getCleanerParagrah();

//    public ArrayList<String> getAllTokenizedSentences();

//    public String getParagrahWithSentences();

    public ArrayList<String> getLemmitizedWords();

    public ArrayList<String> getStemmedWords();

    public ArrayList<String> getWordsWithoutStopWords();

    public String getParagraphWithOutStopWords();

    public ArrayList<POSTagging> getPOSWords();

    public ArrayList<String> getNouns();

    public ArrayList<String> getVerbs();

    public HashMap<String, Long> getFrequencyOfWords();


    public NlpResult getNlpResults();

    public String[] getConceptNames();

    public void setConceptNames(String[] conceptNames);

    public String getParagraphContent();

    public void setParagraphContent(String paragraphContent);
}
