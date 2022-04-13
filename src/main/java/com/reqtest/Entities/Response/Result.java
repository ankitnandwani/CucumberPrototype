package com.reqtest.Entities.Response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Result {
    List<Content> contents;
    String type;
    long id;
    int customId;
    String createdBy;
    long createdByUserId;
    String createdDate;
    String changedDate;
    boolean archived;
}
