package id.fahrizal.test

import org.junit.Test

class ShortestPath {

    @Test
    fun run() {
        /* Let us create the example graph discussed above
     */
        val graph = arrayOf(
            intArrayOf(0, 4, 0, 0, 0, 0, 0, 8, 0),
            intArrayOf(4, 0, 8, 0, 0, 0, 0, 11, 0),
            intArrayOf(0, 8, 0, 7, 0, 4, 0, 0, 2),
            intArrayOf(0, 0, 7, 0, 9, 14, 0, 0, 0),
            intArrayOf(0, 0, 0, 9, 0, 10, 0, 0, 0),
            intArrayOf(0, 0, 4, 14, 10, 0, 2, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 2, 0, 1, 6),
            intArrayOf(8, 11, 0, 0, 0, 0, 1, 0, 7),
            intArrayOf(0, 0, 2, 0, 0, 0, 6, 7, 0)
        )


        // Function call
        dijkstra(graph, 0)
    }

    fun minDistance(dist: IntArray, sptSet: Array<Boolean?>): Int {
        // Initialize min value
        var min = Int.MAX_VALUE
        var min_index = -1
        for (v in 0 until V) if (sptSet[v] == false && dist[v] <= min) {
            min = dist[v]
            min_index = v
        }
        return min_index
    }

    // A utility function to print the constructed distance
    // array
    fun printSolution(dist: IntArray) {
        println(
            "Vertex \t\t Distance from Source"
        )
        for (i in 0 until V) println(i.toString() + " \t\t " + dist[i])
    }

    // Function that implements Dijkstra's single source
    // shortest path algorithm for a graph represented using
    // adjacency matrix representation
    fun dijkstra(graph: Array<IntArray>, src: Int) {
        val dist = IntArray(V) // The output array.
        // dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in
        // shortest path tree or shortest distance from src
        // to i is finalized
        val sptSet = arrayOfNulls<Boolean>(V)
        val prev = HashMap<Int,Int>()

        // Initialize all distances as INFINITE and stpSet[]
        // as false
        for (i in 0 until V) {
            dist[i] = Int.MAX_VALUE
            sptSet[i] = false
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0

        prev[src] = -1
        // Find shortest path for all vertices
        for (count in 0 until V - 1) {
            // Pick the minimum distance vertex from the set
            // of vertices not yet processed. u is always
            // equal to src in first iteration.
            val u = minDistance(dist, sptSet)

            // Mark the picked vertex as processed
            sptSet[u] = true

            // Update dist value of the adjacent vertices of
            // the picked vertex.
            for (v in 0 until V)  // Update dist[v] only if is not in sptSet,
            // there is an edge from u to v, and total
            // weight of path from src to v through u is
            // smaller than current value of dist[v]
                if (!sptSet[v]!! && graph[u][v] != 0 && dist[u] != Int.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v]
                    prev[v] = u
                }
        }

        // print the constructed distance array
        printSolution(dist)
    }

    companion object {
        // A utility function to find the vertex with minimum
        // distance value, from the set of vertices not yet
        // included in shortest path tree
        const val V = 9
    }
}