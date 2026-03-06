package com.collections.implementation.graphs;

public class AdjacencyMatrix2 {

      public int[][] matrix;

      public AdjacencyMatrix2() {
            this.matrix = new int[3][3];
      }

      public int[][] undirectedNonWeightedMatrix(int[][] graph) {

            int maxValue = 0;

            for (int i=0; i<graph.length; i++) {
                  for (int j=0; j<graph[0].length; j++) {
                        maxValue = Math.max(maxValue, graph[i][j]);
                  }
            }

            matrix = new int[maxValue][maxValue];

            for(int[] row : graph) {
                  matrix[row[0]][row[1]] = 1;
                  matrix[row[1]][row[0]] = 1;
            }

            return matrix;
      }


      public
}
