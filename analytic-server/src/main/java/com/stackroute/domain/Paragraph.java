package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paragraph {

    private String paragraphId;
    private String paragraphContent;
    private String documentId;
}
