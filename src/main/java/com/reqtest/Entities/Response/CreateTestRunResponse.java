package com.reqtest.Entities.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTestRunResponse {
    boolean isSuccess;
    String message;
    Result result;
}
