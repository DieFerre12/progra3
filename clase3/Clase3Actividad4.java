import java.util.ArrayList;
import java.util.List;

public class Clase3Actividad4 {

    public static void main(String[] args) {
        // Crear una instancia de TopNElements
        TopNElements topNElements = new TopNElements();

        // Crear una lista de números
        List<Integer> numbers = new ArrayList<>(List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));
        int n = 3;

        // Encontrar los n elementos más grandes
        List<Integer> topN = topNElements.findTopNElements(numbers, n);

        // Mostrar los resultados
        System.out.println("Los " + n + " elementos más grandes son: " + topN);
    }

    public static class TopNElements {

        // Función principal para encontrar los n elementos más grandes
        public List<Integer> findTopNElements(List<Integer> list, int n) {
            if (list == null || n <= 0) {
                return new ArrayList<>();
            }
            return findTopNElementsRecursive(list, n);
        }

        // Método recursivo para encontrar los n elementos más grandes
        private List<Integer> findTopNElementsRecursive(List<Integer> list, int n) {
            if (list.size() <= n) {
                // Caso base: la lista es pequeña, simplemente ordena y toma los primeros n elementos
                list.sort((a, b) -> b - a);
                return new ArrayList<>(list.subList(0, list.size()));
            }

            // Divide la lista en dos mitades
            int mid = list.size() / 2;
            List<Integer> left = new ArrayList<>(list.subList(0, mid));
            List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

            // Encuentra los n elementos más grandes en ambas mitades
            List<Integer> leftTopN = findTopNElementsRecursive(left, n);
            List<Integer> rightTopN = findTopNElementsRecursive(right, n);

            // Combina los resultados y encuentra los n elementos más grandes
            return mergeTopN(leftTopN, rightTopN, n);
        }

        // Combina dos listas y encuentra los n elementos más grandes
        private List<Integer> mergeTopN(List<Integer> leftTopN, List<Integer> rightTopN, int n) {
            List<Integer> merged = new ArrayList<>(leftTopN);
            merged.addAll(rightTopN);

            // Ordena la lista combinada en orden descendente
            merged.sort((a, b) -> b - a);

            // Toma los primeros n elementos
            return new ArrayList<>(merged.subList(0, Math.min(n, merged.size())));
        }
    }
}
