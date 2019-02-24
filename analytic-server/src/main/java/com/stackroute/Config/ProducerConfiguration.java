package com.stackroute.Config;

import com.stackroute.domain.AnalysisResult;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.simple.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {
    @Bean
    public ProducerFactory<String, AnalysisResult> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.239.130:9092");
        config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }


    @Bean
    public KafkaTemplate<String, AnalysisResult> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

//    @Bean
//    public void callConsumer(){
//        consumerConfig.consumerFactory();
//        consumerConfig.kafkaListenerContainerFactory();
//        consumerConfig.userConsumerFactory();
//        consumerConfig.userKafkaListenerFactory();
//    }
}