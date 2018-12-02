/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa_projectdemo;
import java.io.File;
import java.io.IOException;


/**
 *
 * @author Himani Soni
 */
public class Aa_projectdemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            Aa_projectdemo test = new Aa_projectdemo();
            SimpleGraph G = new SimpleGraph();
            ScalingFordFulkerson sff = new ScalingFordFulkerson(G);
            test.run(sff);
        }catch(Exception e)
        {
            StackTraceElement[] ste = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();

            for (StackTraceElement st : ste) {
                sb.append(st.toString()).append(System.lineSeparator());
            }
            System.out.println(sb);
        }
        
    }
    
    public void run(ScalingFordFulkerson sff) {
		System.out.println("Test three algorithms for 10 times given an input file");
		System.out.println("-----------------------------------------------------------");

		// Scaling Ford Fulkerson Algorithm
		runAlgorithm("Scaling Ford Fulkerson Algorithm",sff);

	}
    
    public static void runAlgorithm(String algorithm, ScalingFordFulkerson sff) {
		int times = 5;
		long[] runtime = new long[times];
		long start = 0;
		double maxFlow = 0;
		System.out.println("->Test for " + algorithm);
		for (int i = 0; i < times; i++) {
			start = System.currentTimeMillis();
			if (algorithm.equals("Scaling Ford Fulkerson Algorithm")) {
				maxFlow = sff.getMaxFlow();
			}
			runtime[i] = System.currentTimeMillis() - start;
		}
		long result = getAve(runtime);
		System.out.println(algorithm + ": Max flow: " + maxFlow);
		System.out.println(algorithm + ": Running time: " + result + " millisecond");
	}
    
    public static long getAve(long[] runtime) {
		long sum = 0;
		int length = runtime.length;
		for (int i = 0; i < length; i++) {
			sum += runtime[i];
		}
		return sum / length;
	}
    public void testPerformance() {
		System.out.println("Test three algorithms for 5 times based on testcases we created");
		System.out.println("-----------------------------------------------------------");
		String[] graphTypes = { "./src/Bipartite", "./src/FixedDegree", "./src/Mesh", "./src/Random" };
		for (int i = 0; i < graphTypes.length; i++) {
			File folder = new File(graphTypes[i]);
			File[] testScenarios = folder.listFiles();
			for (int j = 0; j < testScenarios.length; j++) {
				File[] testcases = testScenarios[j].listFiles();
				for (int k = 0; k < testcases.length; k++) {
					SimpleGraph G = new SimpleGraph();
					GraphInput.LoadSimpleGraph(G, testcases[k].getPath());
					ScalingFordFulkerson sff = new ScalingFordFulkerson(G);
					System.out.println("----------------************test for" + testcases[k].getPath()
							+ "************----------------");
					
					// Scaling Ford Fulkerson Algorithm
					runAlgorithm("Scaling Ford Fulkerson Algorithm", sff);

				}
			}
		}
	}

}
