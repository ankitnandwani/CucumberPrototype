package com.backend;

public interface Constants {
    String CONFIG_PATH = "src/main/resources/config/";
    String REQTEST = "REQTEST";
    String CREATE_TEST_RUN = "/{projectId}/testruns";
    String REQTEST_PAT = "o5sLBoNm4C/ubiNgwS6fR8P5rBczlUIWNHF+GlrZ5lPOH2subLxQ6lT5Nj1eWnP4";
    String PROJECT_ID = "70090";
    String ADD_TEST_CASE = "/{projectId}/testruns/{testRunId}/contents/add-testcases";
    String GET_CONTENTS = "/{projectId}/testruns/{testRunId}/contents";
    String EXECUTE_CONTENT = "/{projectId}/testruns/{testRunId}/contents/execute";
}
