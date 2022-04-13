package com.reqtest.Entities.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Headline {
    String value;
    String name;
    String fieldType;
}
