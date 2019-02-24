package com.stackroute.service;

import com.stackroute.domain.NlpResult;
import org.springframework.stereotype.Service;

@Service
public class NlpResultServiceImpl implements NlpResultService {
    private NlpResult nlpResult;
    public NlpResult getNlpResult() {
        return nlpResult;
    }

    public void setNlpResult(NlpResult nlpResult) {
        this.nlpResult = nlpResult;
    }
}
