package com.stackroute.listener;

import com.stackroute.domain.Paragraph;
import com.stackroute.service.ParagraphService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class KafkaProducer {

    private ParagraphService paragraphService;

    @Autowired
    public KafkaProducer(ParagraphService paragraphService) {
        this.paragraphService = paragraphService;
    }


    @Autowired
    private KafkaTemplate<String, JSONObject> kafkaTemplate2;

    private static final String TOPIC="ParagraphContents";


    public String postservice(List<JSONObject> paragraphList)
    {
        Paragraph paragraph;

        for(int i=0;i<paragraphList.size();i++)
        {
            kafkaTemplate2.send(TOPIC,paragraphList.get(i));
        }
        return "Published successfully";
    }

}
