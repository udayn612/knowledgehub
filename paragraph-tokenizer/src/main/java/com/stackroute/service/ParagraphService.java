/*
This is the service interface that gives abstract methods that will be used by the controller.
 */

package com.stackroute.service;

import com.stackroute.domain.Paragraph;
import com.stackroute.exception.ParagraphNotFoundException;
import org.json.simple.JSONObject;

import java.util.List;

public interface ParagraphService {

    public List<JSONObject> getParagraphObject(String documentId1,String text) throws ParagraphNotFoundException;

}
