package com.stackroute.service;

import com.stackroute.domain.Paragraph;

public interface ParagraphService {
    public Paragraph getParagraph();

    public void setParagraph(Paragraph paragraph);

    public Paragraph takeParagraph(Paragraph paragraph);
}
