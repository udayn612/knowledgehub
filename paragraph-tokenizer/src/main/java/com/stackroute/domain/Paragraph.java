/*
This is the domain class that stores the properties of Paragraphs.
 */

package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paragraph
{
    @Id
    private int paragraphId;
    private String paragraphText;
    private String documentId;
}
