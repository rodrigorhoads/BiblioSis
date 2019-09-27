package DML;

public class CategoriaDeLivros {

    private int id;
    private int CodigoCategoria;
    private String DescCategoria;
    private int NrMaximoDiaEmprestimo;
    private double VlrMultaDiaAtraso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoCategoria() {
        return CodigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        CodigoCategoria = codigoCategoria;
    }

    public String getDescCategoria() {
        return DescCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        DescCategoria = descCategoria;
    }

    public int getNrMaximoDiaEmprestimo() {
        return NrMaximoDiaEmprestimo;
    }

    public void setNrMaximoDiaEmprestimo(int nrMaximoDiaEmprestimo) {
        NrMaximoDiaEmprestimo = nrMaximoDiaEmprestimo;
    }

    public double getVlrMultaDiaAtraso() {
        return VlrMultaDiaAtraso;
    }

    public void setVlrMultaDiaAtraso(double vlrMultaDiaAtraso) {
        VlrMultaDiaAtraso = vlrMultaDiaAtraso;
    }
}
