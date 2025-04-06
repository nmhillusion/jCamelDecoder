package tech.nmhillusion.jCamelDecompilerApp.helper;

import tech.nmhillusion.n2mix.util.StringUtil;
import tech.nmhillusion.n2mix.validator.StringValidator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static tech.nmhillusion.n2mix.helper.log.LogHelper.getLogger;

/**
 * created by: nmhillusion
 * <p>
 * created date: 2025-03-15
 */
public abstract class PathHelper {

    public static Path getPathOfResource(String... resourceName) {
        try {
//            final String appHomeDir = System.getenv("APP_HOME");
//            getLogger(PathHelper.class)
//                    .info("App Home = {}", appHomeDir);
//
//            if (StringValidator.isBlank(appHomeDir)) {
//                final URI resourceUri = ClassLoader.getSystemResource(resourceName).toURI();
//                getLogger(PathHelper.class).info("resourceUri = {}", resourceUri);
//                return Paths.get(resourceUri)
//                        .toAbsolutePath();
//            } else {
//                return Paths.get(appHomeDir, resourceName)
//                        .toAbsolutePath();
//            }
            return Paths.get(StringUtil.trimWithNull(getPathOfAppHome()), resourceName)
                    .toAbsolutePath();
        } catch (URISyntaxException e) {
            getLogger(PathHelper.class).error("Cannot find resource: %s".formatted(Arrays.toString(resourceName)), e);
            throw new RuntimeException("Cannot find resource: %s".formatted(Arrays.toString(resourceName)), e);
        }
    }

    public static Path makeSureExistFilePath(Path filePath) throws IOException {
        if (Files.exists(filePath)) {
            return filePath;
        }

        Files.createDirectories(filePath.getParent());
        Files.createFile(filePath);
        return filePath;
    }

    public static Path getPathOfAppHome() throws URISyntaxException {
        final String appHomeDir = System.getenv("APP_HOME");

        getLogger(PathHelper.class)
                .info("App Home = {}", appHomeDir);

        if (StringValidator.isBlank(appHomeDir)) {
            final URI resourceUri = ClassLoader.getSystemResource("decompiler").toURI();
            getLogger(PathHelper.class).info("resourceUri = {}", resourceUri);

            return Paths.get(resourceUri)
                    .getParent()
                    .toAbsolutePath();
        } else {
            return Paths.get(appHomeDir)
                    .toAbsolutePath();
        }
    }

}
