
public class Main {
    public static void main(String[] args) {

        DataSet dataSet = new DataSet();
        EstadisticaDescriptiva ed = new EstadisticaDescriptiva();
        TablaDescriptiva t = new TablaDescriptiva();

        double[][] conjuntoDataSet = new double[1][];


        for (int i = 0; i < conjuntoDataSet.length; i++) {
            conjuntoDataSet[i] = dataSet.getDataset(i + 1);
        }

        for (int i=0;i<conjuntoDataSet.length;i++){

            double rango = ed.getRango(conjuntoDataSet[i]);
            int intervalo = ed.getIntervalo(conjuntoDataSet[i]);
            int amplitud = ed.getAmplitud(intervalo, rango);
            double[][] clases = ed.getClases(conjuntoDataSet[i], intervalo, amplitud);

            System.out.println();
            System.out.println();
            System.out.println("Rango: "+rango+"     Intervalo: "+intervalo+"      Numero de Clases: "+clases.length+"      Amplitud: "+amplitud+"            CantidadDatos: "+conjuntoDataSet[i].length);


            double[][] DescriptiveTable = t.getTablaDescriptiva(clases, conjuntoDataSet[i]);
            String[] s = {"Clases", "Limiteinferior", "LimiteSuperior", "Frecuencia", " PuntoMedio", "FrecuenciaAcumulada", "FrecuenciaRelativa", "FrecuenciaRelativaAcum", "Porcentaje"};
            System.out.println("Clases          Limiteinferior          LimiteSuperior          Frecuencia             PuntoMedio          FrecuenciaAcumulada          FrecuenciaRelativa          FrecuenciaRelativaAcum          Porcentaje");
            for (int k = 0; k < DescriptiveTable.length; k++) {
                for (int l = 0; l < 9; l++) {
                    double value = DescriptiveTable[k][l];
                    System.out.print(value);

                    int numEspacios = s[l].length() - (String.valueOf(value).length());

                    for (int m = 0; m <= numEspacios+9; m++) {
                        System.out.print(" ");
                    }

                }
                System.out.println();
            }

        }

    }
}