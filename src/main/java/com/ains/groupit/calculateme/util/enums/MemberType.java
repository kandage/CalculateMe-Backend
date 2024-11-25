package com.ains.groupit.calculateme.util.enums;

public enum MemberType {
    FOOTING("Footing", 80),
    SLAB("Slab", 80),
    BEAM("Beam", 160),
    COLUMN("Column", 110),
    STAIRCASE("StairCase", 85),
    LINTLE_COPING("Lintle/Coping", 50),
    RETAINING_WALL("Retaining Wall", 60);

    private final String typeName;
    private final double multiplier;

    MemberType(String typeName, double multiplier) {
        this.typeName = typeName;
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public static MemberType fromValue(String value) {
        for (MemberType type : values()) {
            if (type.typeName.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
