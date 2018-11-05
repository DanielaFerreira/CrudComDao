
public class Departamento {

    private int codigo;
    private String nome;
    private String sigla;

    /**
     * Construtor vazio.
     */
    public Departamento() {
        this.codigo = 0;
        this.nome = "";
        this.sigla = "";
    }

    /**
     * Construtor com parametros.
     *
     * @param codigo
     * @param nome
     * @param sigla
     */
    public Departamento(int codigo, String nome, String sigla) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

    /* Getters & Setters */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
	
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

}
