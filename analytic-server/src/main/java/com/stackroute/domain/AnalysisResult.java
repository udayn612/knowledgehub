package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisResult {
    private String paragraphId;
    private String paragraphContent;
    private String documentId;
    private String domain;
    private String concept;
    private String intentLevel;
    private double confidenceScore;
}
