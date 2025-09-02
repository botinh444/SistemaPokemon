
public class Pokemon {
    private String especie;
    private String tipo;
    private int nivel;

    public Pokemon(String especie, String tipo, int nivel) {
        this.especie = especie;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public String getEspecie() {
        return especie;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void exibirInformacoes() {
        System.out.println("Espécie: " + especie);
        System.out.println("Tipo: " + tipo);
        System.out.println("Nível: " + nivel);
        System.out.println("-------------------");
    }

    @Override
    public String toString() {
        return especie + " (Tipo: " + tipo + ", Nível: " + nivel + ")";
    }
}