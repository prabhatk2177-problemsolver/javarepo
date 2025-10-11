package project1;
import java.io.*;
import java.util.*;

class graph
{
    int vertices;
    int[][] adjacency_matrix;

   
    public graph(int vertices)
    {
        this.vertices = vertices;
        adjacency_matrix = new int[vertices][vertices];
    }

    public void insert(int source, int destination)
    {
        
        adjacency_matrix[source - 1][destination-1] = 1;
    }

    public boolean issink(int i)
    {
        for (int j = 0 ; j < vertices ; j++)
        {
            
            if (adjacency_matrix[i][j] == 1)
                return false;

            
            if (adjacency_matrix[j][i] == 0 && j != i)
                return false;
        }
        
        return true;
    }

    
    public int eliminate()
    {
        int i = 0, j = 0;
        while (i < vertices && j < vertices)
        {
            
            if (adjacency_matrix[j][i] == 1)
                j = j + 1;
            else
                i = i + 1;

        }

       
        if (j > vertices)
            return -1;
        else if (!issink(j))
            return -1;
        else return j;
    }
}

public class Sink
{
    public static void main(String[] args)throws IOException
    {
        int number_of_vertices = 6;
        int number_of_edges = 5;
        graph g = new graph(number_of_vertices);
       
        g.insert(1, 6);
        g.insert(2, 3);
        g.insert(2, 4);
        g.insert(4, 3);
        g.insert(5, 3);

        int vertex = g.eliminate();

       
        if (vertex >= 0)
            System.out.println("Sink found at vertex "
                                     + (vertex + 1));
        else
            System.out.println("No Sink");
    }
}


