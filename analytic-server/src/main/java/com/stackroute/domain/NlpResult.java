package com.stackroute.domain;

import com.stackroute.nlpService.POSTagging;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NlpResult {
    private String clearedParagraph;
    private ArrayList<String> allTokenedSentences;
    private ArrayList<String> lemmaWords;
    private ArrayList<String> stemmedWords;
    private ArrayList<String> wordsWithOutStopWords;
    private String paragraphWithOutStopWords;
    private ArrayList<POSTagging> posTaggings;
    private ArrayList<String> nounWords;
    private ArrayList<String> verbWords;
}
