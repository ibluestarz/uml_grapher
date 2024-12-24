package fr.lernejo.umlgrapher;

public class UmlGraph {

    private final Class<?>[] classes;

    public UmlGraph(Class<?>... classes) {
        this.classes = classes;
    }

    public String as(GraphType type) {
        StringBuilder str = new StringBuilder("classDiagram\n");

        for (Class<?> clazz : classes) {
            if (clazz.isInterface()) {
                str.append("class ")
                    .append(clazz.getSimpleName())
                    .append(" {\n")
                    .append("    <<interface>>\n")
                    .append("}\n");
            } else {
                str.append("class ").append(clazz.getSimpleName()).append("\n");
            }
        }
        return str.toString();
    }
}
