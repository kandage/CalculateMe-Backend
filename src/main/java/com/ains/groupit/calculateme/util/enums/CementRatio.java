package com.ains.groupit.calculateme.util.enums;

public enum CementRatio {
    CM_1_3("C.M 1:3", 4.0, 3.0),
    CM_1_4("C.M 1:4", 5.0, 4.0),
    CM_1_5("C.M 1:5", 6.0, 5.0),
    CM_1_6("C.M 1:6", 7.0, 6.0),
    CM_1_7("C.M 1:7", 8.0, 7.0),
    CM_1_8("C.M 1:8", 9.0, 8.0),
    CM_1_9("C.M 1:9", 10.0, 9.0),
    DEFAULT("DEFAULT", 1.0, 1.0);

    private final String ratio;
    private final double cementDivisor;
    private final double sandDivisor;

    CementRatio(String ratio, double cementDivisor, double sandDivisor) {
        this.ratio = ratio;
        this.cementDivisor = cementDivisor;
        this.sandDivisor = sandDivisor;
    }

    public String getRatio() {
        return ratio;
    }

    public double getCementDivisor() {
        return cementDivisor;
    }

    public double getSandDivisor() {
        return sandDivisor;
    }

    public static CementRatio fromString(String ratio) {
        for (CementRatio cr : CementRatio.values()) {
            if (cr.getRatio().equals(ratio)) {
                return cr;
            }
        }
        return DEFAULT;
    }
}
