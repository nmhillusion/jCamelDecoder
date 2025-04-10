package tech.nmhillusion.jCamelDecompilerApp.model;

import tech.nmhillusion.n2mix.type.Stringeable;

import java.nio.file.Path;

/**
 * created by: nmhillusion
 * <p>
 * created date: 2025-03-15
 */
public class DecompileFileModel extends Stringeable {
    private Path classFilePath;
    private Path outputFilePath;

    public Path getClassFilePath() {
        return classFilePath;
    }

    public DecompileFileModel setClassFilePath(Path classFilePath) {
        this.classFilePath = classFilePath;
        return this;
    }

    public Path getOutputFilePath() {
        return outputFilePath;
    }

    public DecompileFileModel setOutputFilePath(Path outputFilePath) {
        this.outputFilePath = outputFilePath;
        return this;
    }
}
