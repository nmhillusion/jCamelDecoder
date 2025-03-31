package tech.nmhillusion.jCamelDecoderApp.constant;

/**
 * created by: nmhillusion
 * <p>
 * created date: 2025-02-12
 */
public enum DecoderEngineEnum {
    Procyon, CFR, FERN_FLOWER;

    public static DecoderEngineEnum fromName(String engineName) {
        final String normalizeEngineName = String.valueOf(engineName).trim().toLowerCase();

        return switch (normalizeEngineName) {
            case "procyon" -> Procyon;
            case "cfr" -> CFR;
            case "fernflower" -> FERN_FLOWER;
            default -> throw new IllegalArgumentException("Cannot find DecoderEngine with name: " + engineName);
        };
    }
}
