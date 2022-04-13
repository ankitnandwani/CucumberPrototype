package com.reqtest.Entities.Response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Step {
    List<Attachment> attachments;
    String type;
    long id;
    String stepDescription;
    String stepExpectedResult;
    String links;
    String comment;
    String result;
    String resultText;
    String executionDate;

}
