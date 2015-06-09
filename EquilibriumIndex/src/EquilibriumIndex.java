import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 
 */

/**
 * @author Szymon Iwañski
 *
 */
public class EquilibriumIndex {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int tabLength = 0;
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Podaj rozmiar losowej tablicy: ");
		tabLength = Integer.parseInt(bufferedReader.readLine());
		
		long tab[] = new long[tabLength];
		Random rand = new Random();
		
		System.out.println("Wygenerowana tablica: ");
		for (int i = 0; i < tabLength; i++) {
			tab[i] = rand.nextLong();
			System.out.print(tab[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("\n" + equilibrium1(tab));
		System.out.println();
		System.out.println("\n" + equilibrium2(tab));
	}
	
	public static int equilibrium1(long tab[]) {
		/* Solution no. 1 */
		int lSum, rSum, i, j;
		int n = tab.length;
		
		for (i = 0; i < n; i++) {
			lSum = 0;
			rSum = 0;
			
			for (j = 0; j < i; j++) lSum += tab[j];
			
			for (j = i + 1; j < n; j++) rSum += tab[j];
			
			if (lSum == rSum) {
				System.out.print("Nr znalezionego indeksu: ");
				return i;
			}
		}
		
		System.out.print("Nie znaleziono indeksu! Spróbuj ponownie. Zwrócona wartoœæ: ");
		return -1;
	} 

	public static int equilibrium2(long tab[]) {
		/* Solution no. 2 */
		int sum = 0;
		int lSum = 0;
		int i = 0;
		int n = tab.length;
		
		for (i = 0; i < n; ++i) sum += tab[i];
		
		for (i = 0; i < n; ++i) {
			sum -= tab[i];
			if (lSum == sum) {
				System.out.print("Nr znalezionego indeksu: ");
				return i;
			}
			lSum += tab[i];
		}
		
		System.out.print("Nie znaleziono indeksu! Spróbuj ponownie. Zwrócona wartoœæ: ");
		return -1;
	}
}
