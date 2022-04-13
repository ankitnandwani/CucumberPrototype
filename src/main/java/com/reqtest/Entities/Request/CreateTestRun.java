package com.reqtest.Entities.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTestRun {
    Fields fields;
}
