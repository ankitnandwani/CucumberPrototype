package com.reqtest.Entities.Response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Content {
    List<Step> steps;
    int testSuiteId;
    String links;
    String type;
    long id;
    String name;
    boolean isLatestVersion;
    String executedBy;
    String executionDate;
    long executedByUserId;
    String result;
    String resultText;
    String preConditions;

}
