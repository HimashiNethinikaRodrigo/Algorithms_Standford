package main.edu.course1.week4;

import main.edu.course1.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author himashinethi on 8/23/20
 * @project Algorithms -Standford University
 */
public class MinCutGraphProblem {
    public static final String readFile = ".//src/main/edu/course1/week4/kargerMinCut.txt";
    private static class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
    }

    private static Map<Vertex, List<Vertex>> createGraph(String[] lines, Map<Vertex, List<Vertex>> graph) {
        for (String line: lines) {
            if (line != null) {
                String[] row = line.split("\\s+");
                System.out.println(" ");
                List<Vertex> adjecentIndexes = new ArrayList<>();
                for (int i = 1; i < row.length; i++) {
                    adjecentIndexes.add(new Vertex(row[i]));
                }
                graph.put(new Vertex(row[0]), adjecentIndexes);
            }
        }


        return graph;
    }

    public static void main(String[] args) {
        String[] lines = Utils.readInputFileWithMultipleColumns(readFile, 201);
        Map<Vertex, List<Vertex>> graph = new HashMap<>();
        graph = createGraph (lines, graph);
        System.out.println(graph.values().toString());
    }


}
