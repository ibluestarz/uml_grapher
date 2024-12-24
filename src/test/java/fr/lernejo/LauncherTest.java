package fr.lernejo;

import fr.lernejo.umlgrapher.Launcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import picocli.CommandLine;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LauncherTest {

    @Test
    void testLauncherWithValidClass() {
        // Capture the output of System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Arguments for the Launcher
        String[] args = {"-c", "java.lang.String", "-g", "Mermaid"};

        // Execute the command
        Launcher launcher = new Launcher();
        int exitCode = new CommandLine(launcher).execute(args);

        // Restore the original System.out
        System.setOut(originalOut);

        // Assertions
        Assertions.assertEquals(0, exitCode);
        String expectedOutput = """
            classDiagram
            class String
            """;
        Assertions.assertTrue(outContent.toString().contains(expectedOutput));
    }

    /*@Test
    void testLauncherWithMultipleClasses() {
        // Capture the output of System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Arguments for the Launcher
        String[] args = {"-c", "java.lang.String,java.util.List"};

        // Execute the command
        Launcher launcher = new Launcher();
        int exitCode = new CommandLine(launcher).execute(args);

        // Restore the original System.out
        System.setOut(originalOut);

        // Assertions
        Assertions.assertEquals(0, exitCode);
        String expectedOutput1 = """
            classDiagram
            class String
            """;
        String expectedOutput2 = """
            classDiagram
            class List
            """;
        System.out.println(outContent.toString());
        Assertions.assertTrue(outContent.toString().contains(expectedOutput1));
        Assertions.assertTrue(outContent.toString().contains(expectedOutput2));
    }*/
}
