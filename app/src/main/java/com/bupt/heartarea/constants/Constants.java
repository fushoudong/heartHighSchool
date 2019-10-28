package com.bupt.heartarea.constants;

import org.json.JSONObject;

public class Constants {public static String allstrs;

    public static String general_info;

    public static String hama_info;

    public static int hama_score;

    public static String medication_info;

    public static String risk_factor_info;

    public static String seattle_info;

    public static double seattle_score;

    public static String self_anxiety_info;

    public static int self_anxiety_score;

    public static String self_evalution_info;

    public static int self_evalution_score;

    public static String sleep_quality_info;

    public static int sleep_quality_score;

    public static String steps;

    public static String week_no;

    public static String weeks = "";

    public JSONObject jsonObject = new JSONObject();

    static  {
        general_info = "";
        hama_info = "";
        medication_info = "";
        risk_factor_info = "";
        seattle_info = "";
        self_anxiety_info = "";
        self_evalution_info = "";
        week_no = "";
        sleep_quality_info = "";
        steps = "";
        allstrs = "";
        seattle_score = -1.0D;
        hama_score = -1;
        self_anxiety_score = -1;
        self_evalution_score = -1;
        sleep_quality_score = -1;
    }

    public static String getAllstrs() { return allstrs; }

    public static String getGeneral_info() { return general_info; }

    public static String getHama_info() { return hama_info; }

    public static int getHama_score() { return hama_score; }

    public static String getMedication_info() { return medication_info; }

    public static String getRisk_factor_info() { return risk_factor_info; }

    public static String getSeattle_info() { return seattle_info; }

    public static double getSeattle_score() { return seattle_score; }

    public static String getSelf_anxiety_info() { return self_anxiety_info; }

    public static int getSelf_anxiety_score() { return self_anxiety_score; }

    public static String getSelf_evalution_info() { return self_evalution_info; }

    public static int getSelf_evalution_score() { return self_evalution_score; }

    public static String getSleep_quality_info() { return sleep_quality_info; }

    public static int getSleep_quality_score() { return sleep_quality_score; }

    public static String getSteps() { return steps; }

    public static String getWeek_no() { return week_no; }

    public static String getWeeks() { return weeks; }

    public static void setAllstrs(String paramString) { allstrs = paramString; }

    public static void setGeneral_info(String paramString) { general_info = paramString; }

    public static void setHama_info(String paramString) { hama_info = paramString; }

    public static void setHama_score(int paramInt) { hama_score = paramInt; }

    public static void setMedication_info(String paramString) { medication_info = paramString; }

    public static void setRisk_factor_info(String paramString) { risk_factor_info = paramString; }

    public static void setSeattle_info(String paramString) { seattle_info = paramString; }

    public static void setSeattle_score(double paramDouble) { seattle_score = paramDouble; }

    public static void setSelf_anxiety_info(String paramString) { self_anxiety_info = paramString; }

    public static void setSelf_anxiety_score(int paramInt) { self_anxiety_score = paramInt; }

    public static void setSelf_evalution_info(String paramString) { self_evalution_info = paramString; }

    public static void setSelf_evalution_score(int paramInt) { self_evalution_score = paramInt; }

    public static void setSleep_quality_info(String paramString) { sleep_quality_info = paramString; }

    public static void setSleep_quality_score(int paramInt) { sleep_quality_score = paramInt; }

    public static void setSteps(String paramString) { steps = paramString; }

    public static void setWeek_no(String paramString) { week_no = paramString; }

    public static void setWeeks(String paramString) { weeks = paramString; }

    public JSONObject getJsonObject() { return this.jsonObject; }

    public void setJsonObject(JSONObject paramJSONObject) { this.jsonObject = paramJSONObject; }
}
