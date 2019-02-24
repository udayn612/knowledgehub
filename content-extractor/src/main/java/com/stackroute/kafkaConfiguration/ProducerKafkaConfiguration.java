package com.stackroute.kafkaConfiguration;

import com.stackroute.domain.PdfDocument;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/*
    Setting Kafka and Zookeeper Configuration
 */
@Configuration
public class ProducerKafkaConfiguration {

    /* This method set configuration for content extractor service. It publish the topic Content_Format
     * with the JSON object of type PdfDocument.
     */
        @Bean
        public ProducerFactory<String, PdfDocument> producerFactory() {
            Map<String, Object> config = new HashMap<>();

            config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
            config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

            return new DefaultKafkaProducerFactory<>(config);
        }


        @Bean
        public KafkaTemplate<String, PdfDocument> kafkaTemplate() {
            return new KafkaTemplate<>(producerFactory());
        }


}


