package com.backend;

public interface Constants {
    String CONFIG_PATH = "src/main/resources/config/";
    String REQTEST = "REQTEST";
    String CREATE_TEST_RUN = "/{projectId}/testruns";
    String REQTEST_PAT = "bIUmAGhZ3xTmCSs802SOHYCv0fvWQInBDZWMBQ4zBZLog+BARiknuGnONxnrX1a2";
    String PROJECT_ID = "70668";
    String ADD_TEST_CASE = "/{projectId}/testruns/{testRunId}/contents/add-testcases";
    String GET_CONTENTS = "/{projectId}/testruns/{testRunId}/contents";
    String EXECUTE_CONTENT = "/{projectId}/testruns/{testRunId}/contents/execute";
}
