package com.reqtest.Entities.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subsystem {
    String value;
    String name;
    int sortIndex;
    String fieldType;
}
