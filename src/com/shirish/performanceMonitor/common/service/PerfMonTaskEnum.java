package com.shirish.performanceMonitor.common.service;

public enum PerfMonTaskEnum {
    /**
     * do not format this class!!!
     * do not format this class!!!
     * do not format this class!!!
     * do not format this class!!!
     */
    TEST("test"), 
    SELECT("select"), 
    IDF_PROCESS_TOTAL_TIME("IDF Handler Process Total time"),
    PROCESS("Process Total"), 
    EXECUTE("execute"), 
    GET_CONNECTION("getConnection"), 
    EXECUTE_SQL("executeSQL"), 
    TRANSACTION_COMMIT("transaction commit"), 
    PREPARE_STATMENT("prepareStatment"), 
    FILL_RESULT_SET_INTO_VO_LIST("fillResultSetIntoVoList"), 
    FINALLY_CLEANING_DB("finally-cleaning-db"), 
    JDBC_CONNECTION("JdbcConnection"), 
    ORACLE_CONNECTION("OracleConnection"), 
    GEN_CONNECTION_POOL("GenConnectionPool"), 
    CALL_FUND_HEADER("Call Fund Header"), 
    CALL_SPECIFIC_BUSINESS("Call Specific business"), 
    EXECUTE_FUND_HEADER_PREPARE("executeFundHeader() - prepare"), 
    EXECUTE_FUND_HEADER_CALL_FUND_MEDIATOR("executeFundHeader() - call fund mediator"), 
    FILL_DEFAULT_DATA_FOR_CRITERIA("fillDefaultDataForCriteria"), 
    OUTPUT_BUILDER("output builder"), 
    INIT_IDF_PARAM("init IDF Param"), 
    VALIDATE_INPUT("Validate Input"), 
    CHECK_CERTIFICATE("Check certificate"), 
    CHECK_SECURITY("Check security"), 
    DO_PROCCESS("Do proccess"), 
    CLOSE_LISTENER("Close Listener"), 
    APPLY_BL("ApplyBL"), 
    GET_CONTROL_REGION("Get Control Region"), 
    GET_FUND_INFO("Get fund info"),
    INIT_IDF_OUTPUTUBILDER("Init IDF output builder"),
    INIT_IDF_OUTPUTUBILDER_FILL_DATA("Format and fill data into IDF output builder"),
    INIT_IDF_OUTPUTUBILDER_REMOVE_DUPLICATE_DATA("Remove duplicate data from IDF output builder"),
    GET_CALL_TIME("Get call time"),
    INIT_BUILDER_HELPER(" - Init Builder Helper"),
    GET_REPORT_CONTENTS(" - get Report Contents"),
    BUILDER_IDF_COLUMNS(" - builder IDF columns"),
    BUILDER_IDF_CONTENT("- builder IDF Content"),
    PICK_DATASOURCE("Pick data source type"),
    PICK_SECURITY_SOURCE_TYPE("Pick security source type"),
    PROCESS_QUARTZ_JOB("process quartz job"),
    
    START("============Begin============"), 
    END("============End============");

    /**
     * do not format this class!!!
     * do not format this class!!!
     * do not format this class!!!
     * do not format this class!!!
     */

    private PerfMonTaskEnum(String taskName)
    {
        this.taskName = taskName;
    }

    private String taskName;

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

}