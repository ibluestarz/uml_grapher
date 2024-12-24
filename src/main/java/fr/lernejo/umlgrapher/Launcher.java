package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "launcher", mixinStandardHelpOptions = true, version = "Launcher part 1",
    description = "Run main launcher")
public class Launcher implements Callable<Integer> {

    @Option(names = {"-c", "--classes"}, required = true, description = "Classes")
    private String[] classes;

    @Option(names = {"-g", "--graph-type"}, defaultValue = "Mermaid", description = "Type de graph (default : Mermaid)")

    private final GraphType graphType = GraphType.Mermaid;

    @Override
    public Integer call() throws Exception {
        classes = classes[0].split(",");
        for (int i = 0; i < classes.length; i++) {
            Class<?> classe = Class.forName(classes[i]);
            UmlGraph graph = new UmlGraph(classe);

            System.out.println(graph.as(graphType));
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
