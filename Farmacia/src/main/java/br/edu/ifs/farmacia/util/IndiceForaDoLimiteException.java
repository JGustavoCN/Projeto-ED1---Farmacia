package br.edu.ifs.farmacia.util;

/**
 *
 * @author José Gustavo
 */
//Não posso ter uma classe Exception dentro de uma classe que possua Generic, por isso o static
public class IndiceForaDoLimiteException extends VirtualMachineError {

    public IndiceForaDoLimiteException() {
    }

    public IndiceForaDoLimiteException(String message) {
        super(message);
    }

    public IndiceForaDoLimiteException(int indice) {
        super("Indice fora do intervalo do vetor: " + indice);
    }
}
