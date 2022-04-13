package com.reqtest.Entities.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    int customId;
    String createdBy;
    long createdByUserId;
    boolean archived;
    long id;
    String type;
    String createdDate;
}
